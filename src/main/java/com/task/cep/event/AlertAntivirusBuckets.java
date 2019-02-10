package com.task.cep.event;

public class AlertAntivirusBuckets {
    protected String time;
    protected String scanner;
    protected String type;
    protected String object;
    protected String threat;
    protected String action;
    protected String user;
    protected String information;
    protected String hash;
    protected String ipaddress;

    public AlertAntivirusBuckets() {
    }

    public AlertAntivirusBuckets(String time, String scanner, String type, String object, String threat, String action, String user, String information, String hash, String ipaddress) {
        this.time = time;
        this.scanner = scanner;
        this.type = type;
        this.object = object;
        this.threat = threat;
        this.action = action;
        this.user = user;
        this.information = information;
        this.hash = hash;
        this.ipaddress = ipaddress;
    }

    @Override
    public String toString() {
        return "AlertAntivirusBuckets :" +
                "time='" + time + '\'' +
                ", scanner='" + scanner + '\'' +
                ", type='" + type + '\'' +
                ", object='" + object + '\'' +
                ", threat='" + threat + '\'' +
                ", action='" + action + '\'' +
                ", user='" + user + '\'' +
                ", information='" + information + '\'' +
                ", hash='" + hash + '\'' +
                ", ipaddress='" + ipaddress + '\'';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getScanner() {
        return scanner;
    }

    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getThreat() {
        return threat;
    }

    public void setThreat(String threat) {
        this.threat = threat;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }
}
