package com.task.cep.subscriber;


import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SshBruteForceSubscriber implements StatementSubscriber {
    private static final Logger LOG = LoggerFactory.getLogger(SshBruteForceSubscriber.class);


    public String getStatement() {

        String select = " select user, message, date, src, dst, dst_port" +
                " from SyslogEvent(dst_port = 22).std:groupwin(src).win:time_length_batch(30 sec, 60)";
                //" from SyslogEvent(message = 'Login Failed').std:groupwin(user).win:expr(current_count = 1)";

        return select;

    }



    public void update(Map<String, SyslogEvent> eventMap) {

    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {
        statement.addListener(eventListener);
    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {

    }

}
