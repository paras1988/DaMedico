package com.HackerEarth.Easy;

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
public class Can_you_count {


}
