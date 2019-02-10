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

        String checkAB = "Insert into AlertAntivirusBuckets (user,ipaddress) "+
                " Select web.getUser(), web.getIpaddress() from " +
                " WeblogEvent(action = 'connection not terminated' ).std:unique(ipaddress) as web,"+
                " SymlogEvent(action = 'not deleted').win:time(3 sec) as sym "+
                " where web.getIpaddress() = sym.getIpaddress()";

        return checkAB;

    }



    public void update(Map<String, AlertAntivirusBuckets> eventMap) {
        String sb = "***************************************" +
                "\n* Match  virus Found  for Web and Sym within 3 second \n" +
                "\n**************************************";
        LOG.info(sb);
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
