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
public class SimpleSelectSubscriber implements StatementSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleSelectSubscriber.class);


    public String getStatement() {

        String select = "insert into PortScanEvent(src, dst, port, marker) select ip.getSrc().toString(), ip.getDst(), ip.getDst_port(), ip.getMarker() from pattern" +
                "[every ip = IPlogEvent]";

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

    @Override
    public void addListener(AntiVirusListener antiVirusListener, EPStatement statement) {

    }

}
