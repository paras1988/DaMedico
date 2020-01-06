package com.interviewbit.heap_treeMap;


import java.util.*;

public class Nmax_pair_combinations {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);a.add(3);a.add(11);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);b.add(5);b.add(10);

        System.out.println(new Nmax_pair_combinations().solve(a,b));

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);

        int k = A.size();

        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair<Integer,Pair<Integer,Integer>>> queue = new PriorityQueue<>(Collections.reverseOrder());
        Set<Pair<Integer,Integer>> set = new HashSet<>();

        int i = A.size()-1;
        int j = B.size()-1;
        queue.add(Pair.of(A.get(i)+B.get(j),Pair.of(i,j)));
        set.add(Pair.of(i,j));

        for(int c=0;c<k;c++){

            Pair<Integer,Pair<Integer,Integer>> p = queue.remove();
            res.add(p.getLeft());

            i = p.getRight().getLeft();
            j = p.getRight().getRight();

            if(!set.contains(Pair.of(i-1,j)) && i>0){
                queue.add(Pair.of(A.get(i-1)+B.get(j),Pair.of(i-1,j)));
                set.add(Pair.of(i-1,j));
            }
            if(!set.contains(Pair.of(i,j-1)) && j>0){
                queue.add(Pair.of(A.get(i)+B.get(j-1),Pair.of(i,j-1)));
                set.add(Pair.of(i,j-1));
            }
        }
        return res;
    }

    static class Pair<L, R> implements Comparable{

        L left;
        R right;

        Pair(L left,R right){
            this.left = left;
            this.right = right;
        }

        public static  <L, R>  Pair<L,R> of(L left,R right){
            return new Pair<L,R>(left,right);
        }


        public L getLeft() {
            return this.left;
        }


        public R getRight() {
            return this.right;
        }

        @Override
        public int compareTo(Object o) {
            Pair p2 = (Pair)o;
            Pair p1 = this;

            if(((Comparable)p1.left).compareTo(p2.left) == 0){
                return ((Comparable)p1.right).compareTo(p2.right);
            }
            return ((Comparable)p1.left).compareTo(p2.left);
         }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(left, pair.left) &&
                    Objects.equals(right, pair.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }

}
/*
* Given two arrays A & B of size N each.
Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
and maximum 2 elements are 6, 5

Example:

N = 4
a[]={1,4,2,3}
b[]={2,5,1,6}

Maximum 4 elements of combinations sum are
10   (4+6),
9    (3+6),
9    (4+5),
8    (2+6)

*
* */