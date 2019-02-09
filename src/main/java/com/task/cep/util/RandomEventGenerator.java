package com.task.cep.util;

import static java.lang.System.*;

import java.io.IOException;
import java.util.Scanner;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.task.cep.event.SymlogEvent;
import com.task.cep.event.WeblogEvent;
import com.task.cep.handler.EventHandler;
import com.task.cep.handler.JsonFileParser;
import java.io.IOException;
import java.util.List;


import com.task.cep.event.*;

import com.task.cep.handler.EventHandler;

/**
 * Just a simple class to create a number of Random Events and pass them off to the
 * EventHandler.
 */
@Component
public class RandomEventGenerator {

    /** Logger */
    private static final Logger LOG = LoggerFactory.getLogger(RandomEventGenerator.class);

    /**EventHandler - wraps the Esper engine and processes the Events  */
    @Autowired
    private EventHandler eventHandler;

    /**
     * Creates simple random events and lets the implementation class handle them.
     */
    public void startSendingEventReadingsVirus()  {
        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();
        xrayExecutor.submit(new Runnable() {
            public void run() {
                LOG.debug(getStartingMessage());
                JsonFileParser parser = new JsonFileParser();
                List<WeblogEvent> weblogEventList;
                List<SymlogEvent> symlogEventList;

                try {
                    weblogEventList = parser.getWebEvents();
                    symlogEventList = parser.getSymEvents();
                    for (WeblogEvent event : weblogEventList) {
                        Thread.sleep(200);
                        eventHandler.handle(event);
                    }

                    for (SymlogEvent event : symlogEventList) {
                        Thread.sleep(2000);
                        eventHandler.handle(event);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    LOG.error("Jsonparser got an error", e);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    LOG.error("Thread Interrupted", e);
                }

            }
        });
    }

    public void startSendingEventReadings(final long noOfEvents) {

        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();




        xrayExecutor.submit(new Runnable() {
            public void run() {

                LOG.debug(getStartingMessage());

                int count = 0;

                Random r = new Random();
                int low = 10;
                int high = 100;
                int port;
                String[] marker = {"m1", "m2", "m3"};
                String[] src = {"192.168.1.103", "192.107.1.205", "172.168.2.205"};
                String[] dst = {"192.168.1.105", "192.107.1.204", "172.168.2.200"};
                String[] user = {"yx349", "ao456", "ku565"};
                String[] msglogin = {"An account was successfully logged on", "An Account failed to Log on"};


                while (count < noOfEvents) {

                   /*SyslogEvent log1 = new SyslogEvent(user[r.nextInt(user.length)], msglogin[r.nextInt(msglogin.length)], 20190112, src[r.nextInt(src.length)], 4625);
                   eventHandler.handle(log1);


                   if (count%35 == 0) {
                       SyslogEvent log2 = new SyslogEvent(user[r.nextInt(user.length)], "Special privileges assigned to new logon", 20190112, src[r.nextInt(src.length)], 4672);
                       eventHandler.handle(log2);
                   }

                    //SSH Logs
                   SyslogEvent log3 = new SyslogEvent(user[r.nextInt(user.length)], "Failed Password", 20190112, src[r.nextInt(src.length)],
                           dst[r.nextInt(dst.length)], 22);
                   eventHandler.handle(log3);*/


//                    port = r.nextInt(high-low) + low;
//
//                   IPlogEvent log = new IPlogEvent(src[r.nextInt(src.length)],dst[r.nextInt(dst.length)],port, marker[r.nextInt(marker.length)]);
//                   eventHandler.handle(log);


                    // Following Code is in relation to DDoS Attack
                    makeDdosAttack(count);
                    count++;

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        LOG.error("Thread Interrupted", e);
                    }

                }

            }
        });
    }

    public void makeDdosAttack(int count){
        ServerLogEvent log2  = new ServerLogEvent("","192.168.1.103","","","","","","","","","","","","");
        eventHandler.handleServerlog(log2);
        ServerLogEvent log4  = new ServerLogEvent("","192.107.1.205","","","","","","","","","","","","");
        ServerLogEvent log5  = new ServerLogEvent("","192.107.1.206","","","","","","","","","","","","");
        ServerLogEvent log6  = new ServerLogEvent("","192.107.1.207","","","","","","","","","","","","");
        ServerLogEvent log7  = new ServerLogEvent("","192.107.1.208","","","","","","","","","","","","");
        ServerLogEvent log3  = new ServerLogEvent("","192.107.1.204","","","","","","","","","","","","");
        ServerLogEvent log8  = new ServerLogEvent("","192.107.1.205","","","","","","","","","","","","");
        ServerLogEvent log9  = new ServerLogEvent("","192.107.1.206","","","","","","","","","","","","");
        ServerLogEvent log10  = new ServerLogEvent("","192.107.1.207","","","","","","","","","","","","");
        ServerLogEvent log11  = new ServerLogEvent("","192.107.1.208","","","","","","","","","","","","");
        ServerLogEvent log12  = new ServerLogEvent("","192.107.1.204","","","","","","","","","","","","");
        ServerLogEvent log13  = new ServerLogEvent("","192.107.1.204","","","","","","","","","","","","");
        ServerLogEvent log14  = new ServerLogEvent("","192.107.1.205","","","","","","","","","","","","");
        ServerLogEvent log15 = new ServerLogEvent("","192.107.1.206","","","","","","","","","","","","");
        ServerLogEvent log16  = new ServerLogEvent("","192.107.1.207","","","","","","","","","","","","");
        ServerLogEvent log17  = new ServerLogEvent("","192.107.1.208","","","","","","","","","","","","");
        ServerLogEvent log18  = new ServerLogEvent("","192.107.1.204","","","","","","","","","","","","");

        eventHandler.handleServerlog(log3);
        eventHandler.handleServerlog(log4);
        eventHandler.handleServerlog(log5);
        eventHandler.handleServerlog(log6);
        eventHandler.handleServerlog(log7);
        eventHandler.handleServerlog(log8);
        eventHandler.handleServerlog(log9);
        eventHandler.handleServerlog(log10);
        eventHandler.handleServerlog(log11);
        eventHandler.handleServerlog(log12);
        eventHandler.handleServerlog(log13);
        eventHandler.handleServerlog(log14);
        eventHandler.handleServerlog(log15);
        eventHandler.handleServerlog(log16);
        eventHandler.handleServerlog(log17);
        eventHandler.handleServerlog(log18);


    }

    private String getStartingMessage(){
        return "\n\n************************************************************" +
                "\n* STARTING - " +
                "\n* PLEASE WAIT - EVENT VALUES ARE RANDOM, SO MAY TAKE" +
                "\n* A WHILE TO SEE WARNING AND CRITICAL EVENTS!" +
                "\n************************************************************\n";
    }

}
