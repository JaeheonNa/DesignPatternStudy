package com.example.gof.factoryMethod;

public class BlackShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        Ship blackShip = new BlackShip();
        return blackShip;
    }
}
