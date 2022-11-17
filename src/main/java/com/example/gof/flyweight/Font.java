package com.example.gof.flyweight;

import lombok.Getter;

@Getter
public final class Font {
    String family;
    int size;

    public Font(String family, int size){
        this.family = family;
        this.size = size;
    }
}
