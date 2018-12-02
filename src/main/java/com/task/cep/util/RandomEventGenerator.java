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

                while (count < noOfEvents) {

                    SyslogEvent log = new SyslogEvent(3, 2, "Login Failed", 20181205, "10.2.38.2", "10.2.52.6", "Alert", 389, 53313);
                    eventHandler.handle(log);
                    SyslogEvent log2 = new SyslogEvent(3, 2, "Login Successful", 20181205, "10.2.38.10", "10.2.12.65", "Alert", 389, 53313);
                    eventHandler.handle(log2);

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
