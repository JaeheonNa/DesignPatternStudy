package com.example.gof.command;

public class Light {

    int state;

    public Light(){
        this.state = 0;
    }

    void on(){
        System.out.println("불 켜짐");
        this.state = 1;
    }
    void off(){
        System.out.println("불 꺼짐");
        this.state = 0;
    }
}
