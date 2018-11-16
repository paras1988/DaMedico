package com.interview.famousProblems.thread;


public class OddEven {

  public static void main(String[] args) {
    Print print = new Print();

    EThread eThread = new EThread(print);
    eThread.start();

    OThread oThread = new OThread(print);
    oThread.start();
  }
}

class Print{

  int i = 1;
  int max = 100;

  public synchronized void printOdd() {
    while (i < max){
      while (i%2 == 0){
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.print(i+" ");
      i++;
      notify();
    }
  }

  public synchronized void printEven() {
    while (i<max){
      while (i%2 != 0){
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.print(i+" ");
      i++;
      notify();
    }
  }
}

class EThread extends Thread{

  private final Print print;

  EThread(Print print){
    this.print = print ;
  }

  @Override
  public void run() {
    print.printEven();
  }
}


class OThread extends Thread{

  private final Print print;

  OThread(Print print){
    this.print = print ;
  }

  @Override
  public void run() {
    print.printOdd();
  }
}
