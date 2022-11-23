package com.example.gof.memento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private int redTeamScore;
    private int blueTeamScore;

    public GameSave save(){
        return new GameSave(blueTeamScore, redTeamScore);
    }

    public void restore(GameSave gameSave){
        this.blueTeamScore = gameSave.getBlueTeamScore();
        this.redTeamScore = gameSave.getRedTeamScore();
    }
}
