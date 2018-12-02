package com.task.cep.handler;

import com.espertech.esper.client.*;

import com.task.cep.event.SyslogEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.task.cep.subscriber.StatementSubscriber;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.UpdateListener;


@Component
@Scope(value = "singleton")
public class EventHandler implements InitializingBean {


    /** Logger */
    private static final Logger LOG = LoggerFactory.getLogger(EventHandler.class);

    /** Esper service */
    private EPServiceProvider epService;

    /** make your subscriber class as below */

    @Autowired
    @Qualifier("simpleSelectSubscriber")
    private StatementSubscriber simpleSelectSubscriber;



    /**
     * Configure Esper Statement(s).
     */
    private void initService() {

        LOG.debug("Initializing Service ..");
        Configuration config = new Configuration();

        config.addEventTypeAutoName("com.task.cep.event");
        epService = EPServiceProviderManager.getDefaultProvider(config);

        //Registering Events to Engine

        epService.getEPAdministrator().getConfiguration().addEventType(SyslogEvent.class);

        simpleSelect();




    }

    /**
     * EPL to check for a critical condition across events,*/


    public void simpleSelect(){
        LOG.debug("Simple Select to match 10 Login Failed .....");
        EPStatement statement = epService.getEPAdministrator().createEPL(simpleSelectSubscriber.getStatement());
        simpleSelectSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(simpleSelectSubscriber);
    }




    /**
     * Handle the incoming Event.
     */

    public void handle(SyslogEvent log)
    {
        LOG.debug(log.toString());

        epService.getEPRuntime().sendEvent(log);
    }




    @Override
    public void afterPropertiesSet() {

        LOG.debug("Configuring..");
        initService();
    }

    public void addListener(UpdateListener listener, EPStatement statement) {
        statement.addListener(listener);
    }
}
