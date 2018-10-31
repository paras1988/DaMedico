package com.multiThreading.Cookbook_Practice;


/**
 * 2 ways of creating a thread in Java:
 *  1. Extending the Thread class and overriding the run() method
 *  2. Building a class that implements the Runnable interface and then creating
 * an object of the Thread class passing the Runnable object as a parameter
 * In this recipe, we will use the second approach to create a simple program that creates
 * and runs 10 threads. Each thread calculates and prints the multiplication table of a number
 * between one and 10.
 */
public class ThreadCreation_Running {

  public static void main(String[] args) {
    for(int i=1;i<=10;i++){
      Calculates calculates = new Calculates(i);
      new Thread(calculates).start();
    }
  }
}

class Calculates implements Runnable{

  private int i;
  Calculates(int i){
    this.i = i;
  }

  @Override
  public void run() {
    for(int j=0;j<10;j++){
      System.out.println(Thread.currentThread().getName()+">> "+i+" "+j+"->"+i*j);
    }
  }
}

class CalculateThreadExtend extends Thread{

  @Override
  public void run() {
    super.run();
  }
}