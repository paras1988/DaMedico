package com.interviewbit.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DetectCycleUndirected {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            System.out.print(DetectCycleUndirected.isCyclic(list, nov)+" ");
        }
    }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        Boolean[] vis = new Boolean[V+1];
        Integer[] parent = new Integer[V+1];

        for (int i = 0; i < vis.length; i++) {
            vis[i] = false;
        }
        for (int i = 0; i < vis.length; i++) {
            parent[i] = -1;
        }

        for(int ss=0;ss<list.size();ss++) {
            LinkedList<Integer> l = new LinkedList<>();
            if(vis[ss]){
                continue;
            }
            l.add(ss);

            while (!l.isEmpty()) {
                Integer i = l.poll();
                vis[i] = true;
                for (int a : list.get(i)) {
                    if (vis[a] && a != parent[i]) {
                        return true;
                    }
                    if (!vis[a]) {
                        parent[a] = i;
                        l.add(a);
                    }
                }
            }
        }
        return false;
    }
}

/**
 *
 * Given a undirected graph, the task is to complete the method isCyclic() to detect if there is a cycle in the undirected graph or not.
 *
 * Input:
 * The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' testcases follow.
 * Each testcase consists of two lines. Description of testcases are as follows: The First line of each testcase contains two integers
 * 'N' and 'M' which denotes the no of vertices and no of edges respectively.
 * The Second line of each test case contains 'M'  space separated pairs u and v denoting that there is a bidirectional
 * edge from u to v .
 *
 * Output:
 * The method should return 1 if there is a cycle else it should return 0.
 *
 * User task:
 * Since this is a functional problem you don't have to worry about input, you just have to complete the function isCyclic.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N,M <= 100
 * 0 <= u,v <=  N-1
 *
 * Example:
 * Input:
 * 3
 * 2 2
 * 0 1 0 0
 * 4 3
 * 0 1 1 2 2 3
 * 5 4
 * 0 1 2 3 3 4 4 2
 *
 * Output:
 * 1
 * 0
 * 1
 *
 * Explanation:
 * Testcase 1: In above first test case there is a graph with 2 vertices and 2 edges the first edge is from 0 to 1 and other edge is from 0 to 0 .
 * Testcase 2: In the second test case there is a graph with 3 vertices and 3 edges from 0 to 1 , 1 to 2 and 2 to 3.
 *
 * 1
 * 68 24
 * 6 48 15 47 21 55 4 10 32 3 10 4 20 40 41 65 63 39 30 41 21 45 7 49 60 0 46 40 24 13 27 39 2 42 26 31 37 30 49 9 34 59
 * 21 62 39 62 0 43
 *
 * */
