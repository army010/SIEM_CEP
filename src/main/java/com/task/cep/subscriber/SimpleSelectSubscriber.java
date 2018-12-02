package com.task.cep.subscriber;


import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SimpleSelectSubscriber implements StatementSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleSelectSubscriber.class);


    public String getStatement() {

        String select = "select * from SyslogEvent(message = 'Login Failed') having count(*) > 10";

        return select;

    }



    public void update(Map<String, SyslogEvent> eventMap) {

    }

    @Override
    public void schemaCreationEvent(EPAdministrator admin) {

    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {
        statement.addListener(eventListener);
    }

}
