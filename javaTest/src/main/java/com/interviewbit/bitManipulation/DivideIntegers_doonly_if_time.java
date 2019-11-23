package com.interviewbit.bitManipulation;

 class DivideIntegers {

    public static void main(String[] args) {
        System.out.println(new DivideIntegers().divide(1,2));
        System.out.println(new DivideIntegers().divide(5,2));
        System.out.println(new DivideIntegers().divide(5,1));
        System.out.println(new DivideIntegers().divide(283647,1));
    }

    public int divide(int A, int B) {
        int res =0;
        int count = 0;
        while (res + B <= A){
            res += B;
            ++count;
        }
        return count;
    }
}
