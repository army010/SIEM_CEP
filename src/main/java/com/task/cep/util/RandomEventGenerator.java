package com.task.cep.util;

import com.task.cep.event.*;
import com.task.cep.handler.EventHandler;
import com.task.cep.handler.JsonFileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Just a simple class to create a number of Random Events and pass them off to the
 * EventHandler.
 */


@Component
public class RandomEventGenerator {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(RandomEventGenerator.class);
    public Random r = new Random();
    public int low = 10;
    public int high = 200;
    public String[] marker = {"m1", "m2", "m3"};
    public String[] src = {"192.168.0.106", "192.168.0.121", "192.168.0.111"};
    public String[] dst = {"192.168.0.103","192.168.221.128", "192.168.221.204"};
    public String[] user = {"yx349", "ao456", "ku565","army010"};
    public String[] msglogin = {"An account was successfully logged on", "An Account failed to Log on"};
    /**
     * EventHandler - wraps the Esper engine and processes the Events
     */
    @Autowired
    private EventHandler eventHandler;

    /**
     * Creates simple random events and lets the implementation class handle them.
     */


    public void startSendingEventReadings(final long noOfEvents) {

        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();

        xrayExecutor.submit(new Runnable() {
            public void run() {

                LOG.debug(getStartingMessage());

                int count = 0;

                while (count < noOfEvents) {

                    oslogs(count);
                    sshlogs(count);
                    iplogs(count);

                    // Following Code is in relation to DDoS Attack
                    makeDdosAttack(count);
                    count++;

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        LOG.error("Thread Interrupted", e);
                    }

                }

            }
        });
    }

    public void startSendingEventReadingsVirus() {
        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();
        xrayExecutor.submit(new Runnable() {
            public void run() {
                //LOG.debug(getStartingMessage());
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
                        Thread.sleep(500);
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

    public void makeDdosAttack(int count) {
        ServerLogEvent log2 = new ServerLogEvent("", "192.168.1.103", "", "", "", "", "", "", "", "", "", "", "", "");
        eventHandler.handleServerlog(log2);
        ServerLogEvent log4 = new ServerLogEvent("", "192.107.1.205", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log5 = new ServerLogEvent("", "192.107.1.206", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log6 = new ServerLogEvent("", "192.107.1.207", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log7 = new ServerLogEvent("", "192.107.1.208", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log3 = new ServerLogEvent("", "192.107.1.204", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log8 = new ServerLogEvent("", "192.107.1.205", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log9 = new ServerLogEvent("", "192.107.1.206", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log10 = new ServerLogEvent("", "192.107.1.207", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log11 = new ServerLogEvent("", "192.107.1.208", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log12 = new ServerLogEvent("", "192.107.1.204", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log13 = new ServerLogEvent("", "192.107.1.204", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log14 = new ServerLogEvent("", "192.107.1.205", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log15 = new ServerLogEvent("", "192.107.1.206", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log16 = new ServerLogEvent("", "192.107.1.207", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log17 = new ServerLogEvent("", "192.107.1.208", "", "", "", "", "", "", "", "", "", "", "", "");
        ServerLogEvent log18 = new ServerLogEvent("", "192.107.1.204", "", "", "", "", "", "", "", "", "", "", "", "");

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

    public void oslogs(int count) {

        SyslogEvent log1 = new SyslogEvent(user[r.nextInt(user.length)], msglogin[r.nextInt(msglogin.length)], 20190112, src[r.nextInt(src.length)], 4625);
        eventHandler.handle(log1);


        while (count % 45 == 0) {
            SyslogEvent log2 = new SyslogEvent(user[r.nextInt(user.length)], "Special privileges assigned to new logon", 20190112, src[r.nextInt(src.length)], 4672);
            eventHandler.handle(log2);
            count++;
        }

    }

    public void sshlogs(int count) {

        while (count % 33 == 0) {
            SyslogEvent log3 = new SyslogEvent(user[r.nextInt(user.length)], "Failed Password", 20190112, src[r.nextInt(src.length)],
                    dst[r.nextInt(dst.length)], 22);
            eventHandler.handle(log3);
            count++;
        }

    }

    public void iplogs(int count) {

        IPlogEvent log = new IPlogEvent(src[r.nextInt(src.length)], dst[r.nextInt(dst.length)], r.nextInt(high - low) + low, marker[r.nextInt(marker.length)]);
        eventHandler.handle(log);

    }

    private String getStartingMessage() {
        return "\n\n************************************************************" +
                "\n* STARTING - " +
                "\n* PLEASE WAIT - EVENT VALUES BEING READ, SO MAY TAKE" +
                "\n* A WHILE TO SEE ALL ALERTS!" +
                "\n************************************************************\n";
    }

}
