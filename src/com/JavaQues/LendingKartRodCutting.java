package com.JavaQues;

public class LendingKartRodCutting {

	static int count1=0;
	static int count2=0;

	public static void main(String[] args) {
		int n=100000;
		System.out.println(rodCutting(n)+" "+count1);
		System.out.println(rodCuttingDP_bottomUp(n)+" "+count2);
	}

	private static int rodCutting(int n) {

		count1++;
		if(n==0 || n==1){
			return 0;
		}

		if(n%2==0){
			return 2*rodCutting(n/2);
		}else{
			return 1+rodCutting(n/2+1)+rodCutting(n/2-1);
		}
	}

	private static int rodCuttingDP_bottomUp(int n){

		int[] res=new int[n+1];
		res[0]=0;
		res[1]=0;

		for(int i=2;i<=n;i++){
			count2++;
			if(i%2==0){
				res[i]=res[i/2]*2;
			}else{
				res[i]=1+res[i/2+1]+res[i/2-1];
			}
		}

		return res[n];
	}
}
