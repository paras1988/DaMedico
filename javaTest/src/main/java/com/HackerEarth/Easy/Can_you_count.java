package com.HackerEarth.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Can_you_count {
  public static void main(String args[]) throws Exception {

    //Scanner
    Scanner s = new Scanner(System.in);
    Integer testcases = Integer.parseInt(s.nextLine());                 // Reading input from STDIN

    for (int kk = 1; kk <= testcases; kk++) {
      String inputString = s.nextLine();

      Map<Character, Boolean> vowelMap = new HashMap<>();
      vowelMap.put('a', false);
      vowelMap.put('e', false);
      vowelMap.put('i', false);
      vowelMap.put('o', false);
      vowelMap.put('u', false);

      int count = 0;
      List<Integer> res = new ArrayList<>();
      char[] characters = inputString.toCharArray();

      for (int i = 0; i < characters.length; i++) {
        if (!vowelMap.containsKey(Character.toLowerCase(characters[i])) && characters[i] != '_') {
          continue;
        }
        if (characters[i] == '_') {
          res.add(count);
          continue;
        }
        if (count < 5 && !vowelMap.get(Character.toLowerCase(characters[i]))) {
          vowelMap.put(characters[i], true);
          count++;
        }

      }
      long result = 1;
      for (int i = 0; i < res.size(); i++) {
        result = result * res.get(i);
      }
      System.out.println(result);
    }
  }

}
/*
You are given a string s consisting of lowercase English letters and/or '_' (underscore).
You have to replace all underscores (if any) with vowels present in the string.

The rule you follow is:
Each underscore can be replaced with any one of the vowel(s) that came before it.

You have to tell the total number of distinct strings we can generate following the above rule.

Input format:
The first line consists of an integer t, denoting the number of test cases.
Each of the next t lines consists of a string s.

Output format:
For each test case, output total number of distinct strings we can generate following the given rule.
Answer for each test case should come in a new line.

Input Constraints:
 1
≤
t
≤
4000
1≤t≤4000
 1
≤
|
s
|
≤
10
5
1≤|s|≤105;
|
s
|
|s| denotes string length.
Sum of
|
s
|
|s| over all test-cases won't exceed
10
5
.
105.
It is guaranteed that there will be atleast one vowel before any '_' (underscore) character in the string.

Note:
It is guaranteed that answer won't go beyond
5
∗
10
18
5∗1018.

Sample Input
2
ab_ae_
abc
Sample Output
2
1
Explanation
Test-case 1: First underscore can be replaced by only one vowel ('a'), while second underscore can be replaced by any one of the two vowels ('a' or 'e').

Distinct strings possible are: 1) abaaea 2) abaaee

So output is 2.

Test-case 2: There are no '_' underscores. So we cannot do any replacement. So given string is the only answer. Output 1.
 */