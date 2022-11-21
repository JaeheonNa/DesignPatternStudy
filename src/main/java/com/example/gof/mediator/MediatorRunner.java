package com.example.gof.mediator;

public class MediatorRunner {

    private static final Guest guest = new Guest();
    /*
    여러 객체들이 소통하는 방법을 캡슐화하는 패턴.
    여러 컴포넌트간의 결합도를 중재자를 통해 낮출 수 있다.
     */
    public static void run(){

        guest.getTowel(1);
        guest.dinner();

        Restaurante restaurante = new Restaurante();
        restaurante.clean(restaurante);
    }
}
