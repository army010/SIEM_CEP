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
public class PortScanOne implements StatementSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(PortScanOne.class);


    public String getStatement() {

        String statement = "into table ScanCountTable " +
                "insert into CountStream " +
                "select src, dst, count(*) as cnt, window(*) as win " +
                "from IPlogEvent#unique(src, dst, dst_port)#time(30 sec) group by src,dst";

        return statement;

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
