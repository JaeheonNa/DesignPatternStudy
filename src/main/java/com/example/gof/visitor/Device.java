package com.example.gof.visitor;

public interface Device {
    void print(Rectangle rectangle);

    void print(Circle circle);

    void print(Triangle triangle);
}
