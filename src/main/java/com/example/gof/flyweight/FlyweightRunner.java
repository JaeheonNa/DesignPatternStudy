package com.example.gof.flyweight;

public class FlyweightRunner {
    /*
    객체를 가볍게 만들어 메모리 사용을 줄이는 패턴
    자주 변하는 속성(또는 외적인 속성)과 변하지 않는 속성(또는 내적인 속성)을 분리하고 재사용하여 메모리 사용을 줄일 수 있음.
    장점 : 애플리케이션에서 사용하는 메모리를 줄일 수 있음.
    단점 : 코드 복잡도가 증가한다.
     */
    public static void run(){
        /* 플라이웨이트 적용 전
        Character c1 = new Character('h', "white", "Nanum", 12);
        Character c2 = new Character('e', "white", "Nanum", 12);
        Character c3 = new Character('l', "white", "Nanum", 12);
        Character c4 = new Character('l', "white", "Nanum", 12);
        Character c5 = new Character('o', "white", "Nanum", 12);
         */

        /* 플라이웨이트 적용 */
        FontFactory fontFactory = new FontFactory();
        FlyCharacter c1 = new FlyCharacter('h', "white", fontFactory.getFont("nanum:12"));
        FlyCharacter c2 = new FlyCharacter('e', "white", fontFactory.getFont("nanum:12"));
        FlyCharacter c3 = new FlyCharacter('l', "white", fontFactory.getFont("nanum:12"));
        FlyCharacter c4 = new FlyCharacter('l', "white", fontFactory.getFont("nanum:12"));
        FlyCharacter c5 = new FlyCharacter('o', "white", fontFactory.getFont("nanum:12"));
        //--> fontFactory.getFont("nanum:12") 만큼의 메모리를 절약함.

    }
}
