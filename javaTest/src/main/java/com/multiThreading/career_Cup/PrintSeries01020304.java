package com.multiThreading.career_Cup;


/**
 * goldman-sachs-interview-questions
 *
 * Print series 010203040506. Using multi-threading 1st thread will
 * print only 0 2nd thread will print only even numbers and 3rd thread print only odd numbers.
 */
public class PrintSeries01020304 {
  public static void main(String[] args) throws InterruptedException {
    PrintNum printNum =  new PrintNum();

    Thread odd = new Odd(printNum);
    odd.start();

    Thread even = new Even(printNum);
    even.start();

    Thread zero = new Zero(printNum);
    zero.start();
  }
}

class PrintNum{
  private  int i = 1;
  private int max = 20;
  private Boolean stateZero = true;
  private Boolean stateOdd = false;
  private Boolean stateEven = false;

  synchronized void printZero() throws InterruptedException {
    while (i<max){
      if (stateZero){
        System.out.println(0);
        stateZero = false;
        if(i % 2 == 0){
          stateEven = true;
        }
        else {
          stateOdd = true;
        }
        notifyAll();
      }
      wait();
      i++;
    }
  }

  synchronized void printOdd() throws InterruptedException {
    while (i<max){
      if(stateOdd){
        System.out.println(i);
        stateZero = true;
        stateOdd = false;
        notifyAll();
      }
      wait();
    }
  }

  synchronized void printEven() throws InterruptedException {
    while (i<max){
      if(stateEven){
        System.out.println(i);
        stateZero = true;
        stateEven = false;
        notifyAll();
      }
      wait();
    }
  }
}

class Zero extends Thread{
  private final PrintNum printNum;
  Zero(PrintNum printNum){
    this.printNum = printNum;
  }

  @Override
  public void run() {
    try {
      printNum.printZero();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}


class Odd  extends Thread{
  private final PrintNum printNum;
  Odd(PrintNum printNum){
    this.printNum = printNum;
  }

  @Override
  public void run() {
    try {
      printNum.printOdd();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}


class Even  extends Thread{
  private final PrintNum printNum;
  Even(PrintNum printNum){
    this.printNum = printNum;
  }

  @Override
  public void run() {
    try {
      printNum.printEven();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
