package com.task.cep.event;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Arrays;

public class AuthenticationLogEvent {
    String message;
    @JsonAlias({"version", "@version"})
    String version;
    String host;
    String tags[];
    String path;
    @JsonAlias({"timestamp", "@timestamp"})
    String timestamp;

    public AuthenticationLogEvent() {
    }

    public AuthenticationLogEvent(String message, String version, String host, String[] tags, String path, String timestamp) {
        this.message = message;
        this.version = version;
        this.host = host;
        this.tags = tags;
        this.path = path;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AuthenticationLogEvent{" +
                "message='" + message + '\'' +
                ", version='" + version + '\'' +
                ", host='" + host + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", path='" + path + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
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
}
