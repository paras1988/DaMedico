package com.interviewbit.binarySearch.SearchStepSimulation;

class ImplementPowerFunction {

    public static void main(String[] args) {
        System.out.println(new ImplementPowerFunction().pow(2,3,3));
        System.out.println(new ImplementPowerFunction().pow(0,0,1));
        System.out.println(new ImplementPowerFunction().pow(-1,1,20));
        System.out.println(new ImplementPowerFunction().pow(3,1,5));
        System.out.println(new ImplementPowerFunction().pow(3,2,5));
        System.out.println(new ImplementPowerFunction().pow(3,3,5));
        System.out.println(new ImplementPowerFunction().pow(3,4,5));
        System.out.println(new ImplementPowerFunction().pow(3,5,5));
        System.out.println(new ImplementPowerFunction().pow(3,6,5));
        System.out.println(new ImplementPowerFunction().pow(3,7,5));
        System.out.println(new ImplementPowerFunction().pow(71045970,41535484,64735492));
        System.out.println(new ImplementPowerFunction().pow(79161127,99046373,57263970));
    }

  /*  public int pow(int x, int n, int d) {

        long rem = 1;
        int check = 0;

        // simple cases
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }

        // make x positive, check if power is odd
        if(x < 0){
            x = Math.abs(x);
            if(n%2 != 0){
                check = 1;
            }
        }

        long temp = x%d;

        while(n != 0){
            if(n%2 != 0){
                rem = (rem*temp)%d;
            }

            temp = temp*temp;
            temp = temp%d;

            n = n/2;
            if(rem > d){
                rem = rem%d;
            }
        }

        // if power is odd and x < 0, return d-rem
        if(check == 1){
            return d-(int)rem;
        }

        return (int)rem;
    }*/

    public int pow(int x, int n, int d) {
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x % d;
        }
        if(n == 2){
            return ((x % d) * x) % d;
        }
        if(x<0){
            return (d-Math.abs(x))%d;
        }
        if(n % 2 == 0){
            long a = pow(x,n/2, d);
            return (int)((a % d) * a) % d;
        }
        else{
            return  ((x % d) * (pow(x,n-1, d) % d)) % d;
        }
    }
}



/*Implement pow(x, n) % d.

In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative.
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.


A : 71045970
B : 41535484
C : 64735492
Your function returned the following :
40347324
The expected returned value :
20805472


A : 79161127
B : 99046373
C : 57263970
The expected output for this testcase is:
47168647

*/