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
public class PortScanTwo implements StatementSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(PortScanTwo.class);


    public String getStatement() {

        String statement = "on CountStream(cnt >= 20) as cs " +
                "merge SituationsWindow sw " +
                "where cs.src = sw.src and cs.dst = sw.dst " +
                "when not matched " +
                "   then insert select src, dst, current_timestamp as detectionTime " +
                "   then insert into OutputAlerts select 'DETECTED' as type, cs.cnt as cnt, cs.win as contributors";

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
