package com.interviewbit.dynamicProgramming;

public class WaystoDecode {

    public static void main(String[] args) {
        System.out.println(new WaystoDecode().numDecodings("875361268549483279131"));
        System.out.println(new WaystoDecode().numDecodings("175"));
        System.out.println(new WaystoDecode().numDecodings("1075"));
        System.out.println(new WaystoDecode().numDecodings("10"));
        System.out.println(new WaystoDecode().numDecodings("90"));
    }


    int count = 0;
    //non memoized
    public int recusriveNumDecodings(String A) {
        if(A.length()<2){return  1; }

        count += recusriveNumDecodings(A.substring(0, A.length()-1));

        if(Integer.parseInt(A.substring(A.length()-2)) < 27){
            count += recusriveNumDecodings(A.substring(0, A.length()-2));
        }

        return  count;
    }

    public int numDecodings(String A) {

        int[] res = new int[A.length()+1];
        res[0] = 1;
        res[1] = 1;

        if(A.charAt(0) == '0'){
            return 0;
        }

        for(int i=2;i<=A.length();i++){
            int count1 = 0;

            if(A.charAt(i-1)!='0'){
                count1 += res[i-1];
            }
            else{
                if(A.charAt(i-2)!='1' && A.charAt(i-2)!='2'){
                    return 0;
                }
            }
            if(A.charAt(i-2)=='1' || (A.charAt(i-2)=='2' && A.charAt(i-1)<'7')){
                count1 += res[i-2];
            }
            res[i] = count1;
        }

        return  res[A.length()];
    }
}
/**
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *  112:
 *
 *  AAB
 *  KB
 *  AL
 *
 *
 * Input Format:
 *
 * The first and the only argument is a string A.
 * Output Format:
 *
 * Return an integer, representing the number of ways to decode the string.
 * Constraints:
 *
 * 1 <= length(A) <= 1e5
 * Example :
 *
 * Input 1:
 *     A = "8"
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Given encoded message "8", it could be decoded as only "H" (8).
 *
 *     The number of ways decoding "8" is 1.
 *
 * Input 2:
 *     A = "12"
 *
 * Output 2:
 *     2
 *
 * Explanation 2:
 *     Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 *
 *     The number of ways decoding "12" is 2.
 *
 * */