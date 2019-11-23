package com.interviewbit.arrays.Arraymath;


import java.util.ArrayList;
import java.util.List;

/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of
the list.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

 */
public class AddOneToNumber {

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(0);
        list.add(6);
        list.add(0);
        list.add(2);

        List<Integer> res;
        res=new AddOneToNumber().plusOne(list);
        System.out.println(res);
    }

    private List<Integer> plusOne(List<Integer> A) {
        ArrayList res = new ArrayList();
        int cf = 1;
        for(int i=0;i<A.size();i++){
            if(A.get(0)==0){
                A.remove(0);
            }
            else break;
        }
        for(int i=A.size()-1;i>=0;i--){
            int t = A.get(i)+cf;
            if(t>9){
                res.add(0,t%10);
                cf = t/10;
            }
            else{
                res.add(0,t);
                cf = 0;
            }
        }
        if(cf!=0){
            res.add(0,cf);
        }
        return res;
    }

}
