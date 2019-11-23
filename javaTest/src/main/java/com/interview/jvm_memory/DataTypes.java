package com.interview.jvm_memory;

/**
 * Java maintains Integer pool from -128 to 127
 *
 * byte : 8 bits
 * short : 2 byte
 * int : 4 byte
 * long : 8 byte
 * float : 4 byte
 * double : 8 byte
 *
 * They're the same size on all VMs, on all OSes, on all processors.
 * If they're not, it's not Java anymore.
 */

public class DataTypes {

  public static void main(String[] args) {
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MAX_VALUE);
  }
}
