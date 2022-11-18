package com.example.gof.iterator;

import java.util.Iterator;
import java.util.List;

public class IteratorRunner {
    /*
    List, Set, Map 등 집합 객체를 '순회'하는 패턴. 집합 객체의 내부 구조를 노출시키지 않음.
    장점 : 집합 객체의 구조를 몰라도 사용 가능. Iterator 인터페이스(hasNext(), next())만 알면 됨.
     */
    public static void run(){
        Board board = new Board();
        board.addPost("디자인 패턴 게임");
        board.addPost("선생님, 저랑 디자인 패턴 하나 학습하시겠습니까?");
        board.addPost("지금 이 자리에 계신 여러분들은 모두 디자인 패턴을 학습하고 계신 분들입니다.");

        // Iterator X
        List<Post> posts = board.getPosts();
        for(Post post: posts){
            System.out.println(post.getTitle());
        }

        // Iterator O 등록순으로 리턴
        Iterator<Post> iterator = board.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getTitle());
        }

        // Iterator O 최신순으로 리턴
        Iterator<Post> recentPostIterator = board.getRecentBoardIterator();
        while(recentPostIterator.hasNext()){
            System.out.println(recentPostIterator.next().getTitle());
        }
    }
}
