package com.interview.multiThreading.evenOdd;

/**
 * Perfect one at end.
 * First run by uncomment below. understand issue.
 * Then think how current is working
 */
class Print3{

  public static void main(String[] args) {


    PrintOddEven oep = new PrintOddEven();
    Thread t1 = new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          oep.printEven();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    });
    Thread t2 = new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          oep.printOdd();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    });

    t1.start();
    t2.start();
  }
}
class PrintOddEven{

  boolean isOdd = true;
  volatile int i=1;
  int max = 10;

  synchronized void printEven() throws InterruptedException {
    while (i<max){
      if(isOdd){
        wait();
      }
      System.out.println("Even"+i); // Printing and doing
                                    // isOdd true so that it will wait next
      i++;
      isOdd = true;
      this.notify();
    }
  }

  synchronized void printOdd() throws InterruptedException {
    while (i<max){
      if(!isOdd){
        wait();
      }
      System.out.println("Odd"+i);
      i++;
      isOdd = false;
      this.notify();
    }
  }
}
/*
class PrintOddEven{

  volatile int i=1;
  int max = 10;

  synchronized void printEven() throws InterruptedException {
    System.out.println("00000");
    while (i<max){
      System.out.println("11111");
      if(i%2==0){
        System.out.println("Even"+i);
        i++;
        this.wait();
      }
      System.out.println("2222");
      this.notify();
      System.out.println("33333");
    }
  }

  synchronized void printOdd() throws InterruptedException {
    System.out.println("4444");
    while (i<max){
      System.out.println("55555");
      if(i%2!=0){
        System.out.println("Odd"+i);
        i++;
        this.wait();
      }
      System.out.println("6666");
      this.notify();
      System.out.println("77777");
    }
  }
}
*/
