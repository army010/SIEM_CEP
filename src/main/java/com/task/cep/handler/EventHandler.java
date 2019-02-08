package com.task.cep.handler;
import com.espertech.esper.client.*;
import com.task.cep.event.*;
import com.task.cep.subscriber.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.UpdateListener;
import java.util.List;

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

    @Autowired
    @Qualifier("portScanOne")
    private PortScanOne portScanOne;

    @Autowired
    @Qualifier("portScanTwo")
    private PortScanTwo portScanTwo;

    @Autowired
    @Qualifier("portScanThree")
    private PortScanThree portScanThree;

    @Autowired
    @Qualifier("portScanFour")
    private PortScanFour portScanFour;


    @Autowired
    @Qualifier("portScanOutput")
    private PortScanOutput portScanOutput;

    @Autowired
    @Qualifier("bruteForceSubscriber")
    private StatementSubscriber bruteForceSubscriber;

    @Autowired
    @Qualifier("privilegeEscSubscriber")
    private PrivilegeEscSubscriber privilegeEscSubscriber;

    @Autowired
    @Qualifier("sshBruteForceSubscriber")
    private SshBruteForceSubscriber sshBruteForceSubscriber;

    @Autowired
    @Qualifier("symVirusSubscriber")
    private SymVirusSubscriber symVirusSubscriber;

    @Autowired
    @Qualifier("webVirusSubscriber")
    private WebVirusSubscriber webVirusSubscriber;

    /**
     * Configure Esper Statement(s).
     */
    private void initService() {

        LOG.debug("Initializing Service ..");
        Configuration config = new Configuration();

        config.addEventTypeAutoName("com.task.cep.event");
        epService = EPServiceProviderManager.getDefaultProvider(config);

        //Registering Events to Engine


        epService.getEPAdministrator().getConfiguration().addEventType(IPlogEvent.class);
        epService.getEPAdministrator().getConfiguration().addEventType(SyslogEvent.class);
        epService.getEPAdministrator().getConfiguration().addEventType(AlertBucket.class);
        epService.getEPAdministrator().getConfiguration().addEventType(ViruslogEvent.class);

       // simpleSelect();
        DDoS();
        portScan();
        bruteForce();
        //privilegeEsc();
        sshBruteforce();
        symVirus();
        webVirus();
    }

    /**
     * EPL to check for a critical condition across events,*/


    public void simpleSelect(){
        LOG.debug("Login Failed .....");
        EPStatement statement = epService.getEPAdministrator().createEPL(simpleSelectSubscriber.getStatement());
        //simpleSelectSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(simpleSelectSubscriber);
    }
    public void symVirus() {
        LOG.info("Detect Malware Virus from the log file .....");
        EPStatement statement = epService.getEPAdministrator().createEPL(symVirusSubscriber.getStatement());
        symVirusSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(symVirusSubscriber);

    }

    public void webVirus() {
        LOG.info("Detect Malware Virus from the web .....");
        EPStatement statement = epService.getEPAdministrator().createEPL(webVirusSubscriber.getStatement());
        webVirusSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(webVirusSubscriber);
    }

    public void portScan(){
        LOG.debug("PortScan.................");
        //epService.getEPAdministrator().createEPL("create schema PortScanEvent(src string, dst string, port int, marker string)");
        epService.getEPAdministrator().createEPL("create table ScanCountTable(src string primary key, dst string primary key, cnt count(*), win window(*) @type(IPlogEvent))");
        epService.getEPAdministrator().createEPL("create window SituationsWindow#keepall() (src string, dst string, detectionTime long)");

        EPStatement statement;

        statement = epService.getEPAdministrator().createEPL(portScanOne.getStatement());
        //simpleSelectSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(portScanOne);


        statement = epService.getEPAdministrator().createEPL(portScanTwo.getStatement());
        //simpleSelectSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(portScanTwo);

        statement = epService.getEPAdministrator().createEPL(portScanThree.getStatement());
        //simpleSelectSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(portScanThree);


        statement = epService.getEPAdministrator().createEPL(portScanFour.getStatement());
        //simpleSelectSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(portScanFour);


        statement = epService.getEPAdministrator().createEPL(portScanOutput.getStatement());
        simpleSelectSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(portScanOutput);
    }


    public void bruteForce(){
        //LOG.debug("Simple Select to match 10 Login Failed .....");
        EPStatement statement = epService.getEPAdministrator().createEPL(bruteForceSubscriber.getStatement());
        bruteForceSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(bruteForceSubscriber);
    }

    public void privilegeEsc(){
        //LOG.debug("Simple Select to match Privilege escalation .....");
        EPStatement statement = epService.getEPAdministrator().createEPL(privilegeEscSubscriber.getStatement());
        privilegeEscSubscriber.addListener(new EventListener2(), statement);
        statement.setSubscriber(privilegeEscSubscriber);
    }

    public void sshBruteforce(){
        EPStatement statement = epService.getEPAdministrator().createEPL(sshBruteForceSubscriber.getStatement());
        sshBruteForceSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(sshBruteForceSubscriber);
    }

    public void DDoS(){
        LOG.debug("DDoS Attack .....");
        String EPLSChemaQueries = "create schema IncomingIPConnection(incomingip string); " +
                "create schema ConnectionCount(value int);" +
                "create schema IPConnectionCount(incomingip string, value int);" +
                "create schema SummedConnectionCount(value int);" +
                "create schema weigthedMean(value double);";

        epService.getEPAdministrator().createEPL("create schema IncomingIPConnection(incomingip string)");
        epService.getEPAdministrator().createEPL("create schema ConnectionCount(value long)");
        epService.getEPAdministrator().createEPL("create schema IPConnectionCount(incomingip string, value long)");
        epService.getEPAdministrator().createEPL("create schema SummedConnectionCount(value long)");
        epService.getEPAdministrator().createEPL("create schema weigthedMean(value double)");
        epService.getEPAdministrator().createEPL("create schema forecastedError(value double)");
        epService.getEPAdministrator().createEPL("create schema stddevError(value double)");
        epService.getEPAdministrator().createEPL("create schema upperTreshold(value double,std_dev double, mean double)");
        epService.getEPAdministrator().createEPL("create schema cusumSum(value double, currValue double, prevSum double, upTreshold double)");
        epService.getEPAdministrator().createEPL("create schema cusumTreshold(value double)");
        epService.getEPAdministrator().createEPL("create schema DDOSAlarm(value double)");
        epService.getEPAdministrator().createEPL("create schema SummedIPConnectionCount(incomingip string, value double)");
        epService.getEPAdministrator().createEPL("create schema BlackList(blacklistedip string)");
        EPStatement statement;

    }

    /**
     * Handle the incoming Event.
     */
    public void handle(ViruslogEvent event)
    {
        //  LOG.debug(log.toString());
        epService.getEPRuntime().sendEvent(event);
    }

    public void handle(SyslogEvent log)
    {
        //LOG.debug(log.toString());

        epService.getEPRuntime().sendEvent(log);
    }

    public void handle(IPlogEvent log)
    {
        //LOG.debug(log.toString());

        epService.getEPRuntime().sendEvent(log);
    }



    public void handleSyslog(List<SyslogEvent> log)
    {
        // LOG.debug(log.toString());

        // epService.getEPRuntime().sendEvent(log);
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
