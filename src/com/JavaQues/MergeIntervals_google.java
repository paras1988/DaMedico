package com.JavaQues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
 */
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
public class MergeIntervals_google {
	public static void main(String[] args) {

		ArrayList<Interval> arr=new ArrayList<Interval>();
		Interval i1=new Interval(3,5);
		Interval i2=new Interval(8,10);
		arr.add(i1);
		arr.add(i2);

		Interval i6=new Interval(32,11);

		ArrayList<Interval> res=new MergeIntervals_google().insert(arr,i6);
		System.out.println(res.size());
	}
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		if(newInterval.start>newInterval.end){
			newInterval=new Interval(newInterval.end,newInterval.start);
		}
		ArrayList<Interval> newList=new ArrayList<Interval>();
		ArrayList<Interval> merged=new ArrayList<Interval>();

		for(int i=0;i<intervals.size();i++){
			if(intervals.get(i).start>newInterval.end){
				newList.add(intervals.get(i));
			}else if(intervals.get(i).end<newInterval.start){
				newList.add(intervals.get(i));
			}else{
				merged.add(intervals.get(i));
			}
		}
		if(merged.size()!=0){

			int new_start=0;
			int new_end=0;
			if(newInterval.start<merged.get(0).start){
				new_start=newInterval.start;
			}else{
				new_start=merged.get(0).start;
			}

			if(newInterval.end>merged.get(merged.size()-1).end){
				new_end=newInterval.end;
			}else{
				new_end=merged.get(merged.size()-1).end;
			}
			Interval m=new Interval(new_start,new_end);
			newList.add(m);

		}else{
			newList.add(newInterval);
		}

		sortByStartTimeDecorator(newList);

		return newList;
	}
	public ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {

		boolean flag=false;
		boolean hasStarted=false;
		boolean hasEnded=false;
		int new_start=0;
		int new_end=0;
		ArrayList<Interval> res=new ArrayList<Interval>();
		if(newInterval.start>newInterval.end){
			newInterval=new Interval(newInterval.end,newInterval.start);
		}

		for(int i=0;i<intervals.size();i++){

			if(!hasStarted && intervals.get(i).end>=newInterval.start && intervals.get(i).start<=newInterval.end){
				flag=true;
				new_start=intervals.get(i).start;
				hasStarted=true;
			}else if(!hasStarted){
				res.add(intervals.get(i));
			}
			if(hasStarted && !hasEnded && intervals.get(i).end>=newInterval.end){
				new_end=intervals.get(i).end;
				hasEnded=true;
				Interval oo=new Interval(new_start,new_end);
				res.add(oo);
			}else if(hasStarted && hasEnded){
				res.add(intervals.get(i));
			}
		}
		if(!hasStarted && !hasEnded){
			res.add(newInterval);
		}

		sortByStartTimeDecorator(res);
		return res;
	}

	private void sortByStartTimeDecorator(ArrayList<Interval> res) {
		Collections.sort(res,new MyComparator());
	}

	class MyComparator implements Comparator<Object>{

		@Override
		public int compare(Object o1, Object o2) {
			Interval i1=(Interval)o1;
			Interval i2=(Interval)o2;

			if(i1.start<i2.start){
				return -1;
			}
			if(i1.start>i2.start){
				return 1;
			}

			return 0;
		}
	}
}
