package com.example.gof.abstractFactoryMethod;

import com.example.gof.abstractFactoryMethod.Parts.ShipPartsFactory;


public class WhiteAshipFactory implements AshipFactory{

    private ShipPartsFactory shipPartsFactory;

    public WhiteAshipFactory(ShipPartsFactory shipPartsFactory){
        this.shipPartsFactory = shipPartsFactory;
    }
    @Override
    public Aship createShip() {
        Aship whiteShip = new WhiteAship();
        whiteShip.setName("WhiteAship");
        whiteShip.setColor("white");
        whiteShip.setLogo("\uD83D\uDEE5");
        whiteShip.setAnchor(shipPartsFactory.createAnchor());
        whiteShip.setWheel(shipPartsFactory.createWheel());
        return whiteShip;
    }
}
