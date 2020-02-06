package com.pavelgo.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * Created by u7070 on 06.02.2020.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teams {

    private String next;

    private String totalCount;

    private Data[] data;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "next='" + next + '\'' +
                ", totalCount='" + totalCount + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
