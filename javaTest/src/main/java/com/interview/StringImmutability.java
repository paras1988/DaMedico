package com.interview;

/**
 * Java maintains Integer pool from -128 to 127
 */
public class StringImmutability {

  public static void main(String[] args) {
    String s1 = "Paras";
    String s2 = "Paras";
    String s3 = new String("Paras");

    System.out.println(s1 == s2); //true
    System.out.println(s1 == s3); //false


    Integer i1 = 10;
    Integer i2 = 10;

    System.out.println(i1 == i2); //true

    i1 = 200;
    i2 = 200;

    System.out.println(i1 == i2); //false
  }
}
