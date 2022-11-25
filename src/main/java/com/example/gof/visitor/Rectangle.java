package com.example.gof.visitor;

public class Rectangle implements Shape{

    @Override
    public void accept(Device device) {
        device.print(this);
    }
}
