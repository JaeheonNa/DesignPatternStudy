package com.example.gof.strategy;

public class BlueLightAndRedLight {

    private Speed speed;

    public BlueLightAndRedLight(Speed speed){
        this.speed = speed;
    }

    public void blueLight(Speed speed) {
        this.speed = speed;
        speed.blueLight();
    }

    public void redLight(Speed speed) {
        this.speed = speed;
        speed.redLight();
    }
}
