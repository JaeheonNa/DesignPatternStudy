package com.example.gof.interpreter;

import java.util.Map;
import java.util.Stack;

public class InterpreterRunner {
    /*
    자주 등장하는 문제를 간단한 언어로 정의하고 재사용하는 패턴.
    반복되는 문제 패턴을 언어 또는 문법으로 정의하고 확장할 수 있다.
    요청을 캡슐화 하여 요청자와 수신자를 분리하는 패턴.
    장점 : 자주 등장하는 문제 패턴을 언어와 문법으로 정의할 수 있다.
          기존 코드를 변경하지 않고 새로운 Expression을 추가할 수 있다.
    단점 : 코드가 복잡해진다.
          복잡한 문법을 표현하려면 Expression과 Parser가 복잡해진다.
     */

    public static void run(){

        PostFixParser parser = new PostFixParser();
        PostFixExpression expression = parser.parse("xyz+-a+");

        Map context = Map.of('x', 1, 'y', 2, 'z', 3, 'a', 4);
        int result = expression.interpret(context);

        System.out.println(result);

    }
}
