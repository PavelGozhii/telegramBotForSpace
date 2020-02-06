package com.pavelgo.services;

import com.pavelgo.model.absense.Absence;
import com.pavelgo.model.location.Location;
import com.pavelgo.model.profile.Profile;
import com.pavelgo.model.teams.Teams;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by u7070 on 05.02.2020.
 */
public class SpaceService {

    private Logger LOG = LoggerFactory.getLogger("SpaceService");

    private RestTemplate restTemplate;

    private String token;

    public SpaceService() {
//        HttpHost httpHost = new HttpHost("srv-gw-proxy02.BANK-BS.local", 3128);
//        CloseableHttpClient client = HttpClients.custom()
//                .setProxy(httpHost)
//                .build();
//        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpComponentsClientHttpRequestFactory.setHttpClient(client);
//        restTemplate = new RestTemplate(httpComponentsClientHttpRequestFactory);
        restTemplate = new RestTemplate();
        token = "Basic dGhyZWVzb21lc3BhY2Vib3Q6dnVoZXphMTIxMjEy";

    }

    public Teams getTeams() throws UnsupportedEncodingException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", token);
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<String> httpEntity = new HttpEntity<>(headers);
            String url = "https://threesome.jetbrains.space/api/http/team-directory/teams?query=&withArchived=false";
            ResponseEntity<Teams> teamsResponseEntity =
                    restTemplate.exchange(url, HttpMethod.GET, httpEntity, Teams.class);
            LOG.info("Response" + teamsResponseEntity.getBody());
            return teamsResponseEntity.getBody();
        } catch (HttpStatusCodeException ex) {
            ex.printStackTrace();
            if (ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                refreshToken();
                return getTeams();
            }
        }
        return null;
    }

    public Absence getAbsenses() throws UnsupportedEncodingException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", token);
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<String> httpEntity = new HttpEntity<>(headers);
            String url = "https://threesome.jetbrains.space/api/http/absences?viewMode=All";
            ResponseEntity<String> stringResponseEntity =
                    restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
            ResponseEntity<Absence> absenseResponseEntity =
                    restTemplate.exchange(url, HttpMethod.GET, httpEntity, Absence.class);
            LOG.info("Response" + absenseResponseEntity.getBody());
            return absenseResponseEntity.getBody();
        } catch (HttpStatusCodeException ex) {
            ex.printStackTrace();
            if (ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                refreshToken();
                return getAbsenses();
            }
        }
        return null;
    }

    public Profile getProfile(String id) throws UnsupportedEncodingException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", token);
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<String> httpEntity = new HttpEntity<>(headers);
            String url = "https://threesome.jetbrains.space/api/http/team-directory/profiles/" + id;
            ResponseEntity<Profile> profileResponseEntity =
                    restTemplate.exchange(url, HttpMethod.GET, httpEntity, Profile.class);
            LOG.info("Response" + profileResponseEntity.getBody());
            return profileResponseEntity.getBody();
        } catch (HttpStatusCodeException ex) {
            ex.printStackTrace();
            if (ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                refreshToken();
                return getProfile(id);
            }
        }
        return null;
    }

    public Location getLocation(String id) throws UnsupportedEncodingException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", token);
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<String> httpEntity = new HttpEntity<>(headers);
            String url = "https://threesome.jetbrains.space/api/http/team-directory/locations/" + id;
            ResponseEntity<Location> locationResponseEntity =
                    restTemplate.exchange(url, HttpMethod.GET, httpEntity, Location.class);
            LOG.info("Response" + locationResponseEntity.getBody());
            return locationResponseEntity.getBody();
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                refreshToken();
                return getLocation(id);
            }
        }
        return null;
    }

    public void refreshToken() throws UnsupportedEncodingException {
        String login = "threesomespacebot";
        String password = "vuheza121212";
        String auth = login + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")));
        token = "Basic " + new String(encodedAuth);
//        String client_id = "47784f4b-9b14-420d-96b7-39851561a93d";
//        String client_secret = "3626607495419eb0a9fb3f6cb3a077823c8e4fcac4adb8e766a89f60d8af2617";
//        String request = String.format("%s=%s",
//                URLEncoder.encode("grant_type", "utf-8"),
//                URLEncoder.encode("client_credentials", "utf-8"));
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        String auth = client_id + ":" + client_secret;
//        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
//        String authHeader = "Basic " + new String(encodedAuth);
//        httpHeaders.add("Authorization", authHeader);
//        HttpEntity<String> stringHttpEntity = new HttpEntity<>(request, httpHeaders);
//        OauthResponse response = restTemplate.postForObject("https://threesome.jetbrains.space/oauth/token", stringHttpEntity, OauthResponse.class);
//        token = response.getAccess_token();
    }


}
