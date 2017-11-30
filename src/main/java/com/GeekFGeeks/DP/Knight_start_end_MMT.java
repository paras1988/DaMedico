package com.GeekFGeeks.DP;

public class Knight_start_end_MMT {

	int[] a={1,2,2,1,-1,-2,-2,-1};
	int[] b={2,1,-1,-2,-2,-1,1,2};

	public static void main(String[] args) {

		int s_x;
		int s_y;
		int e_x;
		int e_y;

	}

	private void  fun_util(int s_x,int s_y){

		for(int i=0;i<8;i++){
			if(ifSafe(s_x,s_y,i)){
				fun_util(s_x+a[i],s_y+b[i]);
			}
		}
	}

	private boolean ifSafe(int s_x, int s_y, int i) {

		return true;
	}

}
