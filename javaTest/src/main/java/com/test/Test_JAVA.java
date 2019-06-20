package com.test;

public class Test_JAVA {

    public static void main(String[] args) {

        int a = 9247;

        int count = 0;

        for(int i=5;i<=a;i=i+5){
            count = count + countZeroesTrail(i);
            count = count + countZeroesTrail_5(removeZeroesTrail(i));

            System.out.println(i +"->count "+count);
        }
        System.out.println(count);
    }

    private static int countZeroesTrail_5(int i) {
        int count = 0;
        while(i%5==0){
            count++;
            i = i/5;
        }
        return count;
    }

    private static int countZeroesTrail(int i) {
        int count = 0;
        while(i%10==0){
            count++;
            i = i/10;
        }
        return count;
    }

    private static int removeZeroesTrail(int i) {
        while(i%10==0){
            i = i/10;
        }
        return i;
    }

}
