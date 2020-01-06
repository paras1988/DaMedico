package com.interviewbit.stackAndQueue.Cleverstack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        System.out.println(Arrays.toString(new NearestSmallerElement().prevSmaller(arr)));
    }

    public int[] prevSmaller(int[] A) {

        int[] res = new int[A.length];
        Stack<Integer> st = new Stack();
        st.push(A[0]);
        res[0] = -1;

        for(int i=1;i<A.length;i++){
            while (!st.isEmpty() && st.peek()>=A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = st.peek();
            }
            st.push(A[i]);
        }
        return res;
    }
}
