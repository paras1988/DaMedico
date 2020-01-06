package com.interviewbit.heap_treeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersinWindow {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);a.add(2);a.add(1);
        a.add(3);a.add(4);a.add(3);

        System.out.println(new DistinctNumbersinWindow().dNums(a,3));
    }


    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<B;i++){
            if(map.containsKey(A.get(i))){
                int num = map.get(A.get(i));
                map.put(A.get(i),num+1);
            }
            else{
                map.put(A.get(i),1);
            }
        }
        res.add(map.size());

        for(int i=B;i<A.size();i++){
            if(A.get(i).equals(A.get(i-B))){
                res.add(map.size());
                continue;
            }
            if(!map.containsKey(A.get(i))){
                map.put(A.get(i),1);
            }
            else{
                int num = map.get(A.get(i));
                map.put(A.get(i),num+1);
            }
            int num = map.get(A.get(i-B));
            if(num == 1){
                map.remove(A.get(i-B));
            }
            else{
                map.put(A.get(i-B),num-1);
            }
            res.add(map.size());
        }

        return res;
    }
}
/**
 *
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.
 *
 * Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
 *
 * Note:
 *
 *  If K > N, return empty array.
 *  A[i] is a signed integer
 * For example,
 *
 * A=[1, 2, 1, 3, 4, 3] and K = 3
 *
 * All windows of size K are
 *
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 *
 * So, we return an array [2, 3, 3, 2].
 *
 *
 * */