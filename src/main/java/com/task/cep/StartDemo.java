package com.task.cep;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.task.cep.util.RandomEventGenerator;

import java.io.IOException;


/**
 * Entry point for the Demo. Run this from your IDE, or from the command line using 'mvn exec:java'.
 */
class StartDemo {

    /** Logger */
    private static final Logger LOG = LoggerFactory.getLogger(StartDemo.class);


    /**
     * Main method - start the Demo!
     */
    public static void main(String[] args) throws IllegalArgumentException, IOException {


        LOG.debug("Starting...");

        HttpServer server = HttpServerFactory.create("http://localhost:8080/api");

        server.start();

        long noOfEvents = 1000;

        if (args.length != 1) {
            LOG.debug("No override of number of events detected - defaulting to " + noOfEvents + " events.");
        } else {
            noOfEvents = Long.valueOf(args[0]);
        }

        // Load spring config

        // Start Demo
       // RandomEventGenerator generator = (RandomEventGenerator) ((BeanFactory) new ClassPathXmlApplicationContext(new String[]{"application-context.xml"})).getBean("eventGenerator");
       // generator.startSendingEventReadings(noOfEvents);

    }

}

