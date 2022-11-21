package com.example.gof.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CleaningService {
    @Autowired
    private FrontDesk frontDesk;

    public void getTowel(int guestId, int numberOfTowel){
        String room = this.frontDesk.getRoomNumberFor(guestId);
        System.out.println("provide " + numberOfTowel + " towel(s) to " + room);
    }

    public void clean(Restaurante restaurante){
        System.out.println("clean" + restaurante);
    }

    public void dinner(Guest guest) {

    }
}
