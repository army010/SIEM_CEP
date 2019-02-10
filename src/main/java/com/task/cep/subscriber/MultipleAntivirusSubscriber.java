package com.task.cep.subscriber;


import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPStatement;
import com.task.cep.event.*;
import com.task.cep.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import com.task.cep.handler.AntiVirusListener;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import java.util.Map;

@Component
public class MultipleAntivirusSubscriber implements StatementSubscriber {
    private static final Logger LOG = LoggerFactory.getLogger(MultipleAntivirusSubscriber.class);


    public String getStatement() {

//                String select = "select * from WeblogEvent.std:unique(ipaddress) as wb"
//                + ",SymlogEvent.std:unique(ipaddress) as sym ";

        String select = " insert into BaseLogEvent(type,scanner,object,action,information,ipaddress) select type,scanner,object,action,information,ipaddress" +
                " from WeblogEvent.std:unique(ipaddress) as web, SymlogEvent.std:unique(ipaddress)";
        return select;

    }



    public void update(Map<String, WeblogEvent> eventMap) {

    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {

    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {
        //statement.addListener(eventListener);
    }
    public void addListener(AntiVirusListener antiVirusListener, EPStatement statement) {
        statement.addListener(antiVirusListener);

    }

}
