package com.example.gof.chainOfResponsibility;

import lombok.Getter;

@Getter
public class Request {
    private String body;

    public Request(String body){
        this.body = body;
    }
}
