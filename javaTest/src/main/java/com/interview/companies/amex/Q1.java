package com.interview.companies.amex;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(new Q1().solution(2,5));
        System.out.println(new Q1().solution(65536,65536));

    }

    public int solution(int A, int B) {
        int max = 0;
        int res = 0;
        for(int i=A;i<=B;i++){
            int sq = getTotalSqrt(Math.sqrt(i));
            if(sq>max){
                max = sq;
                res = i;
            }
        }
        System.out.println(res);
        return max;
    }

    private int getTotalSqrt(double i) {
        if(i!=(int)i){
            return 0;
        }
        return 1 + getTotalSqrt(Math.sqrt(i));
    }


}
