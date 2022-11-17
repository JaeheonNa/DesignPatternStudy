package com.example.gof.command;

public class LightCommand implements Command {

    private Light light;

    public LightCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute(){
        if(light.state == 1){
            this.light.off();
        } else {
            this.light.on();
        }

    }
}
