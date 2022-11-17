package com.example.gof.chainOfResponsibility;

public class ChainOfResponsibilityRunner {
    /*
    요청을 보내는 쪽과 요청을 처리하는 쪽을 분리하는 패
    핸들러 체인을 사용해서 요청을 처리한다.
    요청하는 쪽은 체인의 어떤 핸들러들이 어떻게 만들어졌는지 몰라도 됨.
    장점 : 클라이언트 코드를 변경하지 않고 얼마든지 새로운 핸들러를 체인에 추가할 수 있음.
     */
    private RequestHandler requestHandler;

    public ChainOfResponsibilityRunner(RequestHandler requestHandler){
        this.requestHandler = requestHandler;
    }

    public void doWork(){
        Request request = new Request("이번 놀이는 뽑기입니다.");
        requestHandler.handle(request);
    }

    public static void run(){
        RequestHandler chain = new AuthRequestHandler(new LoggingRequestHandler(new PrintRequestHandler(null)));
        ChainOfResponsibilityRunner client = new ChainOfResponsibilityRunner(chain);
        client.doWork();
    }

}
