package com.example.gof.abstractFactoryMethod.Parts;

import com.example.gof.factoryMethod.Ship;

public class WhiteShipPartsFactoryPro implements ShipPartsFactory {
    @Override
    public Anchor createAnchor() {
        Anchor whiteAnchorPro = new WhiteAnchorPro();
        return whiteAnchorPro;
    }

    @Override
    public Wheel createWheel() {
        Wheel WhiteWheelPro = new WhiteWheelPro();
        return WhiteWheelPro;
    }
}
