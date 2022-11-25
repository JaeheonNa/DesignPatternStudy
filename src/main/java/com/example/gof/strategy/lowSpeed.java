package com.example.gof.strategy;

public class lowSpeed implements Speed {
    @Override
    public void blueLight() {
        System.out.println("무우구우웅호오아 꼬오치이");
    }

    @Override
    public void redLight() {
        System.out.println("피어어쓰읍니이다아.");
    }
}
