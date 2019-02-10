package com.task.cep.event;
import com.task.cep.event.BaseLogEvent;
import java.util.Objects;

public class WeblogEvent extends BaseLogEvent {

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
                ", ipaddress='" + ipaddress + '\'' +
                '}';
    }
}
