package com.interviewbit.bitManipulation;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverse(3));
        System.out.println(new ReverseBits().reverse(0));
    }


    public long reverse(long a) {

        long count = 0;
        int i =31;
        while (a != 0){
            if(a%2 == 1){
                count += Math.pow(2,i);
            }
            i--;
            a = a/2;
        }
        return count;
    }
}
