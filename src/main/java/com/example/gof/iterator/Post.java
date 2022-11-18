package com.example.gof.iterator;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Post {
    private String title;
    private LocalDateTime localDateTime;
    public Post(String content){
        this.title = content;
        this.localDateTime = LocalDateTime.now();
    }

    public LocalDateTime getCreatedDateTime(){
        return localDateTime;
    }
}
