package com.interviewbit.strings;

//KMP
public class ImplementStrStr_practiceKMP {

    public static void main(String[] args) {
        System.out.println(new ImplementStrStr_practiceKMP().strStr("AABAACAADAABAABA","AABA"));
        System.out.println(new ImplementStrStr_practiceKMP().strStr("THIS IS A TEST TEXT","TEST"));
    }

    public int strStr(final String A, final String B) {
        // Base Case
        if (B == null || B.length() == 0 || A == null || B.length() > A.length()) {
            return -1;
        }

        int[] LPS = new int[B.length()];

        int j=0;
        LPS[j] = 0;
        for(int i=1;i<B.length();){

            if(B.charAt(i) == B.charAt(j)){
                j++;
                LPS[i] = j;
                i++;
            }
            else{
                if(j!=0){
                    j = LPS[j-1];
                }
                else{
                    LPS[i] = 0;
                    i++;
                }
            }
        }

        j=0;
        for(int i=0;i<A.length();){
            if(A.charAt(i) == B.charAt(j)){
                i++;
                j++;
            }
            if(j==B.length()){
                return i - B.length();
            }
            else if(i < A.length() && B.charAt(j) != A.charAt(i) ){
                if( j != 0 ){
                    j = LPS[j-1];
                }
                else{
                    i= i+1;
                }
            }
        }
        return -1;
    }
}
