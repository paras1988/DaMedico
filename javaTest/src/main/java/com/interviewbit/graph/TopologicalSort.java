package com.interviewbit.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


public class TopologicalSort {

    public static void main (String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());

            String s[] = read.readLine().trim().split("\\s+");
            int p = 0;
            for(int i = 1; i <= edg; i++)
            {    int u = Integer.parseInt(s[p++]);
                int v = Integer.parseInt(s[p++]);
                list.get(u).add(v);

            }


            int res[] = new int[10001];
            res = new TopologicalSort().topoSort(list, nov);
            boolean valid = true;

            for(int i = 0; i < nov; i++)
            {
                int n = list.get(res[i]).size();
                for(int j = 0; j < list.get(res[i]).size(); j++)
                {
                    for(int k = i+1; k < nov; k++)
                    {
                        if(res[k]==list.get(res[i]).get(j))
                            n--;
                    }
                }
                if(n!=0)
                {
                    valid = false;
                    break;
                }
            }
            if(valid == true)
                System.out.println("0");
            else
                System.out.println("1");
        }
    }

    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
    {
        boolean[] visited = new boolean[N];
        LinkedList<Integer> res = new LinkedList<Integer>();

        for(int i=0;i<list.size();i++){
            if(visited[i]){
                continue;
            }
            topSortUtil(list, res, visited, i);
        }
        int[] arr = new int[N];
        for(int x=0;x<res.size();x++){
            arr[x] = res.get(x);
        }
        return arr;
    }

    private static void topSortUtil(ArrayList<ArrayList<Integer>> list, LinkedList<Integer> res, boolean[] visited, int i) {

        visited[i] = true;

        for(int a: list.get(i)){
            if(visited[a]){
                continue;
            }
            topSortUtil(list,res,visited,a);
        }

        res.add(i);
    }


}

/**
 * Given a directed graph, you need to complete the function topoSort which returns an array having the topologically
 * sorted elements of the array and takes two arguments.
 * The first argument is the Graph graph represented as adjacency list and the second is the number of vertices N.
 *
 * Note : There can be multiple topological sorts of a Graph.  The driver program that calls your function doesn't
 * match your output element by element,
 * but checks whether the output produced by your function is a valid topological sort or not.
 *
 * Input:
 * The first line of input takes the number of test cases then T test cases follow . Each test case contains two lines. The first  line of each test case  contains two integers E and N representing no of edges and the number of vertices. Then in the next line are E  pairs of integers u, v representing an edge from u to v in the graph.
 *
 * Output:
 * For each test case output will be 1 if the topological sort is done correctly else it will be 0.
 *
 * User Task:
 * The task is to complete the function topoSort() which should return an array containing nodes in topological sorted manner.
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= E, N <= 50
 * 0 <= u, v
 *
 * Example:
 * Input
 * 2
 * 6 6
 * 5 0 5 2 2 3 4 0 4 1 1 3
 * 4 4
 * 3 0 1 0 2 0 0 1
 *
 * Output:
 * 1
 * 0
 *
 * Explanation:
 * Testcase 1: The output 1 denotes that the order is valid.  So, if you have implemented your function
 * correctly, then output would be 1 for all test cases.
 *
 * */