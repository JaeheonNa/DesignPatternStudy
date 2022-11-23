package com.example.gof.observer;

import lombok.Getter;

import javax.servlet.ServletOutputStream;
import java.util.List;

@Getter
public class User implements Subscriber{

    private String name;

    public User(String name){
        this.name = name;
    }

    @Override
    public void handleMessage(String message) {
        System.out.println(message);
    }
}
