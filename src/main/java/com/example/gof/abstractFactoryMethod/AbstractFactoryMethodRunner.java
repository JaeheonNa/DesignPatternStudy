package com.example.gof.abstractFactoryMethod;

import com.example.gof.abstractFactoryMethod.Parts.BlackShipPartsFactory;
import com.example.gof.abstractFactoryMethod.Parts.WhiteShipPartsFactory;
import com.example.gof.abstractFactoryMethod.Parts.WhiteShipPartsFactoryPro;

public class AbstractFactoryMethodRunner {

    public static void run(){
        AbstractFactoryMethodRunner client = new AbstractFactoryMethodRunner();
        client.order(new WhiteAshipFactory(new WhiteShipPartsFactory()), "whiteShip", "njh@foodinko.com");
        client.order(new BlackAshipFactory(new BlackShipPartsFactory()), "blackShip", "njh@foodinko.com");
        client.order(new WhiteAshipFactory(new WhiteShipPartsFactoryPro()), "whiteShipPro", "njh@foodinko.com");
    }

    private void order(AshipFactory shipFactory, String name, String email){
        Aship newShip = shipFactory.orderShip(name, email);
        System.out.println("주문하신 상품작 제작이 완료되었습니다.");
        System.out.println("제품명: " + newShip.getName());
        System.out.println("색상: " + newShip.getColor());
        System.out.println("로고: " + newShip.getLogo());
        System.out.println(newShip.getWheel().getClass());
        System.out.println(newShip.getAnchor().getClass());
        System.out.println("=====================================");
    }
}
