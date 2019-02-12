package com.task.cep.subscriber;


import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.AntiVirusListener;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BruteForceSubscriber implements StatementSubscriber {
    private static final Logger LOG = LoggerFactory.getLogger(BruteForceSubscriber.class);


    public String getStatement() {

        String select = //" insert into AlertBucket(user, message, date, src, eventID) " +
                " select user, message, date, src, eventID" +
                " from SyslogEvent(message = 'An Account failed to Log on').std:groupwin(src).win:time_length_batch(60 sec, 20)";

        return select;

    }

    //String select = " select * from AlertBucket.std:groupwin(src).win:time_length_batch(60 sec, 3)";


    public void update(Map<String, SyslogEvent> eventMap) {

        //LOG.debug("Multiple Login Failed Detected");

    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {
        statement.addListener(eventListener);
    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }

    @Override
    public void addListener(AntiVirusListener antiVirusListener, EPStatement statement) {

    }

}
