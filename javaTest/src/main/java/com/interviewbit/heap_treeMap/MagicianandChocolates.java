package com.interviewbit.heap_treeMap;

import java.util.*;

public class MagicianandChocolates {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2147483647);a.add(2000000014);a.add(2147483647);

        System.out.println(new MagicianandChocolates().nchoc(10,a));
    }


    /*public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        Collections.sort(B,Collections.reverseOrder());

        if(B.isEmpty()){
            return 0;
        }
        pq.add(B.get(0));

        List<Integer> res = new ArrayList<>();

        for(int i=1;i<=A;i++){

            int t = pq.remove();
            res.add(t);
            pq.add(t/2);

            if(i<B.size()) {
                pq.add(B.get(i));
            }
        }

        int result = 0;
        for(int i=0;i<res.size();i++){
            result = (result % 1000000007) + (res.get(i) % 1000000007);
        }

        return result;
    }*/

    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue(Collections.reverseOrder());
        Set<Integer> set = new HashSet<>();

        Collections.sort(B,Collections.reverseOrder());

        if(B.isEmpty()){
            return 0;
        }
        pq.add(Pair.of(B.get(0),0));
        set.add(0);

        List<Integer> res = new ArrayList<>();

        for(int i=1;i<=A;i++){

            Pair<Integer,Integer> p  = pq.remove();
            res.add(p.left);
            int k = p.right;
            pq.add(new Pair<>(p.left/2,k));

            if(!set.contains(k+1) && k+1<B.size()) {
                pq.add(Pair.of(B.get(k+1),k+1));
                set.add(k+1);
            }
        }

        long result = 0;
        for(int i=0;i<res.size();i++){
            result = result + res.get(i);
        }


        return (int)(result%1000000007);
    }

    static class Pair<L, R> implements Comparable{

        L left;
        R right;

        Pair(L left,R right){
            this.left = left;
            this.right = right;
        }

        public static  <L, R> Pair<L,R> of(L left, R right){
            return new Pair<L,R>(left,right);
        }

        @Override
        public int compareTo(Object o) {
            Pair p2 = (Pair)o;
            Pair p1 = this;

            return ((Comparable)p1.left).compareTo(p2.left);
        }
    }

}
/*
* Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i,
* eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7

*
* */