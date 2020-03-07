package com.multiThreading.career_Cup;

/**
 * Output: A B C A B C A B C A B C A B C .....
 */
public class Print_ABC {

  int state = 1;
  int max = 20;
  int i = 1;

  public static void main(String[] args) {
    Print_ABC print_abc = new Print_ABC();
  /*  Thread A = new A(print_abc);
    Thread B = new B(print_abc);
    Thread C = new C(print_abc);
    A.start();
    B.start();
    C.start();*/
  }

  void dfd(Print_ABC print_abc, int i, String str, int nextstate) {
    synchronized (print_abc){
      while (print_abc.i<print_abc.max){
        if(print_abc.state == i){
          System.out.print(str);
          print_abc.i++;
          print_abc.state = nextstate;
          notifyAll();
        }
        try {
          wait();
        }
        catch (InterruptedException e) { }
      }
  }
}

class A extends Thread{
  private final Print_ABC print_abc;

  A(Print_ABC print_abc){
    this.print_abc = print_abc;
  }

  @Override
  public void run() {
    print_abc.dfd(print_abc,1,"A", 2);
  }
}

class B extends Thread{

  private final Print_ABC print_abc;

  B(Print_ABC print_abc){
    this.print_abc = print_abc;
  }
  @Override
  public void run() {
    print_abc.dfd(print_abc,2,"B", 3);
  }
}

class C extends Thread{
  private final Print_ABC print_abc;

  C(Print_ABC print_abc){
    this.print_abc = print_abc;
  }
  @Override
  public void run() {
    print_abc.dfd(print_abc,3,"C", 1);
  }
}
}
