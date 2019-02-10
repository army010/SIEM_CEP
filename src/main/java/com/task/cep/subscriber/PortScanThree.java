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
public class PortScanThree implements StatementSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(PortScanThree.class);


    public String getStatement() {

        String statement = "on pattern [every timer:at(*, *, *, *, *)] " +
                "insert into OutputAlerts " +
                "select 'UPDATE' as type, ScanCountTable[src, dst].cnt as cnt, ScanCountTable[src, dst].win as contributors " +
                "from SituationsWindow sc";

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
