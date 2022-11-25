package com.example.gof.visitor;

public class VisitorRunner {
    /*
    기존 코드를 변경하지 않고 기능을 추가하는 방법.
    더블 디스패치를 활용할 수 있다. (비동기 요청 위임.)
     */
    public static void run(){
        Shape rectangle = new Rectangle();
        Device phone = new Phone();
        rectangle.accept(phone);
        // 새로운 디바이스를 추가하고 싶으면,
        // 기존 코드의 변경 없이 Device를 구현한 클래스를 만들기만 하면 된다.
        // 단, 이 경우 shape이 사라지거나 변경이 필요할 경우에는 걷잡을 수 없이 수정할 게 많아진다.
    }
}
