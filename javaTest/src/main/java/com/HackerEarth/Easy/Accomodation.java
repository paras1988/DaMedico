package com.HackerEarth.Easy;

import java.util.Scanner;
import java.util.Set;
public class Accomodation {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String[] secondLine = s.nextLine().split("\\s+");
    int n = Integer.parseInt(secondLine[0]);
    int k = Integer.parseInt(secondLine[1]);

    String[] arr1 = s.nextLine().split("\\s+");
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(arr1[i]);
    }
    System.out.print(new Accomodation().getChangesCount(arr, 0, k));
    System.out.print(new Accomodation().getChangesCount2(arr, arr.length - 1, k));
    System.out.print(new Accomodation().getChangesCount3(arr, k));

  }

  //my method
  private int getChangesCount(Integer[] arr, int s, int k) {

    int changes = 0;
    for (int i = s; i < arr.length; i++) {
      if (k - arr[i] == 0) {
        changes += 1;
      } else if (k - arr[i] < 0) {
        break;
      } else {
        changes += getChangesCount(arr, i, k - arr[i]);
      }
    }
    return changes;
  }

  //geeksForGeeks
  private int getChangesCount2(Integer[] arr, int e, int k) {

    if (k == 0) {
      return 1;
    }
    if (k < 0) {
      return 0;
    }
    if (e < 0 && k >= 1) {
      return 0;
    }
    return getChangesCount2(arr, e, k - arr[e]) + getChangesCount2(arr, e - 1, k);
  }

  //dynamic Prog.
  private int getChangesCount3(Integer[] arr, int k) {
    int mat[][] = new int[arr.length + 1][k + 1];

    for (int i = 0; i < arr.length + 1; i++) {
      mat[i][0] = 1;
    }
    for (int i = 0; i <= k; i++) {
      mat[0][i] = 0;
    }

    for (int i = 1; i < arr.length + 1; i++) {
      for (int j = 1; j <= k; j++) {
        mat[i][j] = ((j - arr[i - 1]) < 0 ? 0 : mat[i][j - arr[i - 1]]) + mat[i - 1][j];
      }
    }
    return mat[arr.length][k];
  }
}



/*
 There is a hotel with
 M
 M floors.
 i
 t
 h
 ith floor of the hotel has infinite identical rooms, each room can accommodate
 C
 [
 i
 ]
 C[i] people (Two rooms of same floor are indifferentiable and have same capacity while two rooms of different floors have different capacity).
 There is one rule:
 Any room on
 i
 t
 h
 ith floor will accommodate exactly
 C
 [
 i
 ]
 C[i] people (not less or more).

 Now
 N
 N identical people come for accommodation. You can assign any of them to any room of any floor following the mentioned rule.

 Way of assigning:
 If we have
 5
 5 people and 3 floors. Let's say floor 1 has room capacity 1 and floor 2 has room capacity 2, then:
 (1,2,2) is a way of assigning people. This means we assign one person out of those 5 people to any room of floor 1. The remaining 4 people are assigned to two rooms of floor 2, each room accommodating 2 people.
 We will consider (1,2,2), (2,1,2), (2,2,1) as the same ways as we can't differentiate between them.

 You have to tell number of different ways of accommodating
 N
 N people.
 Two ways are considered different if one way is not a permutation of other way.

 Input Format:
 First line consists of two integers
 M
 M and
 N
 N, denoting number of floors and number of people respectively.
 Second line consists of
 M
 M space separated integers denoting capacity of floors.
 i
 t
 h
 ith integer denotes capacity of
 i
 t
 h
 ith floor.

 Output Format:
 Print the number of different ways of accommodating people.
 Since the number of ways can be large, print the answer modulo
 10
 9
 +
 7
 109+7.

 Input Constraints:
 1
 ≤
 N
 ∗
 M
 ≤
 10
 6
 1≤N∗M≤106
 1
 ≤
 C
 [
 i
 ]
 ≤
 10
 6
 1≤C[i]≤106
 All
 C
 [
 i
 ]
 C[i] are different.

 Sample Input
3 5
1 2 3
 Sample Output
 5

 */

