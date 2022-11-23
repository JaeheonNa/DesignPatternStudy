package com.example.gof.mediator;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Getter
@Component
public class Guest {


    private int id;
    private FrontDesk frontDesk = new FrontDesk();

    public void getTowel(int numberOfTowel){
        this.frontDesk.getTowel(this, numberOfTowel);
    }

    public void dinner() {
        this.frontDesk.dinner(this);
    }
}
