package com.task.cep.subscriber;


import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.AntiVirusListener;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import com.task.cep.handler.PortScanListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PortScanOutput implements StatementSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(PortScanOutput.class);


    public String getStatement() {

        String statement = "@name('output') select * from OutputAlerts";

        return statement;

    }


    public void update(Map<String, SyslogEvent> eventMap) {

    }


    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {
        //statement.addListener(eventListener);
    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }

    @Override
    public void addListener(AntiVirusListener antiVirusListener, EPStatement statement) {

    }

    public void addListener(PortScanListener eventListener, EPStatement statement) {
        statement.addListener(eventListener);

    }
}
