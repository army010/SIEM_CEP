package com.task.cep.subscriber;


import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
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

        String select = " insert into AlertBucket(user, message, date, src, eventID) select user, message, date, src, eventID" +
                " from SyslogEvent(message = 'An Account failed to Log on').std:groupwin(src).win:time_length_batch(60 sec, 20)";
                //" from SyslogEvent(message = 'Login Failed').std:groupwin(user).win:expr(current_count = 1)";

        return select;

    }



    public void update(Map<String, SyslogEvent> eventMap) {

    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {
        statement.addListener(eventListener);
    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }

}
