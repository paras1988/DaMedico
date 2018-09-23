package com.interview.multiThreading.Cookbook_Practice;

/**
 * Java provides the interruption mechanism to indicate thread to finish.
 * Thread can ignore it (else catch exception ) and continue with its execution.
 *
 * we will develop a program that creates Thread and, after 5 seconds, will force
 * its finalization using the interruption mechanism.
 *
 */
public class ThreadInterrupt {

  public static void main(String[] args) {
    Thread primeNumberGenerator = new Thread(new Runnable() {
      @Override
      public void run() {
        long number=1L;
        while (true) {
          if (isPrime(number)) {
            System.out.println("Number is Prime ->"+ number);
          }
          if(Thread.currentThread().isInterrupted()){
            System.out.println("Thread got interrupted");
            return;
          }
          number++;
        }
      }

      private boolean isPrime(long number) {
        if (number <=2) {
          return true;
        }
        for (long i=2; i<number; i++){
          if ((number % i)==0) {
            return false;
          }
        }
        return true;
      }
    });

    primeNumberGenerator.start();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    primeNumberGenerator.interrupt();
  }
}
