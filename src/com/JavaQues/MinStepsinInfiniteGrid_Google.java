package com.JavaQues;

import java.util.ArrayList;
/*
 * (x,y) to
    (x+1, y),
    (x - 1, y),
    (x, y+1),
    (x, y-1),
    (x-1, y-1),
    (x+1,y+1),
    (x-1,y+1),
    (x+1,y-1)
 * 
 * 
 * Input : [(0, 0), (1, 1), (1, 2)]
Output : 2
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 * */
public class MinStepsinInfiniteGrid_Google {

	public static void main(String[] args) {

		ArrayList<Integer> x=new ArrayList<Integer>();
		x.add(4);
		x.add(5);

		/*		x.add(-7);
		x.add(-5);
		x.add(-13);
		x.add(9);
		x.add(-7);
		x.add(8);
		 */
		ArrayList<Integer> y=new ArrayList<Integer>();
		y.add(4);
		y.add(6);

		/*		y.add(-10);
		y.add(-3);
		y.add(-13);
		y.add(12);
		y.add(8);
		y.add(-8);
		 */
		int res=new MinStepsinInfiniteGrid_Google().coverPoints1(x,y);

		System.out.println(res);

	}



	private int coverPoints1(ArrayList<Integer> X, ArrayList<Integer> Y) {
		int totalStep = 0;
		int currentX = X.get(0);
		int currentY = Y.get(0);
		for(int i=1;i<X.size();i++){
			totalStep += Math.max(Math.abs(currentX - X.get(i)), Math.abs(currentY - Y.get(i)));
			currentX = X.get(i);
			currentY = Y.get(i);
		}
		return totalStep;
	}

	private int max(int a, int b) {

		return (a<b)?a:b;
	}

	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {

		int n=X.size();

		int count=0;
		for(int i=1;i<n;i++){
			count =count+minSteps(X.get(i-1),Y.get(i-1),X.get(i),Y.get(i));
			System.out.println(count);
		}
		return count;
	}

	private int minSteps(Integer x1, Integer y1, Integer x2,
			Integer y2) {

		if(x2==x1 && y2==y1){
			return 0;
		}
		if(x2==x1){
			if(Math.signum(y1) != Math.signum(y2)){
				return Math.abs(y1)+Math.abs(y2);
			}else{
				return Math.abs(y1)-Math.abs(y2);
			}
		}
		if(y2==y1){
			if(Math.signum(x1) != Math.signum(x2)){
				return Math.abs(x1)+Math.abs(x2);
			}else{
				return Math.abs(x1)-Math.abs(x2);
			}
		}
		int i=0;
		int j=0;
		i=(x2<x1)?1:-1;
		j=(y2<y1)?1:-1;

		return 1+minSteps(x1,y1,x2+i,y2+i);


	}

	private int min(int... a) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++){
			if(i<min){
				min=i;
			}
		}
		return min;
	}

	private int min(int a,int b,int c) {

		return (a<b)?((a<c)?a:c):((b<c)?b:c);
	}



}
