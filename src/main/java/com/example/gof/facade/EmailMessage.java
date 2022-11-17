package com.example.gof.facade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailMessage {
    private String title;
    private String text;
    private String to;
    private String from;
}
