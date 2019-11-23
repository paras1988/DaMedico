package com.interviewbit.strings;


//take string and conver to int
public class Atoi {

    public static void main(String[] args) {
        System.out.println(new Atoi().atoi("+1"));

        System.out.println(new Atoi().atoi("-9 2704"));
        System.out.println(new Atoi().atoi("-9@2704"));
        System.out.println(new Atoi().atoi("-12345"));
        System.out.println(new Atoi().atoi("-1"));

        System.out.println(new Atoi().atoi("9 2704"));
        System.out.println(new Atoi().atoi("9@2704"));
        System.out.println(new Atoi().atoi("12345"));
        System.out.println(new Atoi().atoi("1"));

        System.out.println(new Atoi().atoi("-54332872018247709407 4 54"));
        System.out.println(new Atoi().atoi("-107196139"));
    }

    public int atoi(final String A) {
        int index = A.length();

        int start = 0;
        if(A.charAt(0)=='-' || A.charAt(0)=='+'){
            start = 1;
        }

        for(int i=start;i<A.length();i++){
            if (!Character.isDigit(A.charAt(i))){
                index = i;
                break;
            }
        }
        if(index-start>9){
            if(A.charAt(0) == '-'){
                return Integer.MIN_VALUE;
            }
            else{
                return Integer.MAX_VALUE;
            }
        }

        int res = 0;
        for(int i=start;i<index;i++){
                res += Integer.parseInt(Character.toString(A.charAt(i)))*Math.pow(10,index-i-1);
        }
        if(start==0 || A.charAt(0)== '+'){
            return res;
        }
        return -1*res;
    }
}
