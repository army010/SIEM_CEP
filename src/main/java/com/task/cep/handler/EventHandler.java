package com.task.cep.handler;

import com.espertech.esper.client.*;
import com.task.cep.event.*;
import com.task.cep.subscriber.*;
import com.task.cep.subscriber.dDosSubscribers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(value = "singleton")
public class EventHandler implements InitializingBean {


    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(EventHandler.class);

    /**
     * Esper service
     */
    private EPServiceProvider epService;

    /**
     * make your subscriber class as below
     */

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
    @Qualifier("incomingIPConnectionQuery")
    private IncomingIPConnectionQuery incomingIPConnectionQuery;

    @Autowired
    @Qualifier("connectionCountQuery")
    private ConnectionCountQuery connectionCountQuery;

    @Autowired
    @Qualifier("IPConnectionCountQuery")
    private IPConnectionCountQuery iPConnectionCountQuery;

    @Autowired
    @Qualifier("summedConnectionCountQuery")
    private SummedConnectionCountQuery summedConnectionCountQuery;

    @Autowired
    @Qualifier("firstWeigthedMeanQuery")
    private FirstWeigthedMeanQuery firstWeigthedMeanQuery;

    @Autowired
    @Qualifier("weigthedMeanQuery")
    private WeigthedMeanQuery weigthedMeanQuery;

    @Autowired
    @Qualifier("testSubscriber")
    private TestSubscriber testSubscriber;

    @Autowired
    @Qualifier("forecastedErrorQuery")
    private ForecastedErrorQuery forecastedErrorQuery;

    @Autowired
    @Qualifier("stddevErrorQuery")
    private StddevErrorQuery stddevErrorQuery;

    @Autowired
    @Qualifier("upperTresholdQuery")
    private UpperTresholdQuery upperTresholdQuery;

    @Autowired
    @Qualifier("firstCusumSumQuery")
    private FirstCusumSumQuery firstCusumSumQuery;

    @Autowired
    @Qualifier("cusumSumQuery")
    private CusumSumQuery cusumSumQuery;

    @Autowired
    @Qualifier("cusumTresholdQuery")
    private CusumTresholdQuery cusumTresholdQuery;

    @Autowired
    @Qualifier("DDOSAlarmQuery")
    private DDOSAlarmQuery ddosAlarmQuery;

    @Autowired
    @Qualifier("IPConnectionSumQuery")
    private IPConnectionSumQuery ipConnectionSumQuery;

    @Autowired
    @Qualifier("blackListQuery")
    private BlackListQuery blackListQuery;


    @Autowired
    @Qualifier("symVirusSubscriber")
    private StatementSubscriber symVirusSubscriber;

    @Autowired
    @Qualifier("multipleAntivirusSubscriber")
    private StatementSubscriber multipleAntivirusSubscriber;


    @Autowired
    @Qualifier("webVirusSubscriber")
    private StatementSubscriber webVirusSubscriber;


    /**
     * Configure Esper Statement(s).
     */
    private void initService() {

        LOG.debug("Initializing Service ..");
        Configuration config = new Configuration();

        config.addEventTypeAutoName("com.task.cep.event");
        epService = EPServiceProviderManager.getDefaultProvider(config);

        //Registering Events to Engine

        epService.getEPAdministrator().getConfiguration().addEventType(AuthenticationLogEvent.class);
        epService.getEPAdministrator().getConfiguration().addEventType(IPlogEvent.class);
        epService.getEPAdministrator().getConfiguration().addEventType(SyslogEvent.class);
        epService.getEPAdministrator().getConfiguration().addEventType(AlertBucket.class);
        epService.getEPAdministrator().getConfiguration().addEventType(ServerLogEvent.class);
        epService.getEPAdministrator().getConfiguration().addEventType(SymlogEvent.class);
        epService.getEPAdministrator().getConfiguration().addEventType(WeblogEvent.class);
        epService.getEPAdministrator().getConfiguration().addEventType(BaseLogEvent.class);
        epService.getEPAdministrator().getConfiguration().addEventType(AlertAntivirusBuckets.class);


        //simpleSelect();
        //bruteForce();
        //privilegeEsc();
        //sshBruteforce();
        //symVirus();
        //webVirus();
        //multipleAntivirus();
        //portScan();
        //DDoS();

    }

    /**
     * EPL to check for a critical condition across events,
     */


    public void simpleSelect() {
        //LOG.debug("Login Failed .....");
        EPStatement statement = epService.getEPAdministrator().createEPL(simpleSelectSubscriber.getStatement());
        //simpleSelectSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(simpleSelectSubscriber);
    }

    public void symVirus() {
        LOG.info("Detect Malware Virus from the syslog file .....");
        EPStatement statement = epService.getEPAdministrator().createEPL(symVirusSubscriber.getStatement());
        //symVirusSubscriber.addListener(new AntiVirusListener(), statement);
        statement.setSubscriber(symVirusSubscriber);

    }

    public void webVirus() {
        LOG.info("Detect Malware Virus from the weblog .....");
        EPStatement statement = epService.getEPAdministrator().createEPL(webVirusSubscriber.getStatement());
        //webVirusSubscriber.addListener(new AntiVirusListener(), statement);
        statement.setSubscriber(webVirusSubscriber);
    }

