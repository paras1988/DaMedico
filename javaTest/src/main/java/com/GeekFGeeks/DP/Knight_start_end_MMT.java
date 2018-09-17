package com.GeekFGeeks.DP;

public class Knight_start_end_MMT {

	int[] a={1,2,2,1,-1,-2,-2,-1};
	int[] b={2,1,-1,-2,-2,-1,1,2};

	public static void main(String[] args) {
		int N = 30;
		int knightPos[] = {1, 1};
		int targetPos[] = {30, 30};
		int res = new Knight_start_end_MMT().minStepToReachTarget(knightPos, targetPos, N);
		System.out.print(res);
	}

	private int minStepToReachTarget(int[] knightPos, int[] targetPos, int n) {
		if(knightPos == targetPos){
			return 0;
		}
		if(n==0){
			return 0;
		}
		int res = 0;
		for(int count = 0 ; count<8; count++){
			int knightPos2[] = knightPos;
			knightPos2[0] = knightPos[0] + a[count];
			knightPos2[1] = knightPos[1] + b[count];

			int m= n-1;
			int temp = 1+minStepToReachTarget(knightPos2,targetPos,m);
			if(res == 0){
				res = temp;
			}
			if(res>temp){
				res = temp;
			}
		}
		return res;
	}


}
