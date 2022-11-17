package com.example.gof.abstractFactoryMethod;

import com.example.gof.abstractFactoryMethod.Parts.*;

public class BlackAshipFactory implements AshipFactory{

    private ShipPartsFactory shipPartsFactory;

    public BlackAshipFactory(ShipPartsFactory shipPartsFactory){
        this.shipPartsFactory = shipPartsFactory;
    }
    @Override
    public Aship createShip() {
        Aship whiteShip = new BlackAship();
        whiteShip.setName("BlackAship");
        whiteShip.setColor("black");
        whiteShip.setLogo("\uD83D\uDEE5");
        whiteShip.setAnchor(new BlackAnchor());
        whiteShip.setWheel(new BlackWheel());
        return whiteShip;
    }
}