    public void multipleAntivirus() {
        LOG.info("Detect Malware Virus from the web and log file within 3 second .....");
        EPStatement statement = epService.getEPAdministrator().createEPL(multipleAntivirusSubscriber.getStatement());
        //multipleAntivirusSubscriber.addListener(new AntiVirusListener(), statement);
        statement.setSubscriber(multipleAntivirusSubscriber);
    }

    public void portScan() {
        LOG.debug("Detecting PortScan Attempt");
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


    public void bruteForce() {
        LOG.debug("Detecting Multiple Login Failed....");
        EPStatement statement = epService.getEPAdministrator().createEPL(bruteForceSubscriber.getStatement());
        bruteForceSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(bruteForceSubscriber);
    }

    public void privilegeEsc() {
        LOG.debug("Detecting Privileged Logon....");
        EPStatement statement = epService.getEPAdministrator().createEPL(privilegeEscSubscriber.getStatement());
        privilegeEscSubscriber.addListener(new EventListener2(), statement);
        statement.setSubscriber(privilegeEscSubscriber);
    }

    public void sshBruteforce() {
        LOG.debug("Detecting SSH Brute Force Attacks....");
        EPStatement statement = epService.getEPAdministrator().createEPL(sshBruteForceSubscriber.getStatement());
        sshBruteForceSubscriber.addListener(new EventListener(), statement);
        statement.setSubscriber(sshBruteForceSubscriber);
    }

    public void DDoS() {
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

        statement = epService.getEPAdministrator().createEPL(incomingIPConnectionQuery.getStatement());
        statement.setSubscriber(incomingIPConnectionQuery);

        statement = epService.getEPAdministrator().createEPL(connectionCountQuery.getStatement());
        statement.setSubscriber(connectionCountQuery);

        statement = epService.getEPAdministrator().createEPL(iPConnectionCountQuery.getStatement());
        statement.setSubscriber(iPConnectionCountQuery);

        statement = epService.getEPAdministrator().createEPL(summedConnectionCountQuery.getStatement());
        statement.setSubscriber(summedConnectionCountQuery);

        statement = epService.getEPAdministrator().createEPL(firstWeigthedMeanQuery.getStatement());
        statement.setSubscriber(iPConnectionCountQuery);

        statement = epService.getEPAdministrator().createEPL(weigthedMeanQuery.getStatement());
        statement.setSubscriber(weigthedMeanQuery);

        statement = epService.getEPAdministrator().createEPL(forecastedErrorQuery.getStatement());
        statement.setSubscriber(forecastedErrorQuery);

        statement = epService.getEPAdministrator().createEPL(stddevErrorQuery.getStatement());
        statement.setSubscriber(stddevErrorQuery);

        statement = epService.getEPAdministrator().createEPL(upperTresholdQuery.getStatement());
        statement.setSubscriber(upperTresholdQuery);

        statement = epService.getEPAdministrator().createEPL(firstCusumSumQuery.getStatement());
        statement.setSubscriber(firstCusumSumQuery);

        statement = epService.getEPAdministrator().createEPL(cusumSumQuery.getStatement());
        statement.setSubscriber(cusumSumQuery);

        statement = epService.getEPAdministrator().createEPL(cusumTresholdQuery.getStatement());
        statement.setSubscriber(cusumTresholdQuery);

        statement = epService.getEPAdministrator().createEPL(ddosAlarmQuery.getStatement());
        statement.setSubscriber(ddosAlarmQuery);

        statement = epService.getEPAdministrator().createEPL(ipConnectionSumQuery.getStatement());
        statement.setSubscriber(ipConnectionSumQuery);

        statement = epService.getEPAdministrator().createEPL(blackListQuery.getStatement());
        statement.setSubscriber(blackListQuery);


        statement = epService.getEPAdministrator().createEPL(testSubscriber.getStatement());
        testSubscriber.addListener(new DDOSListener(), statement);
        statement.setSubscriber(testSubscriber);

    }


    /**
     * Handle the incoming Event.
     */

    public void handle(SymlogEvent event) {
        //  LOG.debug(log.toString());
        epService.getEPRuntime().sendEvent(event);
    }

    public void handle(SyslogEvent log) {
        //LOG.debug(log.toString());

        epService.getEPRuntime().sendEvent(log);
    }

    public void handle(IPlogEvent log) {
        //LOG.debug(log.toString());

        epService.getEPRuntime().sendEvent(log);
    }

    public void handleAuthlog(List<AuthenticationLogEvent> log) {
        //LOG.debug(log.toString());

        epService.getEPRuntime().sendEvent(log);
    }

    public void handleServerlog(ServerLogEvent log) {
        // LOG.debug(log.toString());

        epService.getEPRuntime().sendEvent(log);
    }

    public void handleSyslog(List<SyslogEvent> log) {
        // LOG.debug(log.toString());

        // epService.getEPRuntime().sendEvent(log);
    }

    @Override
    public void afterPropertiesSet() {

        LOG.debug("Configuring..");
        initService();
    }

    public void handle(WeblogEvent event) {
        //  LOG.debug(log.toString());
        epService.getEPRuntime().sendEvent(event);
    }

    public void addListener(UpdateListener listener, EPStatement statement) {
        statement.addListener(listener);
    }
}
