package com.task.cep.event;

import java.util.Objects;

public class BaseLogEvent {

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


    @Override
    public String toString() {
        return "Antivirus  Alert Triggered ::" +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseLogEvent)) return false;
        BaseLogEvent that = (BaseLogEvent) o;
        return Objects.equals(getTime(), that.getTime()) &&
                Objects.equals(getScanner(), that.getScanner()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getObject(), that.getObject()) &&
                Objects.equals(getThreat(), that.getThreat()) &&
                Objects.equals(getAction(), that.getAction()) &&
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getInformation(), that.getInformation()) &&
                Objects.equals(getHash(), that.getHash()) &&
                Objects.equals(getIpaddress(), that.getIpaddress());
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getScanner(), getType(), getObject(), getThreat(), getAction(), getUser(), getInformation(), getHash(), getIpaddress());
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
}
