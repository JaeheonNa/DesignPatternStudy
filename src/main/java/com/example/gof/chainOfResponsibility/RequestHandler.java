package com.example.gof.chainOfResponsibility;

public abstract class RequestHandler {
    private RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handle(Request request){
        if(this.nextHandler != null){
            nextHandler.handle(request);
        }
    }
}
