package com.example.gof.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonRunner {

    public static void run() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Singleton singleton = Singleton.getInstance();
        Singleton _singleton = Singleton.getInstance();
        System.out.println(singleton == _singleton);
        // false. but 싱글톤 아님.


        Singleton singleton_1 = Singleton.getInstance_1();
        Singleton _singleton_1 = Singleton.getInstance_1();
        System.out.println(singleton_1 == _singleton_1);
        // true. 싱글톤. but thread safe하지 않음.

        Singleton singleton_2 = Singleton.getInstance_2();
        Singleton _singleton_2 = Singleton.getInstance_2();
        System.out.println(singleton_2 == _singleton_2);
        // true. 싱글톤. thread safe. but 매번 synchronized 작업 부하 발생.

        Singleton singleton_3 = Singleton.getInstance_3();
        Singleton _singleton_3 = Singleton.getInstance_3();
        System.out.println(singleton_3 == _singleton_3);
        // true. 싱글톤. thread safe. synchronized 작업 부하 발생 안 함. 서버가 올라갈 때 미리 생성(이른 초기화). 만들어놨는데 쓰지 않는 경우 낭비.

        Singleton singleton_4 = Singleton.getInstance_4();
        Singleton _singleton_4 = Singleton.getInstance_4();
        System.out.println(singleton_4 == _singleton_4);
        // true. 싱글톤. thread safe. synchronized 작업 부하 없음. 필요할 때 생성 lazy loading. 로직 다소 복잡.

        Singleton singleton_5 = Singleton.getInstance_5();
        Singleton _singleton_5 = Singleton.getInstance_5();
        System.out.println(singleton_5 == _singleton_5);
        // true. 싱글톤. thread safe. synchronized 작업 부하 없음. 필요할 때 생성 lazy loading. 로직 단순.


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Singleton.class);
        String singleton_6 = applicationContext.getBean("getSingletonStr", String.class);
        String _singleton_6 = applicationContext.getBean("getSingletonStr", String.class);
        System.out.println(singleton_6 == _singleton_6);
        // 스프링 빈을 활용한 방법. true. 싱글톤. thread safe. synchronized 작업 부하 없음. early loading.






        /*
        싱글톤 패턴을 깨뜨리는 방법_1
        리플렉션. Constructor 클래스 사용.
        new 한 것과 동일한 효과.
        막는 방법 없음.
        */
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singleton_7 = constructor.newInstance();
        System.out.println(singleton_5 == singleton_7);
        // false. 싱글톤으로 객체를 생성하도록 클래스를 작성하더라도 위와 같은 방법으로는 싱글톤이 깨짐. 단, class가 아닌 enum으로 작성하면 방지 가능. enum은 java reflection에서 막아뒀기 때문.
        // 단 enum은 lazy loading이 안 됨. && enum은 상속받을 수가 없음. (컴파일 할 때 enum만 상속 가능).
        // enum은 직렬화/역직렬화를 통한 싱글톤 파훼도 막음. 역직렬화 해도 같은 메모리 주소값을 가짐. (enum은 기본적으로 Serializable을 구현함.)


        /*
        싱글톤 패턴을 깨뜨리는 방법_2
        직렬화/역직렬화.
            직렬화: 객체를 파일로 저장.
            역직렬화: 파일로 저장한 객체를 재로딩.
        readResolve()로 대처 가능.
        */
        Singleton singleton_8;
        // FileOutputStream으로 파일시스템에 파일 파이프라인 연결.
        // ObjectOutputStream으로 FileOutputStream에 객체 파이프라인 연결.
        // "singleton.obj"라는 이름의 파일 저장할 계획.
        // 객체파이프라인과 파일파이프라인을 통해 객체를 파일시스템에 저장할 'out'이라는 객체 생성.
        // 싱글톤으로 생성된 singleton_5라는 객체를 저장.
        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.obj"))){
            out.writeObject(singleton_5);
        }
        // FileInputStream으로 파일시스템에 파일 파이프라인 연결.
        // ObjectInputStream으로 FileInputStream에 객체 파이프라인 연결.
        // 직렬화로 저장해두었던 "singleton.obj"라는 이름의 파일을 읽을 계획.
        // 객체파이프라인과 파일파이프라인을 통해 객체를 파일시스템에서 로드할 'in'이라는 객체 생성.
        // 직렬화로 저장해두었던 객체를 캐스팅하여 singleton_7으로 로드.
        try(ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.obj"))){
            singleton_8 = (Singleton) in.readObject();
        }
        System.out.println(singleton_5 == singleton_8);
        // false. 역직렬화 시 객체를 새로 생성함. 그러니까 역직렬화로 로드할 때 객체의 메모리 주소값이 이전 객체와 같을 수 없음.
        // but class에 readResolve()라는 메소드를 구현하면 해결 가능.
        // Serializable에 존재하는 메소드는 아니지만 오버라이딩. 역직렬화 시 readResolve라는 메소드를 반드시 타게 됨.
        /*
            protected Object readResolve(){
                return getInstance_5();
            }
        */
        // 위와 같이 클래스에 구현해 두면 singleton_5 == singleton_7은 true.


    }
}
