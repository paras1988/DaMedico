package com.interviewbit.binarySearch.Searchanswer;


import java.util.Arrays;

/*Given a N cross M matrix in which each row is sorted,
find the overall median of the matrix. Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.
Note: No extra memory is allowed.
*/
public class MatrixMedian {


    public static void main(String[] args) {
        int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} };

        System.out.println("Median is " + new MatrixMedian().findMedian(m));
    }

    public int findMedian(int[][] A) {

        int r = A.length;
        int c = A[0].length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(A[i][j]<min){
                    min = A[i][j];
                }
                if(A[i][j]>max){
                    max = A[i][j];
                }
            }
        }

        while(min < max){
            int places = 0;

            int mid = min + (max - min)/2;
            for(int i=0;i<r;i++){


                int p = Arrays.binarySearch(A[i],mid);

                if(p < 0)
                    p = Math.abs(p) - 1;
                else{
                    while(p < A[i].length && A[i][p] == mid)
                        p += 1;


                }
                places += p;
            }
            if (places < (r*c+1)/2)
                min = mid + 1;
            else
                max = mid;
        }


        return min;
    }
}
