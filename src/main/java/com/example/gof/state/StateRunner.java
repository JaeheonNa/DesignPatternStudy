package com.example.gof.state;

public class StateRunner {
    /*
    객체 내부 상태 변경에 따라 객체의 행동이 달라지는 패턴.
    상태에 특화된 행동들을 분리해낼 수 있으며, 새로운 행동을 추가하더라도 다른 행동에 영향을 주지 않는다.
    장점 : 상태에 따른 동작을 개별 클래스로 옮겨서 관리할 수 있다.
          기존의 특정 상태에 따른 동작을 변경하지 않고 새로운 상태에 따른 동작을 추가할 수 있다.
          코드 복잡도를 줄일 수 있다.
    단점 : 상태에 따른 간단한 동장이거나 상태의 수가 적은데도 불구하고 적용할 경우 복잡도가 증가할 수 있다.
     */
    public static void run(){
        OnlineCourse onlineCourse = new OnlineCourse();
        Student moon = new Student("Moon");
        Student heony = new Student("Heony");

        heony.addPrivate(onlineCourse);



        onlineCourse.addStudent(moon);

        onlineCourse.setState(new Private(onlineCourse));

        onlineCourse.addReview("hello", moon);
        onlineCourse.addStudent(heony);

        System.out.println(onlineCourse.getReviews());
        System.out.println(onlineCourse.getState());
        System.out.println(onlineCourse.getStudents());
    }
}
