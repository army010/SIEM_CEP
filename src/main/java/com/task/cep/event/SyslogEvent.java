package com.task.cep.event;

public class SyslogEvent {
    private String message;
    private String originalMessage;
    private int prival;
    private int facilityID;
    private int severityID;
    private String facility;
    private int severity;
    private String action;
    private String type;
    private String time;
    private String host;
    private String src;
    private String dst;
    private int src_port;
    private int dst_port;
    private String classification;
    private String sensor;
    private String proto;
    private int bytes;
    private int packets;
    private long date;
    private int priority;
    private String origin;
    private String user;
    private int eventID;

    public SyslogEvent() {

    }

    public SyslogEvent(String _user, int _priority, int _severity, String _message, long _date, String _src, String _dst, String _action, int _dst_port, int _src_port) {
        user = _user;
        message = _message;
        priority = _priority;
        severity = _severity;
        date = _date;
        action = _action;
        src_port = _src_port;
        dst_port = _dst_port;
        src = _src;
        dst = _dst;
    }

    public SyslogEvent(String _user, String _message, long _date, String _src, String _dst, String _action, int _dst_port, int _src_port) {
        user = _user;
        message = _message;
        date = _date;
        action = _action;
        src_port = _src_port;
        dst_port = _dst_port;
        src = _src;
        dst = _dst;
    }

    public SyslogEvent(String _user, String _message, long _date, String _src, String _dst, int _dst_port) {
        message = _message;
        user = _user;
        date = _date;
        dst_port = _dst_port;
        src = _src;
        dst = _dst;
    }

    public SyslogEvent(String _message, long _date, String _src, String _dst) {
        message = _message;
        date = _date;
        src = _src;
        dst = _dst;
    }


    public SyslogEvent(String _user, String _message, long _date, String _src, int _eventID) {
        user = _user;
        eventID = _eventID;
        date = _date;
        message = _message;
        src = _src;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long _date) {
        date = _date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String _message) {
        message = _message;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "SyslogEvent: " + getDate() + " " + getUser() + " " + getMessage() + " " +
                getSrc() + " " + getDst_port() + " " + getEventID();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getOriginalMessage() {
        return originalMessage;
    }

    public void setOriginalMessage(String originalMessage) {
        this.originalMessage = originalMessage;
    }

    public int getPrival() {
        return prival;
    }

    public void setPrival(int prival) {
        this.prival = prival;
    }

    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

    public int getSeverityID() {
        return severityID;
    }

    public void setSeverityID(int severityID) {
        this.severityID = severityID;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getSrc_port() {
        return src_port;
    }

    public void setSrc_port(int src_port) {
        this.src_port = src_port;
    }

    public int getDst_port() {
        return dst_port;
    }

    public void setDst_port(int dst_port) {
        this.dst_port = dst_port;
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public int getPackets() {
        return packets;
    }

    public void setPackets(int packets) {
        this.packets = packets;
    }


}
