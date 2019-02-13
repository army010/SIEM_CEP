package com.task.cep.event;

public class IPlogEvent {
    private String message;
    private String type;
    private String time;
    private String src;
    private String dst;
    private int src_port;
    private int port;
    private int bytes;
    private int packets;
    private long date;
    private int priority;
    private String origin;
    private String marker;
    private IPlogEvent event;

    public IPlogEvent() {

    }

    public IPlogEvent(String _src, String _dst, int _port, String _marker) {
        port = _port;
        src = _src;
        dst = _dst;
        marker = _marker;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
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

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "IPLog Event: " + getSrc() + " " + getDst() + " " + getDst_port() + " " + getMarker();
    }


    public IPlogEvent getEvent() { return  this.event; }

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
        return port;
    }

    public void setDst_port(int dst_port) {
        this.port = dst_port;
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
