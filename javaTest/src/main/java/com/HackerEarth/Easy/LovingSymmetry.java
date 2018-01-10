package com.HackerEarth.Easy;

public class LovingSymmetry {

  public static void main(String[] args) {
    String str = "df";
    str = str + '2';

    System.out.println(str);
  }
}


/*
You want to make a Special binary number of length
N
N, by repeating an another binary number of
K
K size in length.

Special binary number of size
N
N should have following properties:

1) It should be a palindrome.
2) It should contain at least one
0
0 and one
1
1.
3) It should not contain preceding zeros.

There is no restriction on
K
K size binary number.

If the size of the special binary number on repetitively concatenating the
K
K size binary number becomes greater than
N
N, then you need to trim it to first
N
N characters.

Note:
1) Binary number contains only 1 and 0.
2) Palindrome is a sequence that reads the same backwards as forwards .

Input

First line of the input contains the number of test cases
T
T. It is followed by
T
T lines. Each line contains two integers
N
N and
K
K.

Output

For each test case, output a special binary number of length
N
N in an new line. If you think there can exist more than one such special numbers, print the one which contains largest number of zeros. If no such number is possible, print "impossible" without the quotation marks.

Constraints

1<=T<=10

1<=N,K<=10^5

Sample Input
5
16 8
8 2
9 5
20 9
2 1
Sample Output
1000000110000001
impossible
100101001
11000000011000000011
impossible
 */