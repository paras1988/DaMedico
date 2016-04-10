package com.JavaQues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
 */

public class MergeOverlappingIntervals_google {

	public static void main(String[] args) {
		ArrayList<Interval> input=new ArrayList<Interval>();
		Interval i1=new Interval(30,63);
		Interval i2=new Interval(1,100);
		input.add(i1);
		input.add(i2);
		ArrayList<Interval> res=new MergeOverlappingIntervals_google().merge(input);
		System.out.println(res.size());
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		sortByStartTimeDecorator(intervals);
		Interval pInter=new Interval(intervals.get(0).start,intervals.get(0).end);

		ArrayList<Interval> res=new ArrayList<Interval>();

		if(intervals.size()==1){
			res.add(pInter);
		}else{

			for(int i=1;i<intervals.size();i++){

				if(isOverlapped(intervals.get(i),pInter)){
					int n_start=(intervals.get(i).start>pInter.start)?pInter.start:intervals.get(i).start;
					int n_end=(intervals.get(i).end<pInter.end)?pInter.end:intervals.get(i).end;

					pInter=new Interval(n_start,n_end);
				}else{
					res.add(pInter);
					int n_start=intervals.get(i).start;
					int n_end=intervals.get(i).end;
					pInter=new Interval(n_start,n_end);
				}
				if(i==intervals.size()-1){
					res.add(pInter);
				}
			}
		}
		return res;
	}

	private boolean isOverlapped(Interval interval, Interval pInter) {

		if(interval.start<=pInter.end){
			return true;
		}
		return false;
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
