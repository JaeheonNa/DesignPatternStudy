package com.example.gof.strategy;

public class midSpeed implements Speed {
    @Override
    public void blueLight() {
        System.out.println("무궁화 꽃이");
    }

    @Override
    public void redLight() {
        System.out.println("피었습니다.");
    }
}
