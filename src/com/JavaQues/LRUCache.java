package com.JavaQues;


/*http://stackoverflow.com/questions/23772102/lru-cache-in-java-with-generics-and-o1-operations
 * http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 */
import java.util.Map;


public class LRUCache<K,V> {

	Map<K,Node<K,V>> cache;
	Node<K,V> mostRecentNode;
	Node<K,V> leastRecentNode;
	int capacity;
	int currentSize;

	class Node<K,V>{
		public Node(K key, V value) {
			this.key=key;
			this.value=value;
		}
		K key;
		V value;
		Node<K,V> next;
		Node<K,V> prev;
	}

	public V get(K key){
		if(cache.containsKey(key)){
			Node<K,V> node=cache.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return null;
	}


	public V put(K key,V value){
		Node<K,V> oldVal=null;
		if(cache.containsKey(key)){
			oldVal=cache.get(key);
			remove(oldVal);
		}else if(currentSize==capacity){
			remove(leastRecentNode);
		}
		Node<K,V> newNode=new Node<K, V>(key, value);
		cache.put(key, newNode);
		setHead(newNode);
		return oldVal.value;
	}

	private void remove(Node<K, V> node) {

	}

	private void setHead(Node<K, V> node) {

	}
}
