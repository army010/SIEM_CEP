package com.task.cep.event;
import com.task.cep.event.BaseLogEvent;
import java.util.Objects;

public class WeblogEvent extends BaseLogEvent {
    public WeblogEvent(String time, String scanner, String type, String object, String threat, String action, String user, String information, String hash, String ipaddress) {
        super(time, scanner, type, object, threat, action, user, information, hash, ipaddress);
    }

    public WeblogEvent() {
    }

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
