package com.JavaQues;

/*
 * 
 * LIS(i) =max(LIS(j)) + 1 if(j<i && arr[j]<arr[i])
 * length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 */
public class LIS_Practice {
	static int maxFinal=0;
	public static void main(String[] args) {
		int[] arr={10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(LIS_recur(arr,arr.length));
	}

	private static int LIS_recur(int[] arr,int k) {

		if(k==1) {
			return 1;
		}

		int sub_res, max_res = 1;
		for(int i=1;i<k;i++){
			sub_res=LIS_recur(arr,i);

			if(arr[i-1]<arr[k-1] && sub_res+1 > max_res){
				max_res=sub_res+1;
			}

		}

		if(max_res>maxFinal) {
			maxFinal=max_res;
		}

		return maxFinal;
	}
}
