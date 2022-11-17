package com.example.gof.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Item implements Component{
    private String name;
    private int price;

    //@Override 어노테이션이 있어야 컴파일 타임에 해당 메소드가 인터페이스 메소드를 구현한 것인지 체크를 해줌.
    @Override
    public int getPrice(){
        return this.price;
    }
}
