package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(-3);
        A.add(3);
        System.out.println(new LargestContinuousSequenceZeroSum().lszero(A));
    }


    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int s = 0;
        int e = 0;
        int len = -1;
        map.put(0,-1);
        for(int i=0;i<A.size();i++){
            sum += A.get(i);
            if(map.containsKey(sum)){
                int val = map.get(sum);
                if(i-val>len){
                    len = i-val;
                    s = val+1;
                    e = i;
                }
            }
            else{
                map.put(sum,i);
            }

        }
        ArrayList<Integer> res= new ArrayList<>();
        if(len == -1){
            return res;
        }
        for(int i=s;i<=e;i++){
            res.add(A.get(i));
        }
        return res;
    }
}


/*Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

 NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

 */