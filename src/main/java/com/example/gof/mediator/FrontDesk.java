package com.example.gof.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrontDesk {

    private CleaningService cleaningService = new CleaningService();
    private Restaurante restaurante;


    public void getTowel(Guest guest, int numberOfTowel) {
        this.cleaningService.getTowel(guest.getId(), numberOfTowel, this);
    }

    public void clean(Restaurante restaurante) {
        this.cleaningService.clean(restaurante, this);
    }

    public void dinner(Guest guest) {
        this.restaurante = new Restaurante();
        this.restaurante.dinner(guest, this);
    }

    public String getRoomNumberFor(int guestId){
        return "Room No.guestId";
    }
}
