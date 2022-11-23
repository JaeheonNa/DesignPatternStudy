package com.example.gof.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurante {
    private FrontDesk frontDesk = new FrontDesk();

    public void clean(Restaurante restaurante) {
        frontDesk.clean(this);
    }

    public void dinner(Guest guest, FrontDesk frontDesk){
        System.out.println(guest + " dinner");
    }
}
