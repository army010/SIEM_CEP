package com.task.cep.subscriber;

import com.espertech.esper.client.EPStatement;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.task.cep.event.WeblogEvent;
import java.util.Map;

@Component
public class WebVirusSubscriber implements StatementSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(WebVirusSubscriber.class);

    public String getStatement() {
        String logComplexQuery = "select * from WeblogEvent((type = 'file' AND action = 'connection not terminated'  AND information LIKE 'threat was detected %')) having count(*) > 0";

        //  String logComplexQuery = "select * from ViruslogEvent.win:expr_batch(current_count >= 1)";
        return logComplexQuery;
    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {
        statement.addListener(eventListener);
    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }

    public void update(Map<String, WeblogEvent> eventMap) {
    // required by springframe work
    }

}
