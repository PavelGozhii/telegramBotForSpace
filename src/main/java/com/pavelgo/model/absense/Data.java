package com.pavelgo.model.absense;

/**
 * Created by u7070 on 05.02.2020.
 */
public class Data {

    private String id;

    private Approval approval;

    private boolean archived;

    private boolean available;

    private String description;

    private String icon;

    private Location location;

    private Member member;

    private Reason reason;

    private String since;

    private String till;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

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

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public String getTill() {
        return till;
    }

    public void setTill(String till) {
        this.till = till;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", approval=" + approval +
                ", archived=" + archived +
                ", available=" + available +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", location=" + location +
                ", member=" + member +
                ", reason=" + reason +
                ", since='" + since + '\'' +
                ", till='" + till + '\'' +
                '}';
    }
}

