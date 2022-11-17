package com.example.gof.bridge;

public class BridgeRunner {
    public static void run(){
        // Adaptor가 인터페이스를 연결하는 패턴이라고 할 때, Bridge는 구체적인 것과 추성적인 것을 나누어 연결하는 패턴.
        // 브릿지 적용 전
        Champion kda아리 = new KDA아리();
        kda아리.move();
        kda아리.skillQ();


        // 브릿지 적용 후
        // 여기서 구체적인 것은 아리, KDA. 추상적인 것은 Champion, Skin임.
        // 장점: 추상적인 코드를 구체적인 코드 변경 없이도 독립적으로 확장할 수 있다.
        //      추상적인 코드와 구체적인 코드를 분리할 수 있다.
        // 단점: 계층 구조가 늘어나 복잡도가 증가할 수 있다.
        Champion kda_아리 = new 아리(new KDA());
        kda_아리.move();
        kda_아리.skillQ();

        Champion poolparty_아리 = new 아리(new PoolParty());
        poolparty_아리.move();
        poolparty_아리.skillQ();

    }
}
