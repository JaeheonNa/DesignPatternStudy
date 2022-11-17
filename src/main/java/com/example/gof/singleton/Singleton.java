package com.example.gof.singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Singleton implements Serializable {

    // 생성자 접근제한자를 private으로 하면 외부에서 new를 할 수 없게 됨.
    private Singleton(){}
    // 외부에서 new 객체에 접근하려면 이와 같은 식으로..
    // static하므로 서버가 올라갈 때 이미 메모리에 올라감. so, 객체를 new 하지 않아도 접근 가능한 메소드가 됨.
    // But, getInstance_1을 호출할 때마다 new를 하므로, Singleton이 아님.
    public static Singleton getInstance(){
        return new Singleton();
    }





    // singleton 객체를 외부 접근 못하게 막아놓고, 서버가 올라갈 때 메모리에 올린 후,
    // getInstance_2로 접근하되, 해당 객체가 null일 경우에만 new.
    // 가장 나이브한 Singleton.
    // But 멀티스레드 환경에서 thread safe하지 않음.
    private static Singleton singleton_1;
    public static Singleton getInstance_1(){
        if(singleton_1 == null) {
            singleton_1 = new Singleton();
            return singleton_1;
        } else {
            return singleton_1;
        }
    }





    // singleton 객체를 외부 접근 못하게 막아놓고, 서버가 올라갈 때 메모리에 올린 후,
    // getInstance_2로 접근하되, 해당 객체가 null일 경우에만 new.
    // 가장 나이브한 Singleton.
    // 멀티스레드 환경에서 thread safe.
    // But 매번 synchroniezed 작업 부하 발생.
    private static Singleton singleton_2;
    public static synchronized Singleton getInstance_2(){
        if(singleton_2 == null) {
            singleton_2 = new Singleton();
            return singleton_2;
        } else {
            return singleton_2;
        }
    }





    // 객체를 서버가 올라갈 때 미리 만들어도 되는 상황이라면 아래처럼 만드는 것이 유리.
    // final 객체이므로 대문자 표시.
    private static final Singleton SINGLETON_3 = new Singleton();
    public static Singleton getInstance_3(){
        return SINGLETON_3;
    }





    // synchronized 앞에 두 개의 thread가 있는 상태에서 하나의 thread가 lock을 걸면서 안으로 진입.
    // 객체가 null 객체 new.
    // 다음 thread가 synchronized 안으로 들어와도 객체는 null이 아니기 때문에 new 하지 않음.
    // Singleton. thread safe. synchronized 부하 없음. 필요할 때 생성.
    // volatile keyword는 Java 변수를 Main Memory에 저장하겠다라는 것을 명시.
    // 매번 변수의 값을 Read할 때마다 CPU cache에 저장된 값이 아닌 Main Memory에서 읽는 것.
    // 또한 변수의 값을 Write할 때마다 Main Memory에 까지 작성하는 것.
    // volatile 변수를 사용하고 있지 않는 MultiThread 어플리케이션에서는 Task를 수행하는 동안 성능 향상을 위해 Main Memory에서 읽은 변수 값을 CPU Cache에 저장하게 됨.
    // 만약에 Multi Thread환경에서 Thread가 변수 값을 읽어올 때 각각의 CPU Cache에 저장된 값이 다르기 때문에 변수 값 불일치 문제가 발생하게 됨.
    private static volatile Singleton singleton_4;
    public static Singleton getInstance_4(){
        if(singleton_4 == null){
            synchronized (Singleton.class){
                if(singleton_4 == null){
                    singleton_4 = new Singleton();
                }
            }
        }
        return singleton_4;
    }





    // static inner class 사용.
    // getSingleton_5()가 호출 될 때 SingletonHolder라는 inner class가 메모리에 로딩되면서 new.
    // final이기 때문에 thread safe. synchronized 부하 없음. 사용할 때 new하기 때문에 메모리 낭비 염려 없음.
    // 가장 권장되는 방법.
    private static class SingletonHolder{
        private static final Singleton SINGLETON = new Singleton();
    }
    public static Singleton getInstance_5(){
        return SingletonHolder.SINGLETON;
    }

    // 역직렬화 시 반드시 타게 되는 메소드.
    protected Object readResolve(){
        return getInstance_5();
    }




    // Spring bean 활용.
    @Bean
    public String getSingletonStr(){
        return "Hello Singleton";
    }


}
