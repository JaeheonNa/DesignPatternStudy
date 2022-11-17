package com.example.gof.abstractFactoryMethod.Parts;

public class BlackShipPartsFactory implements ShipPartsFactory{
    @Override
    public Anchor createAnchor() {
        Anchor blackAnchor = new BlackAnchor();
        return blackAnchor;
    }

    @Override
    public Wheel createWheel() {
        Wheel blackWheel = new BlackWheel();
        return blackWheel;
    }
}
