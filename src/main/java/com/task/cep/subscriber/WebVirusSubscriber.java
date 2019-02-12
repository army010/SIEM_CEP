package com.task.cep.subscriber;

import com.espertech.esper.client.EPStatement;
import com.task.cep.event.WeblogEvent;
import com.task.cep.handler.AntiVirusListener;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WebVirusSubscriber implements StatementSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(WebVirusSubscriber.class);

    public String getStatement() {
        String WebLogQuery = "Insert into AlertAntivirusBuckets(type,time,user,scanner,object,"+
                                 "threat,action,information,hash,ipaddress) " +
                                 "select type,time,user,scanner,object,threat,action,information,hash,ipaddress " +
                                 "from WeblogEvent((action = 'connection not terminated')) having count(*) > 0";

        return WebLogQuery;
    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {
        // statement.addListener(eventListener);
    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }

    public void update(Map<String, WeblogEvent> eventMap) {
        // required by springframe work
        String sb = "\n* Match Found  for WebVirus \n";
        LOG.info(sb);

    }

    public void addListener(AntiVirusListener antiVirusListener, EPStatement statement) {
        statement.addListener(antiVirusListener);
    }
}
