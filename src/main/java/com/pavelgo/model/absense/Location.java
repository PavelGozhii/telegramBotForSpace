package com.pavelgo.model.absense;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by u7070 on 05.02.2020.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                '}';
    }
}
