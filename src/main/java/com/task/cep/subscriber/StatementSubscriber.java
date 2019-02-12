package com.task.cep.subscriber;

import com.espertech.esper.client.EPStatement;
import com.task.cep.handler.AntiVirusListener;
import com.task.cep.handler.EventListener;
import com.task.cep.handler.EventListener2;

/**
 * Just a convenience interface to let us easily contain the Esper statements with the Subscribers -
 * just for clarity so it's easy to see the statements the subscribers are registered against.
 */
public interface StatementSubscriber {

    /**
     * Get the EPL Statement the Subscriber will listen to.
     *
     * @return EPL Statement
     */
    String getStatement();

    void addListener(EventListener eventListener, EPStatement statement);

    void addListener(EventListener2 eventListener, EPStatement statement);

    void addListener(AntiVirusListener antiVirusListener, EPStatement statement);
}
