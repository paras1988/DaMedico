package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Abhimanyu has a complete binary tree of level L, called Crazy Tree. Levels are numbered 1, 2, ..., L from top to bottom and root is at level 1. Abhimanyu numbers all the leaf nodes 1, 2, 3, ... from left to right. The value of the parent node is the product of values of its child node.

Below are level 2 (left) and level 3 (right) crazy trees

Level 2 Level 3

Abhimanyu defines a magical function S:

S(N, X, Y): This gives the sum of Xth, (X + 1)th, (X + 2)th, ..., Yth nodes at level N.
Abhimanyu wants to find the value of S(N, X, Y) % M for given values of N, X, Y, where M = 1299709.

Input

First line of input contains two space separated integers L and Q, where L is number of levels in the crazy tree and Q is total number of queries. Each of the next Q lines contains three space separated integers N, X and Y.

Output

Output the value of S(N, X, Y) % M in single line for each test case.

Constraints

1 <= L <= 21
1 <= Q <= min(106, (2L - 1) (2L + 4) / 6), where min(a, b) is minimum of a and b
1 <= N <= L
1 <= X <= 2(L - 1)
X <= Y <= 2(L - 1)
SAMPLE INPUT
3 14
1 1 1
3 1 4
2 1 2
2 2 2
3 4 4
3 3 3
3 3 4
2 1 1
3 1 2
3 1 3
3 2 2
3 2 4
3 1 1
3 2 3
SAMPLE OUTPUT
24
10
14
12
4
3
7
2
3
6
2
9
1
5
Explanation
As Tree has 3 levels you can refer to right image above.

Now for query 2 1 2 At level 2, Value of node 1 = 2 At level 2, value of node 2 = 12

So, S(2, 1, 2) = 2 + 12 = 14*/
public class HoneyWell1_CrazyTree {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] sd=line.split("\\s+");

		int level=Integer.parseInt(sd[0]);
		int numberOfqueries=Integer.parseInt(sd[1]);

		int leafNode=(int) Math.pow(2, level-1);

		List<Integer> res=new ArrayList<>();

		for(int i=0;i<numberOfqueries;i++){
			String query = br.readLine();
			String[] sd2=query.split("\\s+");

			int l=Integer.parseInt(sd2[0]);
			int s=Integer.parseInt(sd2[1]);
			int e=Integer.parseInt(sd2[2]);

			/*int l=3;
			int s=1;
			int e=4;*/
			Map<Integer,Long[]> map=craxyTreeUtil(leafNode,level);
			res.add(processMapForResult(map,l,s,e));
		}

		for(Integer i:res){
			System.out.println(i);
		}
	}

	private static int processMapForResult(
			Map<Integer, Long[]> map, int l, int s, int e) {
		int sum=0;

		if(map.size()>0){
			List<Long> list=Arrays.asList(map.get(l));
			for(int i=s;i<=e;i++){
				sum +=list.get(i-1);
			}
		}
		return sum;
	}

	private static Map<Integer,Long[]> craxyTreeUtil(int leafNode, int level) {
		Map<Integer,Long[]> map=new HashMap<>();

		Long[] array=null;
		Long[] temp=new Long[leafNode];
		int count=0;

		for(int i=level;i>=1;i--){
			array=new Long[leafNode];
			for(int j=1;j<=leafNode;j++){

				if(i==level){
					array[count]=(long) j;
				}
				else{
					int a=j*2-1;
					int b=j*2-2;
					temp=map.get(i+1);
					array[count]=temp[a]*temp[b];
				}
				count++;
			}
			count=0;
			map.put(i,array);
			leafNode=leafNode/2;
		}

		return map;
	}
}
