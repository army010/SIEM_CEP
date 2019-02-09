package com.task.cep.subscriber.dDosSubscribers;

import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import com.task.cep.subscriber.StatementSubscriber;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CusumSumQuery implements StatementSubscriber {
    @Override
    public String getStatement() {
        return "INSERT INTO cusumSum SELECT Math.max(prevSum.value +\n" +
                "(currValue.value*9 - upTreshold.value),0) AS value,\n" +
                "currValue.value AS currValue, prevSum.value\n" +
                "AS prevSum, upTreshold.value AS upTreshold\n" +
                "FROM SummedConnectionCount AS currValue unidirectional,\n" +
                "upperTreshold.std:lastevent() AS upTreshold,\n" +
                "cusumSum.std:lastevent() AS prevSum";
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
