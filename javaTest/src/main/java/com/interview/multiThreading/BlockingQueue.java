package com.interview.multiThreading;

import java.util.LinkedList;
import java.util.List;

class BlockingQueueTest{

  public static void main(String[] args) {
    BlockingQueue blockingQueue = new BlockingQueue(10);
    //new Producer(blockingQueue).start();  class Producer implements Runnable. It calls put
    //new Consumer(blockingQueue).start();  same as above.It calls get
  }
}

class BlockingQueue<T> {

  private List<T> queue = new LinkedList<T>();
  int size;

  BlockingQueue(int size){
    this.size = size;
  }

  synchronized T get(){
    if(queue.isEmpty()){
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    T item2 = queue.remove(0);
    this.notify();
    return item2;
  }

  synchronized void put(T item){
    if(queue.size()==this.size){
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    queue.add(item);
    notify();
  }
}
