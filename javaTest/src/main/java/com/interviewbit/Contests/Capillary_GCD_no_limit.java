package com.interviewbit.Contests;

public class Capillary_GCD_no_limit {

  public static void main(String[] args) {
    Capillary_GCD_no_limit c =new Capillary_GCD_no_limit();
    System.out.println(c.f(1000));
  }

  long f(int a){
    long ans = 0;
    int i =1;
    while (i<= a){
      ans +=p(i);
      i = i+1;
    }
    return ans % 1000000007;
  }

  Long p(int m){
    long ans = 1;
    int k = 1;
    while(k<=m){
      if(gcd(k,m) == 1){
        ans *= k;
      }
      k = k+1;
    }
    return ans%m;
  }

  long gcd(int a, int b)
  {
    int n=Math.min(a,b);
    for(int i=2;i<=n;i++)
    {
      if(a%i==0 && b%i==0)
      {
        return 2;
      }
    }
    return 1;
  }
}

