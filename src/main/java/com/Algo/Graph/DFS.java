package com.Algo.Graph;

import java.util.LinkedList;

public class DFS {
	
	int V;
	final LinkedList<Integer> a[];
	 boolean visited[]; 
	
	DFS(int v){
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
	
	void DFSTraversal(int s){
		
		visited[s]=true;
		System.out.println(s);
		for(int i:a[s]){
			if(visited[i]==false){
				visited[i]=true;
				DFSTraversal(i);
			}
		}
	}
	
	public static void main(String[] args) {
		DFS b=new DFS(10);
		b.addEdge(1, 2);
		b.addEdge(1, 3);
		b.addEdge(2, 7);
		b.addEdge(2, 1);
		b.addEdge(3, 6);
		b.addEdge(4, 6);
		b.addEdge(1, 5);
		b.DFSTraversal(1);
	}
}
