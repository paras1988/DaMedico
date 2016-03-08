package com.Threads;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConnectionPooling<E> {

	Map<String,E> objectPool=null;
	Stack<String> unusedObjects=null;

	public ConnectionPooling() {
		objectPool=new HashMap<String,E>();
		unusedObjects=new Stack<String>();
	}

	public E borrow(){
		E obj=null;
		synchronized (this) {
			if(unusedObjects.isEmpty()){
				try {
					System.out.println("Waiting for an Object to be released...");
					this.wait();
				} catch (InterruptedException e) {
				}

			}else{
				try{
					String key=unusedObjects.pop();
					obj= objectPool.get(key);
				}
				catch(EmptyStackException e){

				}
			}
		}
		return obj;
	}

	public void returnObject(E obj) {
		synchronized (this) {
			if(isValid(obj)){
				if(unusedObjects.isEmpty()){
					unusedObjects.add(obj.toString());
					this.notifyAll();
				}
			}
			else{
				System.out.println("Please return valid object");
			}
		}
	}

	private boolean isValid(E obj) {
		synchronized(this){
			return objectPool.containsKey(obj.toString());
		}
	}

	public void destroyPool(){
		objectPool = null;
		unusedObjects = null;
	}

	public void initializePool(E obj){
		objectPool.put(obj.toString(), obj);
		unusedObjects.add(obj.toString());
	}
}
