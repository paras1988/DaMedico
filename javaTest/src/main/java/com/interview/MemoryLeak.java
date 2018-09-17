package com.interview;

import java.util.ArrayList;
import java.util.Random;

/**
 * https://stackify.com/memory-leaks-java/
 *
 * E.g In stack when u pop u forget to remove top element u just update
 * pointer
 */

public class MemoryLeak {

  private Random random = new Random();
  public static final ArrayList<Double> list = new ArrayList<Double>(1000000);

  private void givenStaticField_whenLotsOfOperations_thenMemoryLeak() throws InterruptedException {
    for (int i = 0; i < 1000000; i++) {
      list.add(random.nextDouble());
    }

    System.gc();
    Thread.sleep(10000); // to allow GC do its job
  }
  public static void main(String[] args) {
    try {
      new MemoryLeak().givenStaticField_whenLotsOfOperations_thenMemoryLeak();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
