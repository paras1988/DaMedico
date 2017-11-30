package com.GeekFGeeks.DP;

public class CoinChangeProblem {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3};
		System.out.println(coinChangeRecur(arr, arr.length, 4));
		System.out.println(count(arr,arr.length,4));
	}

	public static int coinChangeRecur(int[] arr,int n,int m){

		if(m==0){
			return 1;
		}
		if (m < 0) {
			return 0;
		}
		if (n <=0 && m >= 1) {
			return 0;
		}
		return coinChangeRecur(arr,n-1,m)+
				coinChangeRecur(arr,n,m-arr[n-1]);
	}


	/*Here we make a table like this
		0 1 2 3 4
	1
	2
	3

	Then we fill the table as e.g. for coins 1,2 for getting sum as 3.
	count= excluding coin 2 (i.e for coin 1 sum as 3)+ including coin 2(i.e. for coin 2 sum as 3-2)

	 */
	static int count( int S[], int m, int n )
	{
		int i, j, x, y;

		// We need n+1 rows as the table is consturcted in bottom up manner using
		// the base case 0 value case (n = 0)
		int table[][]=new int[n+1][m];

		// Fill the enteries for 0 value case (n = 0)
		for (i=0; i<m; i++) {
			table[0][i] = 1;
		}

		// Fill rest of the table enteries in bottom up manner
		for (i = 1; i < n+1; i++)
		{
			for (j = 0; j < m; j++)
			{
				// Count of solutions including S[j]
				x = (i-S[j] >= 0)? table[i - S[j]][j]: 0;

				// Count of solutions excluding S[j]
				y = (j >= 1)? table[i][j-1]: 0;

				// total count
				table[i][j] = x + y;
			}
		}
		return table[n][m-1];
	}
}
