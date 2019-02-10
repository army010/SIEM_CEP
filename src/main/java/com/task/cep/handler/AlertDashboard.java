package com.task.cep.handler;

import com.task.cep.event.AlertBucket;

import javax.swing.*;

public class AlertDashboard {
    private JPanel panel1;

    public void setData(AlertBucket data) {
    }

    public void getData(AlertBucket data) {
        data.getData();
    }

    public boolean isModified(AlertBucket data) {
        return false;
    }
}
