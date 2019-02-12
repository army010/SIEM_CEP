package com.task.cep.subscriber;


import com.espertech.esper.client.EPStatement;
import com.task.cep.event.AlertAntivirusBuckets;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import com.task.cep.handler.AntiVirusListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MultipleAntivirusSubscriber implements StatementSubscriber {
    private static final Logger LOG = LoggerFactory.getLogger(MultipleAntivirusSubscriber.class);

    public String getStatement() {

//        String MultipleVirusAlert = "Insert into AlertAntivirusBuckets (user,ipaddress) " +
//                " Select web.getUser(), web.getIpaddress() from " +
//                " WeblogEvent(action = 'connection not terminated' ).std:unique(ipaddress) as web," +
//                " SymlogEvent(action = 'not deleted').std:unique(ipaddress).win:time(3 sec) as sym " +
//                " where web.getIpaddress() = sym.getIpaddress()";

//        String MultipleVirusAlert =  "select alert.user,alert.ipaddress from AlertAntivirusBuckets#unique(ipaddress) as alert,\n" +
//                "WeblogEvent(action = 'connection not terminated' ).std:unique(ipaddress) as web,"+
//                "SymlogEvent(action = 'not deleted').std:unique(ipaddress).win:time(3 sec) as sym"+
//                " where web.getIpaddress() = sym.getIpaddress()";
//
//
//
        String MultipleVirusAlert = " select t.user,t.ipaddress from AlertAntivirusBuckets#time(3 sec) as t," +
                "WeblogEvent(action = 'connection not terminated' )#unique(ipaddress) as n," +
                "SymlogEvent(action = 'not deleted')#unique(ipaddress)#time(3 sec) as m \n" +
                "where m.ipaddress = n.ipaddress";


        return MultipleVirusAlert;

    }


    public void update(Map<String, AlertAntivirusBuckets> eventMap) {
        String sb = "\n* Match  virus Found  for Web and Sym within 3 second \n";
        LOG.info(sb);
    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {

    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }

    public void addListener(AntiVirusListener antiVirusListener, EPStatement statement) {
        statement.addListener(antiVirusListener);
    }


}
