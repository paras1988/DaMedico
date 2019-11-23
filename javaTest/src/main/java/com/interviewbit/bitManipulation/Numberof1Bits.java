package com.interviewbit.bitManipulation;

public class Numberof1Bits {

    public static void main(String[] args) {
        System.out.println(new Numberof1Bits().numSetBits(11));
        System.out.println(new Numberof1Bits().numSetBits(1));
    }

    public int numSetBits(long a) {
        int count = 0;
        while (a != 0){
            if(a%2 == 1){
                ++count;
            }
            a = a/2;
        }
        return count;
    }
}
