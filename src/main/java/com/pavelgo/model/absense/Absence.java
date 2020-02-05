package com.pavelgo.model.absense;

import java.util.Arrays;

/**
 * Created by u7070 on 05.02.2020.
 */
public class Absence {

    private String next;

    private Integer totalCount;

    private Data[] data;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
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
        return "Absence{" +
                "next='" + next + '\'' +
                ", totalCount=" + totalCount +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
