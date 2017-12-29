package com.JavaQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an unsorted integer array, find the first missing positive integer.

Example:

Given  [1,2,0]  return 3,

 [3,4,-1,1]  return 2,

 [-8, -7, -6]  returns 1

Your algorithm should run in  O(n)  time and use constant space.

 * */
public class FirstMissingInteger_Inmobi {

	public static void main(String[] args) {


		Integer[] arr={830, 926, 981, -1, 0, 472, 206, 539, 240, 891, 227, 941, 894, 41, 258, 980, 901, 641, 90, 232, 673, 598, 964, 732, 888, 278, 908, 468, 75, 878, 756, 348, 814, 125, 813, 113, 365, 394, 329, 502, 335, 318, 541, 505, 346, 431, 308, 269, 910, 65, 897, 670, 350, 581, 171, 137, 738, 196, 273, 633, 656, 593, 815, 488, 963, 275, 25, 840, 807, 760, 35, 540, 745, 723, 819, 804, 620, 414, 759, 883, 584, 506, 507, 822, 44, 105, 547, 961, 175, 869, 793, 42, 210, 597, 666, 990, 405, 313, 72, 604, 629, 293, 880, 247, 39, 625, 73, 519, 478, 385, 826, 208, 966, 209, 655, 317, 669, 585, 197, 184, 925, 945, 748, 589, 861, 337, 87, 764, 678, 734, 525, 43, 943, 110, 918, 838, 909, 580, 103, 577, 686, 40, 730, 496, 162, 437, 445, 377, 752, 833, 516, 665, 466, 958, 616, 747, 875, 345, 724, 650, 183, 126, 117, 794, 787, 996, 83, 510, 613, 448, 614, 530, 205, 898, 121, 216, 742, 706, 534, 810, 944, 806, 190, 913, 969, 984, 226, 47, 429, 266, 873, 979, 417, 746, 304, 952, 157, 229, 450, 767, 143, 235, 249, 455, 763, 999, 407, 621, 141, 465, 326, -4, 441, 959, 46, 292, 947, 492, 484, 751, 676, 442, 284, 994, 286, 29, 338, 325, 978, 366, 550, 341, 422, 750, 929, 611, 623, 192, 735, 845, 775, 135, 823, 537, 592, 685, 295, 161, 55, 683, 508, 627, 333, 920, 255, 163, 281, 570, 53, 718, 842, 755, 416, 635, 166, 564, 701, 69, 221, 960
		};
		List<Integer> arri=Arrays.asList(arr);
		ArrayList<Integer> a=new ArrayList<>(arri);
		System.out.println(new FirstMissingInteger_Inmobi().firstMissingPositive(a));

	}

	public int firstMissingPositive(ArrayList<Integer> a) {

		a=removeNegativeAndZeroesDecorator(a);

		if(a.size()==0){
			return 1;
		}
		for(int i=0;i<a.size();i++){
			if((Math.abs(a.get(i))-1)<a.size()){
				System.out.println(i+" "+(Math.abs(a.get(i))-1));
				a.set((Math.abs(a.get(i))-1),-1*a.get(Math.abs(a.get(i))-1));
			}}
		if(allAreNegative(a)){
			return a.size()+1;
		}
		for(int i=0;i<a.size();i++){
			if(a.get(i)>0){
				return i+1;
			}
		}
		return 0;
	}

	private boolean allAreNegative(ArrayList<Integer> a) {
		for(int i=0;i<a.size();i++){
			if(a.get(i)>0){
				return false;
			}
		}
		return true;
	}

	private ArrayList<Integer> removeNegativeAndZeroesDecorator(
			ArrayList<Integer> a) {

		for(int i=0;i<a.size();i++){
			if(a.get(i)<=0){
				a.remove(i);
				i--;
			}
		}
		return a;
	}
}
