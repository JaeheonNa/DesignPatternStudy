package com.example.gof;

import com.example.gof.abstractFactoryMethod.AbstractFactoryMethodRunner;
import com.example.gof.adaptor.AdaptorRunner;
import com.example.gof.bridge.BridgeRunner;
import com.example.gof.builder.BuilderRunner;
import com.example.gof.chainOfResponsibility.ChainOfResponsibilityRunner;
import com.example.gof.command.CommandRunner;
import com.example.gof.composite.CompositeRunner;
import com.example.gof.decorator.DecoratorRunner;
import com.example.gof.facade.FacadeRunner;
import com.example.gof.factoryMethod.FactoryMethodRunner;
import com.example.gof.flyweight.FlyweightRunner;
import com.example.gof.interpreter.InterpreterRunner;
import com.example.gof.iterator.IteratorRunner;
import com.example.gof.mediator.MediatorRunner;
import com.example.gof.memento.MementoRunner;
import com.example.gof.observer.ObserverRunner;
import com.example.gof.prototype.PrototypeRunner;
import com.example.gof.proxy.ProxyRunner;
import com.example.gof.singleton.SingletonRunner;
import com.example.gof.state.StateRunner;

import java.io.*;

import java.lang.reflect.InvocationTargetException;

public class GofApplication {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException, CloneNotSupportedException {

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<싱글턴>>>>>>>>>>>>>>>>>>>>>>>");
        SingletonRunner.run();
        /*
        <싱글톤 example>
            Runtime runtime = Runtime.getRuntime();
                --> java에서 제공하는 클래스. new로 생성 x. early loading.
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Singleton.class);
            String singleton_6 = applicationContext.getBean("getSingletonStr", String.class);
                --> spring을 활용한 방법.
         */


        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<팩토리 메소드>>>>>>>>>>>>>>>>>>>>>>>");
        FactoryMethodRunner.run();
        /*
        <팩토리 메소드 exmple>
            Calendar.getInstance(); --> 그레고리안 캘린더
            Calendar.getInstance(Locale.forLanguageTag("th-TH-x-lvariant-TH")); --> 부디스트 캘린더
            Calendar.getInstance(Locale.forLanguageTag("ja-JP-x-lvariant-JP")); --> 재페니즈임페리얼 캘린더
                --> java
            BeanFactory xmlFactory = new ClassPathXmlApplicationContext("config.xml");
            String hello = xmlFactory.getBean("hello", String.class);
            BeanFactory javaFactory = new AnnotationConfigApplicationContext(Config.class);
            String hi = javaFactory.getBean("hello", String.class);
                --> spring
         */


        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<추상 팩토리>>>>>>>>>>>>>>>>>>>>>>>");
        AbstractFactoryMethodRunner.run();


        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<빌더>>>>>>>>>>>>>>>>>>>>>>>");
        BuilderRunner.run();
        /*
        <빌더 exmaple>
            StringBuilder stringBuilder = new StringBuilder();
            String result = stringBuilder.append("whiteShip").append("German").toString();
                --> java
            UriComponents howToStudyJava  = UriComponentsBuilder.newInstance()
                                    .scheme("http")
                                    .host("www.whiteship.me")
                                    .path("java-playlist-ep1")
                                    .build().encode();
                --> spring
         */


        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<프로토타입>>>>>>>>>>>>>>>>>>>>>>>");
        PrototypeRunner.run();
        /*
        <프로토타입 example>
            ArrayList<String> origin = new ArrayList<String>();
            origin.add("첫번째");
            origin.add("두번째");
            ArrayList<String> clone_1 = (ArrayList<String>) origin.clone();
            List<String> clone_2 = new ArrayList<>(origin);
            --> java. clone_1의 방법은 잘 쓰지 않음. 추상적인 타입인 List로 생성할 수 없기 때문. (List는 Cloneable을 상속받지 않음.)
                      clone_2는 엄멀히 말하면 clone은 아니지만, 얕은 복사를 할 때 가장 많이 쓰이는 방법임.
            ModelMapper modelMapper = new ModelMapper();
            List<String> clone_3 = modelMapper.map(origin, ArrayList.class);
            --> modelMapper. 데이터를 복사해서 담고 싶을 때, ModelMapper라는 클래스를 참고할 것.
         */


        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<프로토타입>>>>>>>>>>>>>>>>>>>>>>>");
        AdaptorRunner.run();
        /*
        <어댑터 example>
            List<String> strings = Arrays.asList("a", "b", "c");
            --> 배열을 리스트로 바꿔줌. (배열은 연속된 공간, 리스트는 다음 노드의 주소값을 체인 형태로 물고 있는 형태)
            Enumeration<String> enumeration = Collections.enumeration(strings);
            --> Collection을 받아서 Enumeration으로 바꿔줌.
            ArrayList<String> list = Collections.list(enumeration);
            --> Enumeration을 받아서 ArrayList로 바꿔줌.
            try(InputStream is = new FileInputStream("input.txt");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr)){
                while(reader.ready()) System.out.println(reader.readLine());
            } catch (IOException e){
                throw e;
            }
            --> String을 InputStream으로 바꾸고, InputStream을 InputStreamReader로 바꾸고, InputStreamReader를 BufferedReader로 바꿔줌.
            --> java
         */


        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<브릿지>>>>>>>>>>>>>>>>>>>>>>>");
        BridgeRunner.run();
        /*
        <브릿지 example>
        Class.forName("org.h2.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stat = con.createStatement();
        --> java.
            Class.forName("org.h2.Driver"); 구체적인 클래스(org.h2.Driver)와
            추상화된 인터페이스(DriverManager, Connection, Statement, ResultSet)를 분리하여 연결.
         */


        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<컴포짓>>>>>>>>>>>>>>>>>>>>>>>");
        CompositeRunner.run();

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<데코레이터>>>>>>>>>>>>>>>>>>>>>>>");
        DecoratorRunner.run();
        /*
        <데코레이터 example>
        try(InputStream is = new FileInputStream("input.txt");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr)){
                while(reader.ready()) System.out.println(reader.readLine());
            } catch (IOException e){
                throw e;
            }
        -> java. 목적에 따라 어댑터 패턴으로도, 데코레이터 패턴으로도 볼 수 있음.
         */

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<퍼사드>>>>>>>>>>>>>>>>>>>>>>>");
        FacadeRunner.run();
        /*
        <퍼사드 example>
        MailSender mailSender = new JavaMailSenderImpl();
        --> 여기서 MailSender는 Spring, JavaMailSenderImple은 java.
            MailSender를 JavaMailSenderImpl이 구현한 내용을 숨긴 퍼사드로 볼 수 있음.
            브릿지 패턴으로도 볼 수 있음.
         */

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<플라이웨이트>>>>>>>>>>>>>>>>>>>>>>>");
        FlyweightRunner.run();
        /*
        <플라이웨이트 example>
        Integer i1 = Integer.valueOf(10);
        Integer i2 = Integer.valueOf(10);
        System.out.println(i1 == i2); //true.
        --> java. Integer.valueOf()는 -128~127 범위에 있는 값들을 캐싱함.
         */

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<프록시>>>>>>>>>>>>>>>>>>>>>>>");
        ProxyRunner.run();
        /*
        <프록시 example>
        dynamicProxy
        --> java.
        AOP
        --> Spring.
         */

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<책임연쇄>>>>>>>>>>>>>>>>>>>>>>>");
        ChainOfResponsibilityRunner.run();
        /*
        <책임연쇄 example>
        Filter filter = new Filter(){
            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
                // TODO 전처리
                chain.doFilter(request, response);
                // TODO 후처리
            }
        };
        --> java. 서블릿 필터.
        스프링 시큐리티
         */

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<커맨드>>>>>>>>>>>>>>>>>>>>>>>");
        CommandRunner.run();
        /*
        <커맨드 example>
        new Runnable().run();
        --> java. thread.
         */

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<인터프리터>>>>>>>>>>>>>>>>>>>>>>>");
        InterpreterRunner.run();

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<이터레이터>>>>>>>>>>>>>>>>>>>>>>>");
        IteratorRunner.run();
        /*
        <이터레이터 example>
        Iterator, Enumeration
        --> java.
         */

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<중재자>>>>>>>>>>>>>>>>>>>>>>>");
        MediatorRunner.run();
        /*
        <중재자 example>
        ExecutorService, Executore
        --> java.
        DispatcherServlet
        --> Spring(MVC)
         */

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<메멘토>>>>>>>>>>>>>>>>>>>>>>>");
        MementoRunner.run();
        /*
        <메멘토 example>
        직렬화-역질렬화
        try(FileOutputStream fos = new FileOutputStream("GameSave.hex");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(game);
        }
        try(FileInputStream fis = new FileInputStream("GameSave.hex");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            game = (Game) ois.readObject();
        }
        --> java
         */

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<옵저버>>>>>>>>>>>>>>>>>>>>>>>");
        ObserverRunner.run();
        /*
        <옵저버 example>
        Observer 인터페이스, Observable 클래스. 현재 권장되지 않음.
        대신 1. PropertyChangeListener, PropertyChangeEvent, PropertyChangeSupport 사용.
            2. Flow API(Flow.Publisher, Flow.Subscriber, Flow.Subscription) 사용 추천.
        --> java.
        ApplicationContext(IoCContainer) --> 사실상 event publisher임. ApplicationEventPublisher를 구현하고 있기 때문.
        @EventListener
        --> spring
         */

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<상태>>>>>>>>>>>>>>>>>>>>>>>");
        StateRunner.run();

    }

}
