package com.example.gof.factoryMethod;

public class WhiteShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        Ship whiteShip = new WhiteShip();
        return whiteShip;
    }

}
