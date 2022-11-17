package com.example.gof.decorator;

public class Client {
    private CommentServiceInterface commentServiceInterface;
    public Client(CommentServiceInterface commentServiceInterface){
        this.commentServiceInterface = commentServiceInterface;
    }
    public void writeComment(String comment){
        commentServiceInterface.addComment(comment);
    }
}
