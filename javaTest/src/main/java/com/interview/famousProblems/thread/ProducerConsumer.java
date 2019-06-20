package com.interview.famousProblems.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {

  public static void main(String[] args) {
    PrintPC print = new PrintPC();
    Producer producer = new Producer(print);
    Consumer consumer = new Consumer(print);

    producer.start();
    consumer.start();
  }
}

class PrintPC {
  AtomicInteger atomicInteger = new AtomicInteger(10);
  int i = 0;
  synchronized void produce() throws InterruptedException {
    while (i<1000){
      while(atomicInteger.intValue()==33){
        wait();
      }
      System.out.println(i+" "+atomicInteger.getAndIncrement());
      notify();
      i++;
    }
  }

  synchronized void consume() throws InterruptedException {
    while (i<1000){
      while(atomicInteger.intValue()==0){
        wait();
      }
      System.out.println(i+" "+atomicInteger.getAndDecrement());
      notify();
      i++;
    }
  }

}



class Producer extends Thread{

  PrintPC printPC;
  Producer(PrintPC integer){
    this.printPC = integer;
  }

  @Override
  public void run() {
    try {
      printPC.produce();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Consumer extends Thread{

  PrintPC printPC;
  Consumer(PrintPC integer){
    this.printPC = integer;
  }

  @Override
  public void run() {
    try {
      printPC.consume();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}