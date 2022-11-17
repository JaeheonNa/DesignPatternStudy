package com.example.gof.decorator;

public class Decorator implements CommentServiceInterface {

    private CommentServiceInterface commentServiceInterface;
    public Decorator(CommentServiceInterface commentServiceInterface){
        this.commentServiceInterface = commentServiceInterface;
    }
    @Override
    public void addComment(String comment) {
        commentServiceInterface.addComment(comment);
    }
}
