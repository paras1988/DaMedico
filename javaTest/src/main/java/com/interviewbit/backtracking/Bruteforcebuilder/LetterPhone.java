package com.interviewbit.backtracking.Bruteforcebuilder;

import java.util.ArrayList;
import java.util.Collections;

public class LetterPhone {

    public static void main(String[] args) {
        System.out.println(new LetterPhone().letterCombinations("23"));
    }

    public ArrayList<String> letterCombinations(String A) {
        if(A.length()==1){
            return getVal(String.valueOf(A.charAt(0)));
        }
        ArrayList<String> rest = letterCombinations(A.substring(1));
        ArrayList<String> str = getVal(String.valueOf(A.charAt(0)));

        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<rest.size();i++){
            for(int j=0;j<str.size();j++){
                String temp = str.get(j)+rest.get(i);
                res.add(temp);
            }
        }
        Collections.sort(res);
        return res;
    }

    ArrayList<String> getVal(String a){
        ArrayList<String>  str = new ArrayList<>();
        if(a.equals("0")){ str.add("0");}
        if(a.equals("1")){ str.add("1");}
        if(a.equals("2")){ str.add("a");str.add("b");str.add("c"); }
        if(a.equals("3")){ str.add("d");str.add("e");str.add("f"); }
        if(a.equals("4")){ str.add("g");str.add("h");str.add("i"); }
        if(a.equals("5")){ str.add("j");str.add("k");str.add("l");}
        if(a.equals("6")){str.add("m");str.add("n");str.add("o");}
        if(a.equals("7")){str.add("p");str.add("q");str.add("r");str.add("s");}
        if(a.equals("8")){str.add("t");str.add("u");str.add("v");}
        if(a.equals("9")){str.add("w");str.add("x");str.add("y");str.add("z");}

        return str;
    }

}

/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.


Backtracking is an algorithm for finding all solutions by exploring all potential candidates.
If the solution candidate turns to be not a solution (or at least not the last one),
backtracking algorithm discards it by making some changes on the previous step,
 i.e. backtracks and then try again.

Here is a backtrack function backtrack(combination, next_digits) which takes as arguments an
 ongoing letter combination and the next digits to check.

If there is no more digits to check that means that the current combination is done.
If there are still digits to check :
Iterate over the letters mapping the next available digit.
Append the current letter to the current combination combination = combination + letter.
Proceed to check next digits : backtrack(combination + letter, next_digits[1:]).


*/