package com.example.gof.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrontDesk {
    @Autowired
    private CleaningService cleaningService;
    @Autowired
    private Restaurante restaurante;


    public void getTowel(Guest guest, int numberOfTowel) {
        this.cleaningService.getTowel(guest.getId(), numberOfTowel);
    }

    public void clean(Restaurante restaurante) {
        this.cleaningService.clean(restaurante);
    }

    public void dinner(Guest guest) {
        this.restaurante.dinner(guest);
    }

    public String getRoomNumberFor(int guestId){
        return "Room No.guestId";
    }
}
