package com.interview.famousProblems.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {

  public static void main(String[] args) {
    AtomicInteger atomicInteger = new AtomicInteger(10);
    Producer producer = new Producer(atomicInteger);
    Consumer consumer = new Consumer(atomicInteger);

    producer.start();
    consumer.start();
  }
}


class Producer extends Thread{

  AtomicInteger atomicInteger;
  Producer(AtomicInteger integer){
    this.atomicInteger = integer;
  }

  @Override
  public void run() {

  }
}

class Consumer extends Thread{

  AtomicInteger atomicInteger;
  Consumer(AtomicInteger integer){
    this.atomicInteger = integer;
  }

  @Override
  public void run() {

  }
}