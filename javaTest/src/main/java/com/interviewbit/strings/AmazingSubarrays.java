package com.interviewbit.strings;

public class AmazingSubarrays {

    public static void main(String[] args) {
        System.out.println(new AmazingSubarrays().solve("ABEC"));
        System.out.println(new AmazingSubarrays().solve("A"));
        System.out.println(new AmazingSubarrays().solve(""));
        System.out.println(new AmazingSubarrays().solve("aA"));

    }

    public int solve(String A) {

        int count = 0;
        for(int i=0;i<A.length();i++){
            if(isVowel(A.charAt(i))){
                count = count % 10003;
                count += (A.length() - i);
            }
        }
        return count;
    }

    static boolean isVowel(Character character){
        if(character == 'a'
            ||    character == 'e'
                ||    character == 'i'
                ||    character == 'o'
                ||    character == 'u'
                ||    character == 'A'
                ||    character == 'E'
                ||    character == 'I'
                ||    character == 'O'
                ||    character == 'U'){
            return true;
        }
        return false;
    }


}
