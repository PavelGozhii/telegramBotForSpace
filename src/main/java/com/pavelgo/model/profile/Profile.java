package com.pavelgo.model.profile;

import java.util.Arrays;

/**
 * Created by u7070 on 05.02.2020.
 */
public class Profile {

    private String id;

    private String username;

    private Name name;

    private boolean speaksEnglish;

    private String smallAvatar;

    private String avatar;

    private String profilePicture;

    private Language[] languages;

    private boolean archived;

    private boolean notAMember;

    private Joined joined;

    private String left;

    private String leftAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public boolean isSpeaksEnglish() {
        return speaksEnglish;
    }

    public void setSpeaksEnglish(boolean speaksEnglish) {
        this.speaksEnglish = speaksEnglish;
    }

    public String getSmallAvatar() {
        return smallAvatar;
    }

    public void setSmallAvatar(String smallAvatar) {
        this.smallAvatar = smallAvatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Language[] getLanguages() {
        return languages;
    }

    public void setLanguages(Language[] languages) {
        this.languages = languages;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isNotAMember() {
        return notAMember;
    }

    public void setNotAMember(boolean notAMember) {
        this.notAMember = notAMember;
    }

    public Joined getJoined() {
        return joined;
    }

    public void setJoined(Joined joined) {
        this.joined = joined;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getLeftAt() {
        return leftAt;
    }

    public void setLeftAt(String leftAt) {
        this.leftAt = leftAt;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", name=" + name +
                ", speaksEnglish=" + speaksEnglish +
                ", smallAvatar='" + smallAvatar + '\'' +
                ", avatar='" + avatar + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", languages=" + Arrays.toString(languages) +
                ", archived=" + archived +
                ", notAMember=" + notAMember +
                ", joined=" + joined +
                ", left='" + left + '\'' +
                ", leftAt='" + leftAt + '\'' +
                '}';
    }
}
