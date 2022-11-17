package com.example.gof.interpreter;

import java.util.Map;

public class MinusExpression implements PostFixExpression {

    PostFixExpression left, right;
    public MinusExpression(PostFixExpression left, PostFixExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Map<Character, Integer> context) {
        return left.interpret(context) - right.interpret(context);
    }
}
