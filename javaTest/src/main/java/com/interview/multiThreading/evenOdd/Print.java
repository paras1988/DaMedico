package com.interview.multiThreading.evenOdd;

class Print{
  private int num = 200;

  synchronized void printOdd() throws InterruptedException {
    for(int i=1;i<num;i++){
      if(i%2!=0){
        System.out.println("odd "+i);
        wait();
      }
      if(i%2==0){
        notify();
      }
    }
  }

  synchronized void printEven() throws InterruptedException {
    Thread.sleep(100);
    for(int i=1;i<num;i++){
      if(i%2==0){
        System.out.println("even "+i);
        wait();
      }
      if(i%2!=0){
        notify();
      }
    }
  }

  public static void main(String[] args){
      Print print1 = new Print();
      A a = new A(print1);
      B b = new B(print1);

      a.start();
      b.start();
  }


}

class A extends Thread{

  Print print;
  A(Print print1){
    print = print1;
  }

  @Override
  public void run() {
    try {
      print.printOdd();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class B extends Thread{

  Print print;
  B(Print print1){
    print = print1;
  }


  @Override
  public void run() {
    try {
      print.printEven();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}