package com.multiThreading.Cookbook_Practice;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 *  If normal threads are not running and
 *  remaining threads are daemon threads then the interpreter exits.
 *
 * low
 * priority and normally only executes when no other thread of the same program is running.
 *  A typical example of these kind of
 * threads is the Java garbage collector.
 *
 * They usually have an infinite
 * loop that waits for the service request or performs the tasks of the thread.
 *
 * an example with two
 * threads; one user thread that writes events on a queue and a daemon one that cleans that
 * queue, removing the events which were generated more than 10 seconds ago.
 *
 */
public class DaemonThread {
  public static void main(String[] args) {
    Deque<Event> deque=new ArrayDeque<Event>();
    WriterTask writer=new WriterTask(deque);
    for (int i=0; i<3; i++){
      Thread thread=new Thread(writer);
      thread.start();
    }
    CleanerTask cleaner=new CleanerTask(deque);
    cleaner.start();
  }
}

class WriterTask implements Runnable{

  Deque<Event> deque;

  WriterTask(Deque<Event> deque){
    this.deque = deque;
  }

  @Override
  public void run() {
    for (int i=1; i<100; i++) {
      Event event=new Event();
      event.setDate(new Date());
      event.setEvent(String.format("The thread %s has generated an event",
        Thread.currentThread().getId()));
        deque.addFirst(event);
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}



class CleanerTask extends Thread{

  Deque<Event> deque;

  CleanerTask(Deque<Event> deque){
    this.deque = deque;
    setDaemon(true);   //This is setting daemon to true
  }

  @Override
  public void run() {
    while (true) {
      Date date = new Date();
      clean(date);
    }
  }

  //It gets the last event and, if it was created more
  //than 10 seconds ago, it deletes it and checks the next event
  private void clean(Date date) {
    long difference;
    boolean delete;
    if (deque.size()==0) {
      return;
    }
    delete=false;
    do {
      Event e = deque.getLast();
      difference = date.getTime() - e.getDate().getTime();
      if (difference > 10000) {
        System.out.printf("Cleaner: %s\n",e.getEvent());
        deque.removeLast();
        delete=true;
      }
    } while (difference > 10000);
    if (delete){
      System.out.printf("Cleaner: Size of the queue: %d\n",deque.
        size());
    }
  }
}


class Event{
  Date date;
  String event;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }
}