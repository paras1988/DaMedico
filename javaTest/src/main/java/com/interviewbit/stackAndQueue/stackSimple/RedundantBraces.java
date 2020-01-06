package com.interviewbit.stackAndQueue.stackSimple;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        System.out.println(new RedundantBraces().braces("((a + b))"));
        System.out.println(new RedundantBraces().braces("(a+(b)/c)"));
        System.out.println(new RedundantBraces().braces("(a+b*(c-d))"));
    }

    public int braces(String A) {
        Stack stack = new Stack();

        for(int i=0;i < A.toCharArray().length;i++){
            stack.push(A.charAt(i));
            if(stack.peek().toString().equals(")")){
                Boolean containEx = false;
                while (!stack.peek().toString().equals("(") && !stack.isEmpty()){
                    String s = stack.pop().toString();
                    if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                        containEx = true;
                    }
                }
                stack.pop();
                if(!containEx){
                    return 1;
                }
            }
        }
        return 0;
    }
}
/*Given a string A denoting an expression. It contains the following operators ’+’, ‘-‘, ‘*’, ‘/’.

Chech whether A has redundant braces or not.

Return 1 if A has redundant braces, else return 0.

Note: A will be always a valid expression.



Input Format

The only argument given is string A.
Output Format

Return 1 if string has redundant braces, else return 0.
For Example

Input 1:
    A = "((a + b))"
Output 1:
    1
    Explanation 1:
        ((a + b)) has redundant braces so answer will be 1.

Input 2:
    A = "(a + (a + b))"
Output 2:
    0
    Explanation 2:
        (a + (a + b)) doesn't have have any redundant braces so answer will be 0.
        */