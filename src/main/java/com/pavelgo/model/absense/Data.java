package com.pavelgo.model.absense;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by u7070 on 06.02.2020.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private Member member;

    private Reason reason;

    private Location location;

    private String description;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Data{" +
                "member=" + member +
                ", reason=" + reason +
                ", location=" + location +
                ", description='" + description + '\'' +
                '}';
    }
}
