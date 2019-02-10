package com.task.cep.subscriber.dDosSubscribers;

import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import com.task.cep.subscriber.StatementSubscriber;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WeigthedMeanQuery implements StatementSubscriber {
    @Override
    public String getStatement() {
        return "INSERT INTO weigthedMean SELECT (0.9*x.value\n" +
                "+ 0.9*mean.value) AS value FROM SummedConnectionCount\n" +
                "AS x unidirectional, weigthedMean.std:lastevent() AS mean";
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
