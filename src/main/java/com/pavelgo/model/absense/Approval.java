package com.pavelgo.model.absense;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by u7070 on 05.02.2020.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Approval {

    private boolean approved;

    private String datatime;

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    @Override
    public String toString() {
        return "Approval{" +
                "approved=" + approved +
                ", datatime='" + datatime + '\'' +
                '}';
    }
}
