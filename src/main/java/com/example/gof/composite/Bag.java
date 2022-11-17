package com.example.gof.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Bag implements Component{
    private List<Component> items = new ArrayList<>();

    public void add(Component item){
        items.add(item);
    }

    public List<Component> getItems(){
        return this.items;
    }

    @Override
    public int getPrice() {
        return this.items.stream().mapToInt(Component::getPrice).sum();
    }
}
