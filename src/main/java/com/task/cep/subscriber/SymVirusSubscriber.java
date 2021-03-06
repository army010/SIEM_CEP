package com.task.cep.subscriber;

import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SymlogEvent;
import com.task.cep.handler.AntiVirusListener;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class SymVirusSubscriber implements StatementSubscriber {
    private static final Logger LOG = LoggerFactory.getLogger(SymVirusSubscriber.class);


    public String getStatement() {

        String SymLogQuery = "Insert into AlertAntivirusBuckets(type,time,user, "+
                                 "scanner,object,threat,action,information,hash,ipaddress) " +
                                 "select type,time,user,scanner,object,threat,action,information,hash,ipaddress " +
                                 "from SymlogEvent(action = 'not deleted')#unique(ipaddress) having count(*) > 0";

        return SymLogQuery;
    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {
        // statement.addListener(eventListener);
    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }

    public void addListener(AntiVirusListener antiVirusListener, EPStatement statement) {
        statement.addListener(antiVirusListener);

    }

    public void update(Map<String, SymlogEvent> eventMap) {
        // required by springframe work
        String sb = "* Match Found  for SymVirus \n";
        LOG.info(sb);
    }

}
