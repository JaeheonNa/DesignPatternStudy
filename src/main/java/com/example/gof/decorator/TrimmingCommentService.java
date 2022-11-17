package com.example.gof.decorator;

public class TrimmingCommentService extends Decorator {

    public TrimmingCommentService(CommentServiceInterface commentServiceInterface){
        super(commentServiceInterface);
    }
    @Override
    public void addComment(String comment){
        super.addComment(trim(comment));
    }

    public String trim(String comment){
        return comment.replace("...", "");
    }
}
