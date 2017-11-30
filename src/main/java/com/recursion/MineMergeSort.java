package com.recursion;

public class MineMergeSort {
	public static void main(final String[] args) {
		//final Integer arr[]={9,7,6,4,3,23,7,45,6,34};
		//final String arr[]={"df","asdf","34","ty","jk","wq","aa","dd","bn"};

		final Student one=new Student(9, 8, "z");
		final Student two=new Student(8, 6, "x");
		final Student three=new Student(6, 5, "v");
		final Student four=new Student(6, 5, "y");
		final Student five=new Student(4, 4, "r");
		final Student six=new Student(4, 3, "a");


		final Student arr[]={one,two,three,four,five,six};

		merge_sort(arr);
		for(final Student s:arr){
			System.out.println(s.name);
		}
		//System.out.println(Arrays.toString(arr));
	}

	private static void merge_sort(final Comparable[] arr) {
		final int left=0;
		final int right=arr.length-1;
		merge_sor_rec(arr,left,right);
	}

	private static void merge_sor_rec(final Comparable[] arr, final int left, final int right) {
		if(left<right){
			final int middle=(left + right) / 2;

			merge_sor_rec(arr, left, middle);
			merge_sor_rec(arr, middle+1, right);
			merge(arr,left,middle+1,right);
		}
	}
	private static void merge(final Comparable[] arr, final int left, final int middle, final int right) {
		final Comparable temp[]=new Comparable[arr.length];

		int leftT=left;
		int startR=middle;
		int k=left;

		while(leftT<=middle-1 && startR<=right){
			if(arr[leftT].compareTo(arr[startR])<=0){
				temp[k++]=arr[leftT++];
			}
			else{
				temp[k]=arr[startR];
				startR++;
				k++;
			}
		}
		while(leftT<=middle-1){
			temp[k++]=arr[leftT++];
		}
		while(startR<=right){
			temp[k++]=arr[startR++];
		}
		// Copy tmp back
		for(int i = left; i <=right; i++) {
			arr[i] = temp[i];
		}
	}
}
class Student implements Comparable{

	int height;
	int weight;
	String name;

	public Student(final int a,final int b, final String c) {
		height=a;
		weight=b;
		name=c;
	}
	@Override
	public int compareTo(final Object o) {
		if(height-((Student)o).height!=0) {
			return height-((Student)o).height;
		} else if(weight-((Student)o).weight!=0) {
			return weight-((Student)o).weight;
		} else {
			return name.compareTo(((Student)o).name);
		}
	}

}
