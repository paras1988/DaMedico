package com.Algo.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

	int V;
	final LinkedList<Integer> a[];
	 boolean visited[]; 
	
	BFS(int v){
		V=v;
		a=new LinkedList[v];
		for(int i=0;i<v;i++){
			a[i]=new LinkedList<Integer>();
		}
		visited= new boolean[V];
	}
	
	void addEdge(int v,int w){
		a[v].add(w);
	}
	
	void BFSTraversal(int s){
		LinkedList<Integer> queue=new LinkedList<Integer>();
		// Mark all the vertices as not visited(By default
        // set as false)
       
        visited[s]=true;
        System.out.println(s);
        queue.add(s);
        
        while(!queue.isEmpty()){
        		s=queue.poll();
        		
        		for(int i:a[s]){
        			if(!visited[i]){
        				queue.add(i);
        				System.out.println(i);
                		visited[i]=true;
        			}
        		}
        }
        int count=0;
        //for disconnected graph
        for(LinkedList<Integer> l:a){
        	if(l.size()>0 && visited[count]==false){
        		BFSTraversal(count);
        	}
        	count++;
        }
	}
	
	public static void main(String[] args) {
		BFS b=new BFS(10);
		b.addEdge(1, 2);
		b.addEdge(1, 3);

		b.addEdge(2, 7);
		b.addEdge(2, 1);
		b.addEdge(3, 6);
		b.addEdge(4, 6);
		b.addEdge(1, 5);
		b.BFSTraversal(1);
	}
}
