package com.task.cep.handler;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;

public class PortScanListener implements UpdateListener {
    private static final Logger log = LoggerFactory.getLogger(PortScanListener.class);

    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        if (newEvents == null) {
            // we don't care about events leaving the window (old events)
            return;
        }

        EventBean theEvent = newEvents[0];

        log.debug(theEvent.getUnderlying().toString());
       // log.debug(theEvent.get("contributors").toString().replace("L",""));

        log.debug("Port Scan Detected!");
    }
}


