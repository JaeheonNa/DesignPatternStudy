package com.example.gof.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurante {
    @Autowired
    private FrontDesk frontDesk;

    public void getTowel(int guestId, int numberOfTowel) {

    }

    public void clean(Restaurante restaurante) {
        this.frontDesk.clean(this);
    }

    public void dinner(Guest guest){
        System.out.println(guest + "dinner");
    }
}
