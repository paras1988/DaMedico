package com.HackerEarth.Easy;

/*
Bob And GCD
Bob has an array
A
A of size
N
N. He doesn't like arrays in which the
G
C
D
GCD of all elements is not
K
K. He can perform multiple operations on an array. In each operation, he can either increase or decrease the value of an element by
1
1.
You have to tell the minimum operation Bob will take to make
G
C
D
GCD of all elements in an array equal to
K
K ?

GCD here is Greatest Common Divisor.

Input Format

The first line contains
T
T, the number of test cases.

For Each Testcase :
The first line contains 2 integers -
K
K and
N
N respectively, separated by a space.
The second line contains
N
N integers, separated by a space, in order of their position in array.

Input Constraints

1
≤
T
≤
10
1≤T≤10
 1
≤
N
≤
10
6
1≤N≤106
 1
≤
A
[
i
]
≤
10
6
1≤A[i]≤106
 1
≤
K
≤
10
6
1≤K≤106
Output Format

For each test case, print minimum number of operations Bob take in a new line.

Sample Input
1
5 3
4 5 6
Sample Output
2

 */
/* IMPORTANT: Multiple classes and nested static classes are supported */


//import for Scanner and other utility classes

import java.util.*;

public class Bob_and_GCD {

  static int operations = 0;

  public static void main(String args[]) throws Exception {

    //Scanner
    Scanner s = new Scanner(System.in);
    Integer testcases = Integer.parseInt(s.nextLine());                 // Reading input from STDIN

    for (int kk = 1; kk <= testcases; kk++) {
      operations = 0;
      String[] secondLine = s.nextLine().split("\\s+");
      int k = Integer.parseInt(secondLine[0]);
      int n = Integer.parseInt(secondLine[1]);

      String[] arr1 = s.nextLine().split("\\s+");
      Integer[] arr = new Integer[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(arr1[i]);
      }
      for (int i = 0; i < n; i++) {

        if (gcd(k, arr[i]) == k) {
          continue;
        }

        for (int j = 1; j < k; j++) {

          if (arr[i] - j > 0 && gcd(k, arr[i] - j) == k) {
            operations = operations + j;
            break;
          }

          if (gcd(k, arr[i] + j) == k) {
            operations = operations + j;
            break;
          }
        }
      }
      System.out.println(operations);
    }

  }

  static int gcd(int a, int b) {
    // Everything divides 0
    if (a == 0 || b == 0)
      return 0;

    // base case
    if (a == b)
      return a;

    // a is greater
    if (a > b)
      return gcd(a - b, b);
    return gcd(a, b - a);
  }
}
