package com.task.cep.event;


import com.fasterxml.jackson.annotation.JsonAlias;

public class ServerLogEvent {
    @JsonAlias({"version", "@version"})
    String version;
    String client_ip;
    String http_version;
    String type;
    String method;
    String ident;
    String auth;
    String host;
    String request_page;
    String message;
    String path;
    @JsonAlias({"timestamp", "@timestamp"})
    String timestamp;
    String apache_timestamp;
    String server_response;

    public ServerLogEvent(String version, String client_ip, String http_version, String type, String method, String ident, String auth, String host, String request_page, String message, String path, String timestamp, String apache_timestamp, String server_response) {
        this.version = version;
        this.client_ip = client_ip;
        this.http_version = http_version;
        this.type = type;
        this.method = method;
        this.ident = ident;
        this.auth = auth;
        this.host = host;
        this.request_page = request_page;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
        this.apache_timestamp = apache_timestamp;
        this.server_response = server_response;
    }

    @Override
    public String toString() {
        return "ServerLogEvent{" +
                "version='" + version + '\'' +
                ", client_ip='" + client_ip + '\'' +
                ", http_version='" + http_version + '\'' +
                ", type='" + type + '\'' +
                ", method='" + method + '\'' +
                ", ident='" + ident + '\'' +
                ", auth='" + auth + '\'' +
                ", host='" + host + '\'' +
                ", request_page='" + request_page + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", apache_timestamp='" + apache_timestamp + '\'' +
                ", server_response='" + server_response + '\'' +
                '}';
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getHttp_version() {
        return http_version;
    }

    public void setHttp_version(String http_version) {
        this.http_version = http_version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getRequest_page() {
        return request_page;
    }

    public void setRequest_page(String request_page) {
        this.request_page = request_page;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getApache_timestamp() {
        return apache_timestamp;
    }

    public void setApache_timestamp(String apache_timestamp) {
        this.apache_timestamp = apache_timestamp;
    }

    public String getServer_response() {
        return server_response;
    }

    public void setServer_response(String server_response) {
        this.server_response = server_response;
    }
}
