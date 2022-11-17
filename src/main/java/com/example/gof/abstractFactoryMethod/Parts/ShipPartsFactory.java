package com.example.gof.abstractFactoryMethod.Parts;

public interface ShipPartsFactory {

    Anchor createAnchor();
    Wheel createWheel();

}
