package com.interview.multiThreading.Cookbook_Practice;

/**
 * Print the tables sequentially
 */
public class ThreadJoin {
  public static void main(String[] args) {

    for(int i=1;i<6;i++){
      NumTable numTable = new NumTable(i);
      Thread thread = new Thread(numTable);
      thread.start();
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("-------------------");

    //start before and join after
    NumTable numTable1 = new NumTable(11);
    Thread thread1 = new Thread(numTable1);
    thread1.start();

    NumTable numTable2 = new NumTable(12);
    Thread thread2 = new Thread(numTable2);
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class NumTable implements Runnable{

  int num;

  NumTable(int num){
    this.num = num;
  }

  @Override
  public void run() {
    for(int i=1;i<=10;i++){
      System.out.println(num*i);
    }
  }
}

