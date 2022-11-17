package com.example.gof.command;

public class GameCommand implements Command {

    private Game game;

    public GameCommand(Game game){
        this.game = game;
    }

    @Override
    public void execute(){
        if(this.game.state == 1){
            this.game.end();
        } else {
            this.game.start();
        }
    }

}
