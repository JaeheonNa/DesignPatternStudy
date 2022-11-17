package com.example.gof.interpreter;

import java.util.Map;
import java.util.Stack;

public class PostFixParser {
    public PostFixExpression parse(String expression){
        Stack<PostFixExpression> stack = new Stack<>();
        for(char c : expression.toCharArray()){
            stack.push(getExpression(c, stack));
        }
        return stack.pop();
    }

    private PostFixExpression getExpression(char c, Stack<PostFixExpression> stack){
        switch(c){
            case '+':
                return new PlusExpression(stack.pop(), stack.pop());
            case '-':
                PostFixExpression right = stack.pop();
                PostFixExpression left = stack.pop();
                return new MinusExpression(left, right);
            default:
                return new VariableExpression(c);
        }
    }

}
