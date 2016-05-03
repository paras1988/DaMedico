package com.JavaQues;

public class Slot_Mchine_Intuit {
	public static void main(String[] args) {

		String[] input={"","","",""};
		System.out.println(slotGame(input));
	}

	static int slotGame(String[] d){

		Integer[] res=new Integer[d.length];
		int out=0;
		while(d[0].length()!=0){
			int max=0;
			for(int i=0;i<d.length;i++){
				String t=d[i];
				d[i]=get_delete_Max(t,res,i);
				if(res[i]>max){
					max=res[i];
				}
			}
			out +=max;
		}
		return out;
	}

	private static String get_delete_Max(String t, Integer[] res, int i2) {
		int max=0;
		int index=0;
		for(int i=0;i<t.length();i++){
			Integer b=Character.getNumericValue(t.charAt(i));
			if(b>max){
				max=b;
				index=i;
			}
		}
		if(index!=0 && index!=t.length()){
			t=t.substring(0,index)+t.substring(index+1,t.length());
		}
		else if(index==0){
			t=t.substring(1);
		}
		else{
			t=t.substring(0,index);
		}
		res[i2]=max;
		return t;
	}
}
