package com.example.gof.abstractFactoryMethod.Parts;

public class WhiteShipPartsFactory implements ShipPartsFactory{
    @Override
    public Anchor createAnchor() {
        Anchor whiteAnchor = new WhiteAnchor();
        return whiteAnchor;
    }

    @Override
    public Wheel createWheel() {
        Wheel whiteWheel = new WhiteWheel();
        return whiteWheel;
    }
}
