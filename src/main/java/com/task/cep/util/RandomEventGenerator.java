package com.task.cep.util;

import static java.lang.System.*;
import java.util.Scanner;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


                    port = r.nextInt(high-low) + low;

                   IPlogEvent log = new IPlogEvent(src[r.nextInt(src.length)],dst[r.nextInt(dst.length)],port, marker[r.nextInt(marker.length)]);
                   eventHandler.handle(log);

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

    private String getStartingMessage(){
        return "\n\n************************************************************" +
                "\n* STARTING - " +
                "\n* PLEASE WAIT - EVENT VALUES ARE RANDOM, SO MAY TAKE" +
                "\n* A WHILE TO SEE WARNING AND CRITICAL EVENTS!" +
                "\n************************************************************\n";
    }

}
