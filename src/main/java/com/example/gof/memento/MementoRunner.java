package com.example.gof.memento;

import javax.servlet.ServletOutputStream;

public class MementoRunner {
    /*
    객체의 내부 정보를 알지 않고도 객체의 내부 정보를 저장했다 불러올 수 있는 패턴.
    장점 : 객체 내부의 상태를 노출시키지 않고도 객체 상태의 스냅샷을 만들 수 있다.
          객체 내부의 상태가 변경되더라도(속성이 추가/삭제 되더라도) 외부 코드는 바뀌지 않는다.
    단점 : 메멘토 객체를 많이 사용할수록 메모리 사용률이 올라간다. (주기적 정리 필요)

     */
    public static void run(){

        /*
        메멘코 패턴 적용 전
        */
        Game game = new Game();
        game.setRedTeamScore(10);
        game.setBlueTeamScore(20);

        int redTeamScore = game.getRedTeamScore();
        int blueTeamScore = game.getBlueTeamScore();

        Game newGame = new Game();
        game.setBlueTeamScore(blueTeamScore);
        game.setRedTeamScore(redTeamScore);

        /*
        메멘토 패턴 적용
         */
        Game mementoGame = new Game();
        mementoGame.setRedTeamScore(10);
        mementoGame.setBlueTeamScore(20);

        GameSave save = mementoGame.save();

        mementoGame.setRedTeamScore(1);
        mementoGame.setBlueTeamScore(2);

        mementoGame.restore(save);


    }
}
