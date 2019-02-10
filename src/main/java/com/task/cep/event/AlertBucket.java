package com.task.cep.event;

public class AlertBucket {
    private String message;
    private String type;
    private String time;
    private String src;
    private String dst;
    private int src_port;
    private int dst_port;
    private int bytes;
    private int packets;
    private long date;
    private int eventID;
    private int eventID2;
    private int priority;
    private String origin;
    private String marker;
    private String user;

    public AlertBucket(int _eventID, int _eventID2, String _src, String _dst) {
        eventID = _eventID;
        eventID2 = _eventID2;
        src = _src;
        dst = _dst;
    }

    public AlertBucket(String _user, String _message, long _date, int _eventID, String _src, String _dst) {
        eventID = _eventID;
        date = _date;
        src = _src;
        dst = _dst;
        message = _message;
        user = _user;
    }

    public AlertBucket(String _user, String _message, long _date, String _src, String _dst, int _dst_port) {
        dst_port = _dst_port;
        date = _date;
        src = _src;
        dst = _dst;
        message = _message;
        user = _user;
    }

    public AlertBucket() {

    }

    public AlertBucket(String _src, String _dst, int _dst_port, String _message) {
        dst_port = _dst_port;
        src = _src;
        dst = _dst;
        message = _message;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getEventID2() {
        return eventID2;
    }

    public void setEventID2(int eventID2) {
        this.eventID2 = eventID2;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Alert Triggered: " + getSrc() + " " + getDst() + " " +
                getDst_port() + " " + getEventID() + " " + getEventID2()+ " " + getMessage() + " " + getUser();
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

    public AlertBucket getData() {
        return this;
    }


}
