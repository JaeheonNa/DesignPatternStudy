package com.example.gof.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CleaningService {

    public void getTowel(int guestId, int numberOfTowel, FrontDesk frontDesk){
        String room = frontDesk.getRoomNumberFor(guestId);
        System.out.println("provide " + numberOfTowel + " towel(s) to " + room);
    }

    public void clean(Restaurante restaurante, FrontDesk frontDesk){
        System.out.println("clean" + restaurante);
    }

    public void dinner(Guest guest) {

    }
}
