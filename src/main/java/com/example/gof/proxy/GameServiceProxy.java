package com.example.gof.proxy;

import org.springframework.util.StopWatch;

public class GameServiceProxy implements GameServiceInterface{

    private GameServiceInterface gameService;

    public GameServiceProxy(GameServiceInterface gameServiceInterface) {
        this.gameService = gameServiceInterface;
    }

    @Override
    public void startGame() {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        gameService.startGame();
        stopWatch.stop();

        System.out.println(stopWatch.getTotalTimeNanos());
    }
}
