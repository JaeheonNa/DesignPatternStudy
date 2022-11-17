package com.example.gof.decorator;

public class SpamFilteringCommentService extends Decorator {

    public SpamFilteringCommentService(CommentServiceInterface commentServiceInterface){
        super(commentServiceInterface);
    }
    @Override
    public void addComment(String comment){
        if(!filter(comment)) super.addComment(comment);
    }

    public boolean filter(String comment){
        return comment.contains("http");
    }
}
