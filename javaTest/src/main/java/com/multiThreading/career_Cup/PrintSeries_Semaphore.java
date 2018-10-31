package com.multiThreading.career_Cup;

import java.util.concurrent.Semaphore;

public class PrintSeries_Semaphore {
  static String name = "oneTwo";
  static int t = 1, limit = 7;

  static class MyThread extends Thread {
    Semaphore sem;
    String threadName;

    public MyThread(Semaphore sem, String threadName) {
      this.sem = sem;
      this.threadName = threadName;
    }

    public void run() {
      try {
        while (true) {
          synchronized (this){
            if (t == limit)
              break;
            if (threadName.equalsIgnoreCase("one")
              && threadName.equals(name.substring(0, 3))) {
              System.out.print(0);
              name = name.substring(3);

            } else if (threadName.equalsIgnoreCase("two")
              && name.equalsIgnoreCase("two")) {
              System.out.print(t);
              t++;
              name = "oneThree";

            } else if (threadName.equalsIgnoreCase("three")
              && name.equalsIgnoreCase("three")) {
              System.out.print(t);
              t++;
              name = "oneTwo";
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

    }

  }
  public static void main(String[] args) {
    Semaphore sem = new Semaphore(1);
    MyThread one = new MyThread(sem, "one");
    MyThread two = new MyThread(sem, "two");
    MyThread three = new MyThread(sem, "three");
    three.start();
    two.start();

    one.start();
  }}