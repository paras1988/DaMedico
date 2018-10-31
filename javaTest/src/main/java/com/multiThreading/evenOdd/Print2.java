package com.multiThreading.evenOdd;

/**
 * This code has error .. identify it
 * https://stackoverflow.com/questions/16689449/printing-even-and-odd-using-two-threads-in-java
 */
class ViaLock extends Thread{

  volatile static int i=1;
  final Object mutex;

  ViaLock(Object mutex){
    this.mutex = mutex;
  }

  public static void main(String[] args) {
    Object obj = new Object();
    ViaLock odd = new ViaLock(obj);
    ViaLock even = new ViaLock(obj);
    odd.setName("Odd");
    even.setName("Even");

    odd.start();
    even.start();
  }

  @Override
  public void run() {
    while (i< 10){
      if(i%2 != 0){
        synchronized (mutex){
          System.out.println("Odd "+ i);
          i++;
          try {
            mutex.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
      if(i%2 == 0){
        synchronized (mutex){
          System.out.println("Even "+ i);
          i++;
          mutex.notify();
        }
      }
    }
  }
}



