package com.task.cep.subscriber;


import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SymlogEvent;
import com.task.cep.event.SyslogEvent;
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
        String select = "insert into SymlogEvent(scanner,threat, action,information,ipaddress) select b_scanner,b_threat, b_action,b_information,b_ipaddress from SymlogEvent"+
                "select a_scanner,a_threat, a_action,a_information,a_ipaddress from WeblogEvent"
                // String select = "select * from SyslogEvent.win:time(5 sec) "
                + "match_recognize ( "
                + "       measures A.ipaddress as a_IPaddress, B.ipaddress as b_IPaddress, A.action as a_action, B.action as b_action"
                + "       pattern (A B) "
                + "       define "
                + "       A as A.action = 'connection not terminated' and "
                + "       B as B.action = 'not deleted' )";

        return select;

    }



    public void update(Map<String, SymlogEvent> eventMap) {

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
