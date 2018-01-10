package com.HackerEarth.Easy;

import java.util.Scanner;

public class OddCounts {

  public static void main(String args[]) throws Exception {

    //Scanner
    Scanner s = new Scanner(System.in);
    String str = s.nextLine();
    int lenght = str.length();
    long res = 0;

    for (char ch : str.toCharArray()) {
      if (ch == '1') {
        res += lenght;

      }
      lenght--;
    }
    System.out.println(res);

  }
}
