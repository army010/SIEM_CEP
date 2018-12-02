package com.task.cep.subscriber;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPStatement;
import com.task.cep.handler.EventListener;

/**
 * Just a convenience interface to let us easily contain the Esper statements with the Subscribers -
 * just for clarity so it's easy to see the statements the subscribers are registered against.
 */
public interface StatementSubscriber {

    /**
     * Get the EPL Statement the Subscriber will listen to.
     * @return EPL Statement
     */
    String getStatement();

    void schemaCreationEvent(EPAdministrator admin);

    void addListener(EventListener eventListener, EPStatement statement);
}
