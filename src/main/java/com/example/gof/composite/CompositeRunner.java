package com.example.gof.composite;

import java.util.concurrent.atomic.AtomicInteger;

public class CompositeRunner {

    /*
    컴포짓 패턴 적용 전.

    public static void run(){
        Item doranBlade = new Item("도란검", 450);
        Item healPotion = new Item("체력 물약", 50);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healPotion);

        CompositeRunner client = new CompositeRunner();
        client.printPrice(doranBlade);
        client.printPrice(bag);
    }
    private void printPrice(Item doranBlade) {
        System.out.println(doranBlade.getPrice());
    }

    private void printPrice(Bag bag) {
//        AtomicInteger totalPrice = new AtomicInteger();
//        bag.getItems().stream().forEach(item -> totalPrice.addAndGet(item.getPrice()));
        int totalPrice = bag.getItems().stream().mapToInt(Item::getPrice).sum();
        System.out.println(totalPrice);
    }
     */

    /*
    컴포짓 패턴 적용.
    장점: 복잡한 트리 구조를 편리하게 사용할 수 있다.
         다형성과 재귀를 활용할 수 있다.
         클라이언트 코드를 변경하지 않고 새로운 엘리먼트 타입을 추가할 수 있다. OCP.
    단점: 트리를 만들어야 하기 때문에(공통된 인터페이스를 정의해야하기 때문에) 치나친 일반화를 해야하는 경우도 생길 수 있음.
     */
    public static void run(){
        Item doranBlade = new Item("도란검", 450);
        Item healPotion = new Item("체력 물약", 50);
        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healPotion);

        CompositeRunner client = new CompositeRunner();
        client.getPrice(doranBlade);
        client.getPrice(bag);

    }

    private void getPrice(Component component) {
        System.out.println(component.getPrice());
    }


}
