package com.multiThreading.evenOdd;

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

/*class PrintOddEven{

  volatile int i=1;
  int max = 10;

  synchronized void printEven() throws InterruptedException {
    while (i<max){
      if(i%2==0){
        System.out.println("Even "+i);
        i++;
        this.wait();
      }
      this.notify();
    }
  }

  synchronized void printOdd() throws InterruptedException {
    while (i<max){
      if(i%2!=0){
        System.out.println("Odd "+i);
        i++;
        this.wait();
      }
      this.notify();
    }
  }
}*/

