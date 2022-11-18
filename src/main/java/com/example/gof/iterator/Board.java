package com.example.gof.iterator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class Board {
    private List<Post> posts = new ArrayList<>();

    public void addPost(String content){
        posts.add(new Post(content));
    }

    public Iterator<Post> getIterator(){
        return posts.iterator();
    }

    public Iterator<Post> getRecentBoardIterator(){
        return new RecentPostIterator(this);
    }
}
