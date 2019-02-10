package com.task.cep.event;

public class SymlogEvent extends BaseLogEvent {

    public String toString() {
        return "SymlogEvent{" +
                "time='" + time + '\'' +
                ", scanner='" + scanner + '\'' +
                ", type='" + type + '\'' +
                ", object='" + object + '\'' +
                ", threat='" + threat + '\'' +
                ", action='" + action + '\'' +
                ", user='" + user + '\'' +
                ", information='" + information + '\'' +
                ", hash='" + hash + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                '}';
    }
}
