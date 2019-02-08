package com.task.cep.event;

import java.util.Objects;

public class WeblogEvent {
    private String time;
    private String scanner;
    private String type;
    private String object;
    private String threat;
    private String action;
    private String user;
    private String information;
    private String hash;

    @Override
    public String toString() {
        return "WeblogEvent{" +
                "time='" + time + '\'' +
                ", scanner='" + scanner + '\'' +
                ", type='" + type + '\'' +
                ", object='" + object + '\'' +
                ", threat='" + threat + '\'' +
                ", action='" + action + '\'' +
                ", user='" + user + '\'' +
                ", information='" + information + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeblogEvent)) return false;
        WeblogEvent that = (WeblogEvent) o;
        return Objects.equals(getTime(), that.getTime()) &&
                Objects.equals(getScanner(), that.getScanner()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getObject(), that.getObject()) &&
                Objects.equals(getThreat(), that.getThreat()) &&
                Objects.equals(getAction(), that.getAction()) &&
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getInformation(), that.getInformation()) &&
                Objects.equals(getHash(), that.getHash());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getScanner(), getType(), getObject(), getThreat(), getAction(), getUser(), getInformation(), getHash());
    }

    public WeblogEvent(String time, String scanner, String type, String object, String threat, String action, String user, String information, String hash) {
        this.time = time;
        this.scanner = scanner;
        this.type = type;
        this.object = object;
        this.threat = threat;
        this.action = action;
        this.user = user;
        this.information = information;
        this.hash = hash;
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

    public WeblogEvent() {
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
