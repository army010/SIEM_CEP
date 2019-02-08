package com.task.cep.event;

import java.util.Objects;

public class ViruslogEvent {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViruslogEvent logEvent = (ViruslogEvent) o;
        return Objects.equals(time, logEvent.time) &&
                Objects.equals(scanner, logEvent.scanner) &&
                Objects.equals(type, logEvent.type) &&
                Objects.equals(object, logEvent.object) &&
                Objects.equals(threat, logEvent.threat) &&
                Objects.equals(action, logEvent.action) &&
                Objects.equals(user, logEvent.user) &&
                Objects.equals(information, logEvent.information) &&
                Objects.equals(hash, logEvent.hash);
    }

    @Override
    public String toString() {
        return "LogEvent{" +
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
    public int hashCode() {
        return Objects.hash(time, scanner, type, object, threat, action, user, information, hash);
    }




    public ViruslogEvent(String _time, String _scanner, String _type, String _object ,
                         String _threat, String _action, String _user, String _information ,
                         String _hash){
     time = _time;
     scanner = _scanner;
     type = _type;
     object = _object;
     threat = _threat;
     action = _action;
     user = _user;
     information = _information;
     hash = _hash;
    }

    public ViruslogEvent()
    {}


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
