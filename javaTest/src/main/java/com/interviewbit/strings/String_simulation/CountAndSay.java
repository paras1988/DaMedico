package com.interviewbit.strings.String_simulation;

public class CountAndSay {


    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(1));
        System.out.println(new CountAndSay().countAndSay(2));
        System.out.println(new CountAndSay().countAndSay(3));
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));
        System.out.println(new CountAndSay().countAndSay(6));
        System.out.println(new CountAndSay().countAndSay(7));
    }

    public String countAndSay(int A) {
        String res = "";
        for(int i=0;i<A;i++){
            res = compute(res);
        }
        return res;
    }

    private String compute(String res) {
        if(res == ""){
            return "1";
        }
        String r = "";
        int count = 1;
        char t = res.charAt(0);
        for(int i=1;i<res.length();i++){
            if(t == res.charAt(i)){
                count++;
            }
            else{
                r = r.concat(Integer.toString(count));
                r = r.concat(Character.toString(t));


                t = res.charAt(i);
                count = 1;
            }
        }
        r = r.concat(Integer.toString(count));
        r = r.concat(Character.toString(t));


        return r;
    }
}

/*The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.
*/
