package com.HackerEarth.Easy;

public class Numberofways {
}


/*
You are given N distinct boxes of marbles in total. There are P boxes each containing A number of marbles and remaining Q boxes contains B number of marbles each. Given a number X, you have to find total the number of ways in which you can pick at least X marbles from the boxes. Print total number of ways modulo 1000000007.

Constraints

1<=N<=1000

P+Q=N

0<=A,B<=1000000

1<=X<=1000

Input Format

Input contains only one line with 6 space-separated integers - N,P,A,Q,B,X.

Output Format

Output should contain only one integer required number of ways modulo 1000000007.

Sample Input
3 2 2 1 1 3
Sample Output
9
Explanation
Note that 2 boxes have capacity of 2 marbles and 3rd box has capacity of 1 marble.

Following are the 9 possible Ways each containing N integers which shows number of marbles picked from each box.

a) 2 2 1 : 5

b) 2 2 0 : 4

c) 2 1 1 : 4

d) 1 2 1 : 4

e) 1 1 1 : 3

f) 2 1 0 : 3

g) 1 2 0 : 3

h) 2 0 1 : 3

i) 0 2 1 : 3
 */