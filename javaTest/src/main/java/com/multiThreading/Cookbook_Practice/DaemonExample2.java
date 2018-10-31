package com.multiThreading.Cookbook_Practice;

import static java.lang.Thread.sleep;

/**
 * See how daemon thread will do the task until main is sleeping
 * Once main wakes up daemon will also exit
 *
 * If its not daemon its keeps running.
 *
 */
public class DaemonExample2 {
  public static void main(String[] args) {

    DaemonThread2 thread2 = new DaemonThread2();
    thread2.start();

    try {
      sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class DaemonThread2 extends Thread{

  DaemonThread2(){
    setDaemon(true);
  }

  @Override
  public void run() {
    while (true){
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Daemon running");
    }
  }
}
