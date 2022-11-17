package com.example.gof.factoryMethod;

public class FactoryMethodRunner {
    public static void run(){

//        장점: 새로운 객체를 만들 때, 기존 코드 변경 없이 새 코드를 추가할 수 있게 함. open-closed principle.
//        단점: 클래스/인터페이스 수가 증가함.

        // <방법1>
        Ship whiteShip = new WhiteShipFactory().orderShip("WhiteShip", "njh@foodinko.com");
        System.out.println(whiteShip);
        Ship blackShip = new BlackShipFactory().orderShip("BlackShip", "njh@foodinko.com");
        System.out.println(blackShip);


        // <방법2>
        FactoryMethodRunner client = new FactoryMethodRunner();
        client.order(new WhiteShipFactory(), "WhiteShip", "njh@foodinko.com");
        client.order(new BlackShipFactory(), "BlackShip", "njh@foodinko.com");
    }

    private void order(ShipFactory shipFactory, String name, String email){
        Ship customedShip = shipFactory.orderShip(name, email);
        System.out.println(customedShip);
    }
}
