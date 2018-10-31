package com.ObjectPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class ObjectPoolService<T> implements ObjectPool<T> {

  private final int minIdle;
  private final int maxIdle;
  private int size;
  private boolean shutdown = false;

  private LinkedBlockingQueue<T> objectpool;

  public ObjectPoolService(final int minIdle, final int maxIdle) {
    this.minIdle = minIdle;
    this.maxIdle = maxIdle;
    initialize(minIdle, maxIdle);
  }

  public int minIdle() {
    if (shutdown) {
      return 0;
    }
    return minIdle;
  }

  public int maxIdle() {
    if (shutdown) {
      return 0;
    }
    return maxIdle;
  }

  public long expiryInterval() {
    return 0;
  }

  public int created() {
    return size;
  }

  public int borrowed() {
    return size - objectpool.size();
  }

  public int availableActive() {
    return objectpool.size();
  }

  public int availablePassive() {
    return maxIdle() - created();
  }

  public int availableTotal() {
    return maxIdle() - borrowed();
  }

  public T borrowObject() {
    if (shutdown) {
      return null;
    }
    populatePool();
    return objectpool.poll();
  }

  public T tryBorrowObject(long timeout) {
    T object = null;
    if(shutdown){
      return null;
    }
    populatePool();
    try {
      object = objectpool.poll(timeout, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return object;
  }

  public void releaseObject(T object) {
    objectpool.add(object);
    if (shutdown && availableActive() == created()) {
      objectpool.clear();
      cleanUp();
    }
  }

  public void shutdown() {

    shutdown = true;
  }

  protected abstract T createObject();

  public void initialize(final int minIdle, final int maxIdle) {

    objectpool = new LinkedBlockingQueue<>(maxIdle);

    for (int i = 0; i < minIdle; i++) {
      objectpool.add(createObject());
    }

    size = minIdle;
  }

  private void populatePool() {
    while (availableActive() < minIdle() && created() < maxIdle()) {
      objectpool.add(createObject());
      size++;
    }
  }

  private void cleanUp() {
    size = 0;
  }
}
