package com.interview.multiThreading;

/**
 * https://howtodoinjava.com/design-patterns/creational/singleton-design-pattern-in-java/
 */
class Singleton1 {

  private static Singleton1 singleton1 = null;

  private Singleton1(){}

  Singleton1 getInstance(){
    if(singleton1 == null){
      singleton1 = new Singleton1();
    }
    return singleton1;
  }
}


class Singleton2 {

  private static Singleton2 singleton1 = null;

  private Singleton2(){}

  synchronized Singleton2 getInstance(){
    if(singleton1 == null){
      singleton1 = new Singleton2();
    }
    return singleton1;
  }
}


class Singleton3 {

  private static Singleton3 singleton1 = null;

  private Singleton3(){}

  Singleton3 getInstance(){
    if(singleton1 == null){
      synchronized (Singleton3.class){
        singleton1 = new Singleton3();
      }
    }
    return singleton1;
  }
}

class Singleton4 {

  private static Singleton4 singleton = null;

  private Singleton4(){}

  Singleton4 getInstance(){
    if(singleton == null){
      synchronized (Singleton4.class){
        if(singleton == null){
          singleton = new Singleton4();
        }
      }
    }
    return singleton;
  }
}

class Singleton5 {

  private static Singleton5 singleton = null;
  private final Object mutex = new Object();

  private Singleton5(){}

  Singleton5 getInstance(){
    if(singleton == null){
      synchronized (mutex){
        if(singleton == null){
          singleton = new Singleton5();
        }
      }
    }
    return singleton;
  }
}


class Singleton6 {

  private static Singleton6 singleton = null;
  private final Object mutex = new Object();

  private Singleton6(){}

  Singleton6 getInstance(){
    if(singleton == null){
      synchronized (mutex){
        if(singleton == null){
          singleton = new Singleton6(); //Out of order problem.
        }
      }
    }
    return singleton;
  }
}

/**
 * double-checked locking will not be supported by the new
 * memory model. Therefore, you have two options:
 *
 *  • Accept the synchronization of a getInstance() method as shown in Listing 2.
 *  • Forgo synchronization and use a static field.
 */

//Early..
class StaticSingleton6 {

  private static StaticSingleton6 singleton = new StaticSingleton6();

  private StaticSingleton6(){}

  StaticSingleton6 getInstance(){
    return singleton;
  }
}


//Also for serialization and reflection Use Enums

  /**
   * Let’s say your application is distributed and it frequently
   * serializes objects into the file system, only to read them later when required.
   * de-serialization always creates a new instance.
   *
   * object1 Serialize to file
   * Do some changes to object1
   * deserialize to object - object2.
   *
   * Objec1 and object2 are different
   *
   * Add readResolve() and return instance. to Singleton Objects
   *  protected Object readResolve() {
   *         return instance;
   *     }
   */



  //out-of-order write problem - half baked object when using double checked locking
