package com.example.gof.abstractFactoryMethod;

public interface AshipFactory {
    default Aship orderShip(String name, String email){
        validate(name, email);
        prepare(name);
        Aship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }


    // private으로 정의하면 하위 클래스가 구현하지 않아도 됨.
    // java9 부터 가능.
    // java8에서는 추상 클래스를 만들어 인터페이스 상속 후 private 메소드를 구현.
    private static void validate(String name, String email){
        if(name == null || name.isBlank()) throw new IllegalArgumentException("배 이름을 지어주세요.");
        if(email == null || email.isBlank()) throw new IllegalArgumentException("연락처를 남겨주세요.");
    }


    // private으로 정의하면 하위 클래스가 구현하지 않아도 됨.
    private static void prepare(String name){
        System.out.println(name + " 제작 준비 중...");
    }


    // private으로 정의하지 않아 하위 클래스에서 정의해야 함.
    Aship createShip();


    private static void sendEmailTo(String email, Aship ship){
        System.out.println(ship.getName() + "을 다 만들었습니다.");
    }

}

