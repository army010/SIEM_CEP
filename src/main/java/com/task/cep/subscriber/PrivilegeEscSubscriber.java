package com.task.cep.subscriber;


import com.espertech.esper.client.EPStatement;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.AntiVirusListener;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PrivilegeEscSubscriber implements StatementSubscriber {
    private static final Logger LOG = LoggerFactory.getLogger(PrivilegeEscSubscriber.class);


    public String getStatement() {

        /*String select = "select * from pattern [ ( every a = SyslogEvent(eventID = 4624) -> " +
                " ( b = SyslogEvent(eventID = 4672 ) ) ) ]";*/

       String select = "insert into AlertBucket(src, eventID, dst, eventID2) select a_src, a_ID, b_src, b_ID from SyslogEvent.win:time(5 sec) "
                + "match_recognize ( "
                + "       measures A.eventID as a_ID, B.eventID as b_ID, A.src as a_src, B.src as b_src"
                + "       pattern (A B) "
                + "       define "
                + "       A as A.eventID = 4625,"
                + "       B as B.eventID = 4672 and B.src = prev(B.src, 1) )";

        return select;

    }

    /*String select = "select * from AlertBucket.win:time(30 sec) "
            + "match_recognize ( "
            + "       measures A.eventID as a_ID, B.eventID as b_ID, C.eventID as c_id," +
            " A.src as a_src, B.src as b_src, C.src as c_src"
            + "       pattern (A B C) "
            + "       define "
            + "       A as A.eventID = 4625,"
            + "       B as B.eventID = 4624 and B.src = prev(B.src, 1),"
            + "       C as C.eventID = 4672 and C.src = prev(C.src, 1) )";*/





    public void update(Map<String, SyslogEvent> eventMap) {

    }

    @Override
    public void addListener(EventListener eventListener, EPStatement statement) {

    }

    @Override
    public void addListener(EventListener2 eventListener, EPStatement statement) {
        statement.addListener(eventListener);
    }

    @Override
    public void addListener(AntiVirusListener antiVirusListener, EPStatement statement) {

    }

}
