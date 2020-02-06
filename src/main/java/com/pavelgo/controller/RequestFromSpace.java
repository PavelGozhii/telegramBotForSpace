package com.pavelgo.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class RequestFromSpace {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test")
    private String test(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        return "Работає";
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/space")
    public void getResponseFromSpace() {
        System.out.println("notify");
    }

}
