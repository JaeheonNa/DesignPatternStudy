package com.example.gof.abstractFactoryMethod;

import com.example.gof.abstractFactoryMethod.Parts.Anchor;
import com.example.gof.abstractFactoryMethod.Parts.Wheel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Aship {
    private String name;
    private String color;
    private String logo;
    private Wheel wheel;
    private Anchor anchor;
}
