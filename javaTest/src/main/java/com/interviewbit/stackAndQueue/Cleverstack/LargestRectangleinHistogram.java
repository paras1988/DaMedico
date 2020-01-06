package com.interviewbit.stackAndQueue.Cleverstack;


import java.util.Arrays;
import java.util.Stack;


public class LargestRectangleinHistogram {

    public static void main(String[] args) {
          int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(arr));

        int[] arr1 = {1, 2, 3, 6, 2};
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(arr1));

        int[] arr2 = {2, 3};
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(arr2));

        int[] arr3 = {2};
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(arr3));


    }

    public int largestRectangleArea(int[] A) {
        Stack<Integer> st = new Stack<Integer>();

        int res = 0;
        int i=0;
        for(;i<A.length;){
            if (st.isEmpty() || A[st.peek()] <= A[i]){
                st.push(i++);
            }
            else {
                    int a = st.pop();
                    res = Math.max(res,A[a]*(st.empty()?i:i-a));
            }
        }
        while (!st.isEmpty()){
            int a = st.pop();
            res = Math.max(res, A[a]*(st.empty()?i:i-a));
        }
        return res;
    }
}
/*Given an array of integers A of size N. A represents a histogram i.e A[i] denotes height of
the ith histogram’s bar. Width of each bar is 1.

Largest Rectangle in Histogram: Example 1

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Largest Rectangle in Histogram: Example 2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Find the area of largest rectangle in the histogram.



Input Format

The only argument given is the integer array A.
Output Format

Return the area of largest rectangle in the histogram.
For Example

Input 1:
    A = [2, 1, 5, 6, 2, 3]
Output 1:
    10
    Explanation 1:
        The largest rectangle is shown in the shaded area, which has area = 10 unit.
        */