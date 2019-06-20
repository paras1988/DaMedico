package com.HackerEarth.Easy.capillary;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Nodes in a subtree
 * You are given a rooted tree that contains  nodes. Each node contains a lowercase alphabet.
 *
 * You are required to answer  queries of type , where  is an integer and  is a lowercase
 * alphabet. The count of nodes in the subtree of the node  containing  is considered as
 * the answer of all the queries.
 *
 * Input format
 *
 * First line: Two space-separated integers  respectively
 * Second line: A string  of length  (where the  character of  represents the character
 * stored in node )
 * Next  line: Two space-separated integers  and  denoting an edge between node  and node
 * Next  lines: An integer  and a space-separated character
 * Output format
 * For each query, print the output in a new line.
 *
 * Constraints
 *
 *
 *  is a lowercase alphabet
 *  is a lowercase alphabet for all
 *  is the root node
 * Note: It is guaranteed that the input generates a valid tree.
 *
 * Sample Input
 * 3 1
 * aba
 * 1 2
 * 1 3
 * 1 a
 * Sample Output
 * 2
 * Explanation
 * Tree given in the sample input will look like that.
 */
public class NodesInSubtree {

    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner(System.in);
        int N = sc.nextInt();
        int queries = sc.nextInt();

        String str = sc.next();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<N-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(a)){
                list = map.get(a);
            }
            list.add(b);
            map.put(a,list);
        }

        Nodeq node = process(map,1,str);

        int[] qq = new int[queries];
        Character[] qc = new Character[queries];

        for(int i=0;i<queries;i++){
            qq[i] = sc.nextInt();
            qc[i] =  sc.next().charAt(0);
        }
        for(int i=0;i<queries;i++){
            Integer res  = giveResult(node,qq[i], qc[i]);
            if(res==null){
                System.out.println(0);
            }
            else{
                System.out.println(res);
            }

        }

    }

    private static Integer giveResult(Nodeq node, int a, Character b) {
        if(node.a==a){
            return node.map.get(b);
        }
        else{
            for(Nodeq nodeq:node.nodes){
                Integer res = giveResult(nodeq,a,b);
                if(res!=null){
                    return res;
                }
            }
        }
        return null;
    }

    private static Nodeq process(Map<Integer, List<Integer>> map, Integer i,String str) {
        Nodeq node = new Nodeq();
        node.a = i;
        if(map.containsKey(i)){
            for(Integer s:map.get(i)){
                node.nodes.add(process(map,s,str));
            }
        }
        for(Nodeq n:node.nodes){
            for(Map.Entry<Character,Integer> entry:n.map.entrySet()){
                if(node.map.containsKey(entry.getKey())){
                    Integer x = node.map.get(entry.getKey());
                    Integer y = entry.getValue();
                    node.map.put(entry.getKey(),x+y);
                }
                else{
                    node.map.put(entry.getKey(),entry.getValue());
                }
            }
        }
        if(node.map.containsKey(str.charAt(i-1))){
            node.map.put(str.charAt(i-1),node.map.get(str.charAt(i-1))+1);
        }else{
            node.map.put(str.charAt(i-1),1);
        }
        return node;
    }

    static class Nodeq {
        Integer a;
        List<Nodeq> nodes = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            st = new StringTokenizer("");
        }

        public long nextLong() throws IOException {
            if (st.hasMoreTokens()) {
                return Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            return nextLong();
        }

        String next() throws IOException {
            if (st.hasMoreTokens()) {
                return st.nextToken();
            }
            st = new StringTokenizer(br.readLine());
            return next();
        }

        int nextInt() throws IOException {
            if (st.hasMoreTokens()) {
                return Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            return nextInt();
        }
    }
}
