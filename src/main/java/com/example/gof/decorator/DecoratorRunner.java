package com.example.gof.decorator;

public class DecoratorRunner {
    /*
    기존 코드를 수정하지 않고, 부가기능을 추가하되(OCP), 컴파일 타임이 아니라 런타임에 추가하는 방법.
    장점 : 새로운 클래스를 만들지 않고 기존 기능을 조합할 수 있다.
          컴파일 타임이 아닌 런타임에 동적으로 기능을 변경할 수 있다.
    단점 : 데코레이터를 조합하는 코드가 복잡할 수 있다.
     */

    /*
    컴포짓 패턴 적용 전
    private CommentService commentService;

    public DecoratorRunner(CommentService commentService){
        this.commentService = commentService;
    }

    public static void run(){
        DecoratorRunner client = new DecoratorRunner(new SpamFilteringCommentService());
        client.writeComment("댓글");
        client.writeComment("추가 댓글...");
        client.writeComment("http://foodinko.com");
    }

    public void writeComment(String comment){
        commentService.addComment(comment);
    }
     */

    private static boolean spamFiltering = true;
    private static boolean trimming = true;

    public static void run(){

        CommentServiceInterface commentServiceInterface = new CommentService();
        if(spamFiltering)
            commentServiceInterface = new SpamFilteringCommentService(commentServiceInterface);
        if(trimming)
            commentServiceInterface = new TrimmingCommentService(commentServiceInterface);

        Client client = new Client(commentServiceInterface);
        client.writeComment("comment");
        client.writeComment("comment...");
        client.writeComment("http://foodinko.com");
        client.writeComment("http://foodinko.com...");
    }


}
