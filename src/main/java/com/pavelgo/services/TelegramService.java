package com.pavelgo.services;

import com.pavelgo.model.absense.Absence;
import com.pavelgo.model.absense.Location;
import com.pavelgo.model.profile.Profile;
import com.pavelgo.model.teams.Data;
import com.pavelgo.model.teams.Teams;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

/**
 * Created by u7070 on 05.02.2020.
 */
public class TelegramService {

    private SpaceService spaceService;

    public TelegramService() {
        spaceService = new SpaceService();
    }

    public String generateReportForTeams(Teams teams) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Our teams:\n");
        Data[] data = teams.getData();
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(i + 1).append(". ");
            stringBuilder.append(data[i].getName()).append("\n");
            stringBuilder.append(data[i].getDescription()).append("\n");
            stringBuilder.append("Email: \n");
            for (int e = 0; e < data[i].getEmails().length; e++)
                stringBuilder.append("Email: ").append(data[i].getEmails()[e]);
        }
        return stringBuilder.toString();
    }

    public String getAbsenceInfo(Absence absence) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Absences: \n");
        com.pavelgo.model.absense.Data[] data = absence.getData();
        for (int i = 0; i < data.length; i++) {
            Profile profile = spaceService.getProfile(data[i].getMember().getId());
            String memberName = profile.getName().getFirstName() + " " + profile.getName().getLastName();
            String description = data[i].getDescription();
            stringBuilder.append(i + 1).append(". ").append(memberName).append("\n");
            stringBuilder.append("Reason: ").append(description).append("\n");
            Location location = data[i].getLocation();
            String locationName;
            if (location != null) {
                locationName = Optional.of("Location: " + spaceService.getLocation(location.getId()).getName() + "\n").orElseGet(null);
            } else {
                locationName = "";
            }
            stringBuilder.append(locationName);
        }
        return stringBuilder.toString();
    }
}
