package com.multiThreading.career_Cup;

import java.util.concurrent.Semaphore;

public class Print_123123123_nThreads {
  static int n = 6;
  volatile int x = 0;
  private static Semaphore semaphore = new Semaphore(1);
  private static Print_123123123_nThreads print_123123123_nThreads = new Print_123123123_nThreads();

  public static void main(String[] args) {
    for(int i=0 ;i < n;i++){
      MyThread myThread = new MyThread(semaphore,i,print_123123123_nThreads);
      myThread.start();
    }
  }
}

class MyThread extends Thread{
  private Semaphore semaphore;
  private final Print_123123123_nThreads obj;

  MyThread(Semaphore semaphore,int i,Print_123123123_nThreads print_123123123_nThreads){
    this.semaphore = semaphore;
    Thread.currentThread().setName(String.valueOf(i));
    this.obj = print_123123123_nThreads;
  }

  @Override
  public void run() {
    try {
      synchronized (obj){
        while (obj.x<26){
          if(Thread.currentThread().getName().contains(String.valueOf(obj.x%Print_123123123_nThreads.n))){
            System.out.println("VAL "+Thread.currentThread().getName()+"--"+obj.x);
            obj.x++;
            obj.notifyAll();
          }
          try {
            obj.wait();
          } catch (Exception e) {
            System.out.println("Exception 2323 "+ obj.x+" "+Thread.currentThread().getName());
            e.printStackTrace();
          }
        }
      }
    }
    catch (Exception e){
      System.out.print("Exception  "+ obj.x+" "+Thread.currentThread().getName());
      e.printStackTrace();
    }

  }
}
