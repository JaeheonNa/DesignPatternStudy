package com.example.gof.command;

public class Game {

    int state;

    public Game(){
        this.state = 0;
    }

    void start(){
        System.out.println("게임 시작");
        this.state = 1;
    }
    void end(){
        System.out.println("게임 종료");
        this.state = 0;
    }
}
