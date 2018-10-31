package com.multiThreading.interviewasked;

/**
 * If one thread throw OOM exception then GC occurs and stops other threads for a while
 * so other threads will start working.
 *
 */
public class Threading_outOfMemory {

  public static void main(String[] args) {

    Thread thread1 = new Thread(() -> {
      generateOOM(1000);
    });

    Thread thread2 = new Thread(() -> {
      generateOOM(10000);
    });

    Thread thread3 = new Thread(() -> {
      generateOOM(100000);
    });

    Thread thread4 = new Thread(() -> {
      generateOOM(100000);
    });

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }
  public static void generateOOM(int sleep) {
    int iteratorValue = 20;
    System.out.println(Thread.currentThread().getName() + "\n=================> OOM test started..\n");
    for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
      System.out.println(Thread.currentThread().getName() + "Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory());
      int loop1 = 2;
      int[] memoryFillIntVar = new int[iteratorValue];
      // feel memoryFillIntVar array in loop..
      do {
        memoryFillIntVar[loop1] = 0;
        loop1--;
      } while (loop1 > 0);
      iteratorValue = iteratorValue * 5;
      System.out.println(Thread.currentThread().getName() + "\nRequired Memory for next loop: " + iteratorValue);
      try {
        Thread.sleep(sleep/10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
