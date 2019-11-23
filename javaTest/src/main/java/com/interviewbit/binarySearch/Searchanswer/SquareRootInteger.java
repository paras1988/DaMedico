package com.interviewbit.binarySearch.Searchanswer;


/*Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
*/
public class SquareRootInteger {

    public static void main(String[] args) {
        System.out.println(new SquareRootInteger().sqrt(4));
        System.out.println(new SquareRootInteger().sqrt(2147483647));
    }

    public int sqrt(int a) {
        int min = 0;
        int max = a;

        if(a==1){
            return 1;
        }
        while(min < max){
            int mid = min + (max - min)/2;

       //     System.out.println(mid);
            if((long)mid*mid > (long)a){
                max = mid;
            }
            else if((long)mid*mid < (long)a && (long)(mid+1)*(mid+1)<=(long)a){
                min = mid;
            }
            else {
                return mid;
            }
        }
        return 0;
    }
}
