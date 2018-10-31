package com.interviewbit.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Capillary_FriendCircles {

  public static int l = 0;
  public static int h = 0;
  public static int c = 0;
  public static int p = 1;
  int[] input;

  public static void main(String args[]) throws Exception {
    new Capillary_FriendCircles().init();
  }

  private void init() throws IOException {
    CustomeScanner sc = new CustomeScanner(System.in);
    int tests = sc.nextInt();

    while (tests-->0){
      l = 0;
      h = 0;
      c = 0;
      p = 1;

      int n = sc.nextInt();
      int q = sc.nextInt();

      int[] arr = new int[n];
      int[] grp = new int[n];

      for (int i = 0; i<n; i++){
        arr[i] = sc.nextInt();
      }
      input = arr;
      for (int i = 0; i<n; i++){
        grp[i] = 0;
      }
      int count = 0;
      Map<Integer,Group> map = new HashMap<>();

      for(int i=0;i<q;i++){
        int x = sc.nextInt()-1;
        int y = sc.nextInt()-1;
        count++;
        if(grp[x] == grp[y]){

        }
        else if(grp[x] == 0 && grp[y] == 0){
          Group group  = new Group(x,y,count,grp);
          map.put(count,group);
        }
        else if(grp[x] != 0 && grp[y] == 0){
          Group group  = map.get(grp[x]);
          group.update(y);
          grp[y] = grp[x];
        }
        else if(grp[x] == 0 && grp[y] != 0){
          Group group  = map.get(grp[y]);
          group.update(x);
          grp[x] = grp[y];
        }
        else{
            Group group1 = map.get(grp[x]);
            Group group2 = map.get(grp[y]);
            ((HashMap) map).remove(grp[x]);
            ((HashMap) map).remove(grp[y]);
            Group group = new Group(group1, group2, count, grp);
            map.put(count, group);
        }
        System.out.println(h+" "+c+" "+p);
      }
    }
  }

  class Group{

    Integer[] arr;
    int max = 0;
    Boolean isPrime = false;

    public Group(int i1, int i2, int count, int[] grp) {
      grp[i1] = count;
      grp[i2] = count;
      arr = new Integer[2];
      arr[0] = i1;
      arr[1] = i2;

      max = Math.max(input[i1],input[i2]);
      if(l<=2){
        l = 2;
        h = Math.max(h,max);
      }
      isPrime = true;
      c++;
      p *=2;
    }

    public Group(Group group1, Group group2, int count, int[] grp) {
      arr = new Integer[group1.arr.length+group2.arr.length];
      int j = 0;
      for (int i=0;i<group1.arr.length;i++,j++){
        arr[j] = group1.arr[i];
        grp[group1.arr[i]] = count;
      }
      for (int i=0;i<group2.arr.length;i++,j++){
        arr[j] = group2.arr[i];
        grp[group2.arr[i]] = count;
      }

      max = Math.max(group1.max,group2.max);

      if(l<=arr.length){
        l = arr.length;
        h = Math.max(h,this.max);
      }
      isPrime = isPrime(arr.length);
      if(group1.isPrime){
        c--;
      }
      if(group2.isPrime){
        c--;
      }
      if(isPrime){
        c++;
      }
      p =p/(group1.arr.length);
      p =p/(group2.arr.length);
      p =p*arr.length;
    }

    public void update(int cc) {
      Integer[] arr2 = new Integer[this.arr.length+1];
      for(int i=0 ;i <this.arr.length;i++){
        arr2[i] = this.arr[i];
      }
      arr2[arr2.length-1] = cc;
      this.arr = arr2;

      max = Math.max(this.max,input[cc]);

      if(l<=arr2.length){
        l = arr2.length;
        h = Math.max(h,this.max);
      }
      Boolean isPrimeOld = isPrime(arr2.length-1);
      if(isPrimeOld){
        c--;
      }
      isPrime = isPrime(arr2.length);
      if(isPrime){
        c++;
      }
      p =p/(arr2.length-1);
      p =p*arr2.length;
    }
  }

  private static boolean isPrime(int num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (int i = 3; i * i <= num; i += 2)
      if (num % i == 0) return false;
    return true;
  }

  class CustomeScanner {
    BufferedReader br;
    StringTokenizer st;

    public CustomeScanner(InputStream is) {
      br = new BufferedReader(new InputStreamReader(is));
      st = new StringTokenizer("");
    }

    public long nextLong() throws IOException {
      if (st.hasMoreTokens()) {
        return Long.parseLong(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      return nextLong();
    }

    String next() throws IOException {
      if (st.hasMoreTokens()) {
        return st.nextToken();
      }
      st = new StringTokenizer(br.readLine());
      return next();
    }

    int nextInt() throws IOException {
      if (st.hasMoreTokens()) {
        return Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      return nextInt();
    }
  }
}

