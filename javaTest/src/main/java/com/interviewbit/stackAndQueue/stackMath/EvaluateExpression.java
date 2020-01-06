package com.interviewbit.stackAndQueue.stackMath;

import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        String[] str = {"2", "1", "+", "3", "*"};
        System.out.println(new EvaluateExpression().evalRPN(str));

        String[] str2 = {"4", "13", "5", "/", "+"};
        System.out.println(new EvaluateExpression().evalRPN(str2));
    }

    public int evalRPN(String[] A) {
        Stack st = new Stack();

        for(int i=0;i<A.length;i++){
            st.push(A[i]);
        }

        return eval(st);
    }

    private int eval(Stack st) {
        String s = st.peek().toString();
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            st.pop();
            int right = eval(st);
            int left = eval(st);
            if(s.equals("+")){ return left+right; }
            else  if(s.equals("-")){ return left-right; }
            else  if(s.equals("*")){ return left*right; }
            else  { return left/right; }

        }
        else{
            return Integer.parseInt(st.pop().toString());
        }
    }
}
