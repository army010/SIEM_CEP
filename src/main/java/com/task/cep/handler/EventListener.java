package com.task.cep.handler;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventListener implements UpdateListener {
    private static final Logger LOG = LoggerFactory.getLogger(EventListener.class);

    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        if (newEvents == null) {
            // we don't care about events leaving the window (old events)
            return;
        }

        EventBean theEvent = newEvents[0];

        LOG.debug(theEvent.getUnderlying().toString());

        //log.debug(theEvent.toString());
        LOG.debug("Multiple Login Failed Detected!");
    }
}


