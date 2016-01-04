package com.HackerEarth.Easy;

public class NumberOfRs {

	public static void main(String[] args) {
		int arr[]={-2, -5, 6, -2, -3, 1, 5, -6};

		int max=getNumberOfRs(arr,0,arr.length-1);
		System.out.println(max);

		int max2=maxSubArraySum_mohit(arr,arr.length);
		System.out.println(max2);

		int arr2[]={-1,1,1,-1,1,1,-1,-1,1,1};

		int[] max3=maxSubArraySum_Paras(arr2,arr2.length);
		System.out.println(max3[0]+" "+max3[1]+" "+max3[2]+" ");
		int l=max3[1];
		int h=max3[2];
		int ans=max3[0];

		for(int i=0;i<l;i++){
			if(arr2[i]<0){
				ans++;
			}
		}
		for(int i=l;i<=h;i++){
			if(arr2[i]<0){
				ans++;
			}
		}
		for(int i=h+1;i<arr2.length;i++){
			if(arr2[i]<0){
				ans++;
			}
		}

		System.out.println("Answer is"+ans);
	}

	static int getNumberOfRs(int arr[],int i,int n){
		//System.out.println(i);
		if(arr[i]==arr[n]){
			return arr[i];
		}
		int m = (i + n)/2;

		return max(getNumberOfRs(arr,i,m),
				getNumberOfRs(arr,m+1,n),
				combineResult(arr,i,m,n));

	}

	private static int max(int a,int b,int c) {
		return (a>b?a:(b>c)?b:c);
	}

	private static int combineResult(int[] arr, int a, int b, int c) {

		int sum=0;
		int sum_left=-222;
		int sum_right=-222;
		for(int i=b;i>a;i--){
			sum+=arr[i];
			if(sum>sum_left){
				sum_left=sum;
			}
		}

		sum=0;
		for(int i=b+1;i<c;i++){
			sum+=arr[i];
			if(sum>sum_right){
				sum_right=sum;
			}
		}
		return sum_left+sum_right;
	}

	public static int maxSubArraySum_kadanes(int[] arr){
		int max_curr=0;
		int max_so_far=0;

		for(int i=0;i<arr.length;i++){
			if(arr[i]<0){

			}
		}

		return 0;
	}

	static int maxSubArraySum_mohit(int a[], int size)
	{
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < size; i++)
		{
			curr_max = max(a[i], curr_max+a[i]);
			max_so_far = max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	private static int max(int i, int j) {
		return (i>j?i:j);
	}

	static int[] maxSubArraySum_Paras(int a[], int size)
	{
		int[] max_t = new int[size];
		max_t[0]=a[0];
		int m = a[0];

		int l=0;
		int h=0;

		for (int i = 1; i < size; i++)
		{
			if(a[i]+max_t[i-1]<a[i]){
				max_t[i]=a[i];

			}else{
				max_t[i]=a[i]+max_t[i-1];
			}

			if(max_t[i]>m){
				if(m<0){
					l=i;
					h=i;
				}else{
					h=i;
				}
				m=max_t[i];
			}
		}
		int[] res={m,l,h};
		return res;
	}
}
