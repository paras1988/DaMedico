package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum_2 {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);
        A.add(4);

        System.out.println(new Sum_2().twoSum(A,4));
    }

    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<A.size();i++){
            int val = B - A.get(i);
            if(map.containsKey(val)){
                res.add(map.get(val)+1);
                res.add(i+1);
                break;
            }
            else if(map.containsKey(A.get(i))){
                continue;
            }
            else {
                map.put(A.get(i),i);
            }
        }
        return res;
    }
}
/*Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2.
Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make
things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2,
choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2

*/