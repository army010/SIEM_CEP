package com.task.cep.subscriber.dDosSubscribers;

import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import com.task.cep.subscriber.StatementSubscriber;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UpperTresholdQuery implements StatementSubscriber {
    @Override
    public String getStatement() {
        return "INSERT INTO upperTreshold\n" +
                "SELECT mean.value + Math.max(0.50*fe.value,30) AS value,\n" +
                "fe.value as std_dev, mean.value AS mean\n" +
                "FROM weigthedMean.std:lastevent() AS mean, stddevError\n" +
                "AS fe unidirectional WHERE fe.value is not null";
    }

    public void update(Map<String, SyslogEvent> eventMap) {

    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {

    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }
}
