package com.task.cep.subscriber;


import com.espertech.esper.client.EPStatement;
import com.task.cep.event.IPlogEvent;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.AntiVirusListener;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import com.task.cep.handler.PortScanListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
public class PortScanOutput implements StatementSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(PortScanOutput.class);


    public String getStatement() {

        String statement = "@name('output') select type, cnt, Arrays.asList(contributors) from OutputAlerts";

        return statement;

    }

    public void update(Map<String, String> eventMap) {
/*
        // 1st Temperature in the Critical Sequence
        TemperatureEvent temp1 = (TemperatureEvent) eventMap.get("temp1");
        // 2nd Temperature in the Critical Sequence
        TemperatureEvent temp2 = (TemperatureEvent) eventMap.get("temp2");
        // 3rd Temperature in the Critical Sequence
        TemperatureEvent temp3 = (TemperatureEvent) eventMap.get("temp3");
        // 4th Temperature in the Critical Sequence
        TemperatureEvent temp4 = (TemperatureEvent) eventMap.get("temp4");

        StringBuilder sb = new StringBuilder();
        sb.append("***************************************");
        sb.append("\n* [ALERT] : CRITICAL EVENT DETECTED! ");
        sb.append("\n* " + temp1 + " > " + temp2 + " > " + temp3 + " > " + temp4);
        sb.append("\n***************************************");

        LOG.debug(sb.toString());*/
        //LOG.debug(eventMap.toString());


    }


    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {
        //statement.addListener(eventListener);
    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }

    @Override
    public void addListener(AntiVirusListener antiVirusListener, EPStatement statement) {

    }

    public void addListener(PortScanListener eventListener, EPStatement statement) {
        statement.addListener(eventListener);

    }
}
