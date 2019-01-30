package com.task.cep.subscriber;


import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PortScanFour implements StatementSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(PortScanFour.class);


    public String getStatement() {

        String statement = "on pattern [every timer:at(*, *, *, *, *)] " +
                "merge SituationsWindow sw " +
                "when matched and (select cnt from ScanCountTable where src = sw.src and dst = sw.dst) < 10 " +
                "  then delete " +
                "  then insert into OutputAlerts select 'DONE' as type, ScanCountTable[src, dst].cnt as cnt, null as contributors " +
                "when matched and detectionTime.after(current_timestamp, 16 hours) " +
                "  then delete " +
                "  then insert into OutputAlerts select 'EXPIRED' as type, -1L as cnt, null as contributors";

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
