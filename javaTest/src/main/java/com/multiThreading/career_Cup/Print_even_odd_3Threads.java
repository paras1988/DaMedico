package com.multiThreading.career_Cup;

public class Print_even_odd_3Threads {

    public static void main(String[] args) {
        Print print = new Print();
        MyThread t1 = new MyThread(print,0);
        MyThread t2 = new MyThread(print,1);
        MyThread t3 = new MyThread(print,2);
        t1.start();
        t2.start();
        t3.start();
    }

    static class MyThread extends Thread{

        Print print;
        int threadNumber;
        public MyThread(Print print,int i) {
            this.print = print;
            this.threadNumber = i;
        }

        @Override
        public void run() {
            try {
                print.print(threadNumber);
            }catch (Exception e){

            }
        }
    }

    static class Print{
        int max = 100;
        volatile int i = 0;

        synchronized void print(int c) throws InterruptedException {
            while (i<max){
                while(i%3!=c){          //remove this while to c spurious wakeups
                    wait();
                }
                System.out.println(c+" "+i);
                i++;
                notifyAll();
            }
        }
    }
}
