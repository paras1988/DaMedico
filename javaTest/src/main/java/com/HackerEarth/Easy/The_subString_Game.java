package com.HackerEarth.Easy;

/*
The Substring Game!
Let's play the Substring Game.

This game has two characters: Sherlock and Watson. As usual, Watson wants to test the skills of Mr. Sherlock.

Watson gives Sherlock a string (let's denote it by S). Watson calculates all the substrings of S in his favourite order.

According to the Watson's favourite order, all the substrings starting from first character of the string will occur first in the sorted order of their length, followed by all the substrings starting from the second character of the string in the sorted order of their length, and so on.

For example:
Suppose the given string is "abc" that is S = abc. Then, all the substrings of S as per Watson's favourite order are:

1) a

2) ab

3) abc

4) b

5) bc

6) c

The game is pretty simple.

Watson will ask Sherlock 'q' questions. In each question, Watson will give Sherlock a number and Sherlock has to speak the substring on that number. If there is no possible substring, then Sherlock has to speak -1.

Note: Sherlock has to follow Watson's favourite order.

Help Sherlock.

See Sample test-case for more understanding.


Input format:

First line consist of a string 'S', having only the small alphabets (a - z).

Second Line consist of an integer 'q', number of questions Watson ask.

Next line consists of 'q' space-separated numbers.


Output format:

For all the 'q' questions, output the required answer, in a new line.


Constraints:

1 <= |S| <= 10^5

1 <= q <= 10^3

1 <= number <= 10^18

Sample Input
abc
2
2 9
Sample Output
ab
-1

 */
//import for Scanner and other utility classes

import java.util.*;

public class The_subString_Game {

  public static void main(String args[]) throws Exception {

    //Scanner
    Scanner s = new Scanner(System.in);
    String str = s.nextLine();

    Integer questions = Integer.parseInt(s.nextLine());

    String[] thirdLine = s.nextLine().split("\\s+");

    Long[] arr = new Long[thirdLine.length];
    for (int i = 0; i < thirdLine.length; i++) {
      arr[i] = Long.parseLong(thirdLine[i]);
    }

    Long[] preset = processQuery(str);

    for (int i = 0; i < questions; i++) {
      int index = binarySearchIndexOfLessValue(preset, 0, preset.length - 1, arr[i]);
      System.out.println(index);
    }
  }

  private static int binarySearchIndexOfLessValue(Long[] preset, int s, int l, Long aLong) {
    if (l == s) {
      return s;
    }
    int middle = (l - s + 1) / 2;
    if (preset[middle] > aLong) {
      return binarySearchIndexOfLessValue(preset, s, middle - 1, aLong);
    } else if (preset[middle] > aLong && preset[middle + 1] < aLong) {
      return binarySearchIndexOfLessValue(preset, middle, l, aLong);
    } else {
      return middle;
    }
  }

  private static Long[] processQuery(String str) {
    int size = str.length();
    Integer[] arr = new Integer[size];

    int j = 0;
    while (size >= 1) {

      arr[j] = size--;
      j++;
    }

    Long[] res = new Long[arr.length];
    res[0] = Integer.toUnsignedLong(arr[0]);
    System.out.println(res[0]);

    for (int i = 1; i < arr.length; i++) {
      res[i] = res[i - 1] + Integer.toUnsignedLong(arr[i]);
      System.out.println(res[i]);
    }
    return res;
  }
}
