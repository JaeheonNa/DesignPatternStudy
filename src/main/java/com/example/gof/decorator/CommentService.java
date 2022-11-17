package com.example.gof.decorator;

import java.util.Objects;

public class CommentService implements CommentServiceInterface{
    @Override
    public void addComment(String comment){
        System.out.println(comment);
    }
}
