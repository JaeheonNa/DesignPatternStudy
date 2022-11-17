package com.example.gof.flyweight;

public class FlyCharacter {
    private char value;
    private String color;
    private Font font;

    public FlyCharacter(char value, String color, Font font){
        this.value = value;
        this.color = color;
        this.font = font;
    }
}
