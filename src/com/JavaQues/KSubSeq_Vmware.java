package com.JavaQues;

public class KSubSeq_Vmware {

	private static long counter = 0;


	static long kSub1(int k,int nums[]) {
		process(nums, k);
		return counter;
	}
	private static void process(int[] nums, int k) {

		for(int i=0;i<nums.length;i++){
			long sum=0;
			for(int j=i;j<nums.length;j++){
				sum+=nums[j];
				if(sum%k==0){
					counter++;
				}
			}
		}

	}
	public static void main(String[] args) {
		int nums[]={1 , 1 , 3 , 2, 4};
		int k=3;
		System.out.println(kSub1(k,nums));
		//System.out.println(solve(nums, k));
	}


	/**
	 * Sub-Routine to count numnber of sub-sequnces
	 * @param d: the given divisor
	 */
	public static long kSub(int d,int[] arr, int h)
	{
		int Answer = 0;
		int[] hash = new int[d];

		int sum = 0;
		int val;
		int num;

		for (int i = 0; i < arr.length; i++) {
			num = arr[i];

			if(num % d == 0) {
				Answer ++ ;
			}

			sum +=  num;
			val = sum % d;

			if(val<0) {
				val = val * (-1);
			}

			hash[val] = hash[val] + 1;
		}

		int size=hash.length ;
		for (int i = 0; i < size; i++) 	{
			int count = hash[i];

			if(count > 1) {
				Answer = Answer + count * (count -1)/2 ;
			}
		}
		return Answer+hash[0]-1;
	}
}

/*private static long kSub( int K,int[] A)
	{
		int N = A.length;
		int[] B = new int[K];
		for (int i = 0; i < B.length; i++)
		{
			B[i] = 0;
		}
		B[0]++;
		int s = 0;
		for (int i = 0; i < N; i++)
		{
			s = (s + A[i]) % K;
			while (s < 0)
			{
				s += K;
			}
			B[s]++;
		}
		int ans = 0;
		for (int i = 0; i <= K - 1; i++)
		{
			ans += B[i] * (B[i] - 1) / 2;
		}
		return ans;
	}*/
