package com.task.cep.subscriber.dDosSubscribers;

import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.AntiVirusListener;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import com.task.cep.subscriber.StatementSubscriber;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class IPConnectionSumQuery implements StatementSubscriber {
    @Override
    public String getStatement() {
        return "INSERT INTO SummedIPConnectionCount SELECT incomingip,\n" +
                "sum(value) AS value FROM IPConnectionCount.win:time(1.5 sec)\n" +
                "GROUP BY incomingip output snapshot every 1.5 seconds";
    }

    public void update(Map<String, SyslogEvent> eventMap) {

    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {

    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }

    @Override
    public void addListener(AntiVirusListener antiVirusListener, EPStatement statement) {

    }
}
