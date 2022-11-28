package com.example.gof.strategy;

public class StrategyRunner {
    /*
    여러 알로기듬을 캡슐화하고 상호 교환 가능하게 만드는 패턴.
    장점 : 새로운 전략을 추가하더라도 기존 코드를 변경하지 않는다.
          상속 대신 위임을 사용할 수 있다.
          런타임에 전략을 변경할 수 있다.
    단점 : 복잡도가 증가한다.
          클라이언트 코드가 구체적인 전략을 알아야한다.
     */
    public static void run(){
        BlueLightAndRedLight blueLightAndRedLight = new BlueLightAndRedLight(new midSpeed());
        blueLightAndRedLight.blueLight(new lowSpeed());
        blueLightAndRedLight.redLight(new highSpeed());
    }
}
