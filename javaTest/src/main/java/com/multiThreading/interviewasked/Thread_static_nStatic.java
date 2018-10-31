package com.multiThreading.interviewasked;

/**
 * Static and non static -> Since they are synchronizing on completely different objects,
 * they are not mutually exclusive. Means will run simultaneously.
 *
 * Both static then - they are mutually exclusive.
 */
public class Thread_static_nStatic {

  public static void main(String[] args) {

    Thread staticCallThread1 = new Thread(SharedObj::print);
    MyThread1 myThread1 = new MyThread1(new SharedObj());
    Thread staticCallThread2 = new Thread(SharedObj::print2Static);

    staticCallThread1.start();
    staticCallThread2.start();
    myThread1.start();
  }
}


class SharedObj{

  synchronized static public void print(){
    while (true) {
      System.out.println(Thread.currentThread().getName() + " Static");
    }
  }

  synchronized static public void print2Static(){
    while (true) {
      System.out.println(Thread.currentThread().getName() + " Static");
    }
  }


  synchronized public void print2(){
    while (true) {
      System.out.println(Thread.currentThread().getName() + " Non Static");
    }
  }
}


class MyThread1 extends Thread{
  SharedObj sharedObj;

  MyThread1(SharedObj sharedObj){
    this.sharedObj = sharedObj;
  }

  @Override
  public void run() {
    sharedObj.print2();
  }
}