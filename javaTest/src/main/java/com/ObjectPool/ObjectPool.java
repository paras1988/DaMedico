package com.ObjectPool;

interface ObjectPool<T> {
  T borrowObject();
  T tryBorrowObject(long timeout);
  void releaseObject(T object);
  void shutdown();
}
