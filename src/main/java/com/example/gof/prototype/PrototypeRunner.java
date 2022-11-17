package com.example.gof.prototype;

public class PrototypeRunner {

    public static void run() throws CloneNotSupportedException {
        //프로토타입 적용 전
        GithubRepository repository = new GithubRepository();
        repository.setUser("whiteship");
        repository.setName("live-study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제 : JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가");

        String url = githubIssue.getUrl();
        System.out.println(url);

        GithubIssue githubIssue2 = new GithubIssue(repository);
        githubIssue2.setId(2);
        githubIssue2.setTitle("2주차 과제 : ...");

        String url2 = githubIssue2.getUrl();
        System.out.println(url2);



        /*
        프로토타입 적용.
        해당 클래스에서 Clonable 상속 후 Object의 clone() 메소드 Overide.
        장점: 복사해놓으면, DB조회나 네트워크 통신을 줄일 수 있음.
             복잡한 객체를 만드는 과정을 clone이라는 메소드 안에 숨길 수 있음.
             기존 객체를 복제하는 과정이 새 인스턴스를 만드는 비용적인 면에서 효율적일 수도 있음.
             추상적인 타입을 리턴할 수 있음.
        단점: 복제한 객체를 만드는 과정 자체가 복잡할 수 있음.
        clone은 얕은 복사임. so, 원본의 내용이 바뀌면 clone도 바뀜.
        깊은 복사를 하려면 clone() 메소드에서 구현하면 됨.

         */
        GithubRepository repository_1 = new GithubRepository();
        repository_1.setUser("whiteship");
        repository_1.setName("live-study");

        GithubIssueClone githubIssue_1 = new GithubIssueClone(repository);
        githubIssue_1.setId(1);
        githubIssue_1.setTitle("1주차 과제 : JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가");

        System.out.println(githubIssue_1.getUrl());

        GithubIssueClone githubIssue_1_clone = (GithubIssueClone) githubIssue_1.clone();
        System.out.println(githubIssue_1_clone.getUrl());

        System.out.println(githubIssue_1_clone != githubIssue_1); // true
        System.out.println(githubIssue_1_clone.equals(githubIssue_1)); // true
        System.out.println(githubIssue_1_clone.getClass() == githubIssue_1.getClass()); // true
        System.out.println(githubIssue_1_clone.getRepository() == githubIssue_1.getRepository()); // ture

    }
}
