package com.multiThreading.codeSample;

/**
 * run to see deadlock
 * remove commented code of wait and notify to see its cure
 */
public class Deadlock {
  static Object object1 = new Object();
  static Object object2 = new Object();


  public static void main(String[] args) {

    Thread thread1 = new Thread(){
      @Override
      public void run() {
        synchronized (object1){
          try {
              System.out.print("object1 thread1");
            sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          try {
            object1.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized (object2){
            System.out.print("object2 thread1");
          }
        }
      }
    };


    Thread thread2 = new Thread(){
      @Override
      public void run() {
        synchronized (object2){
          try {
              System.out.print("object2 thread2");
            sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized (object1){
            System.out.print("object1 thread2");
            object1.notify();
          }
        }
      }
    };

    thread1.start();
    thread2.start();
  }
}
