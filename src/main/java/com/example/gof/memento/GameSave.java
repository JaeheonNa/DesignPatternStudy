package com.example.gof.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameSave {
    private final int blueTeamScore;
    private final int redTeamScore;

}
