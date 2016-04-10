package com.JavaQues;

public class MillyAndHerClassMates_Hacker {

	public static void main(String[] args) {

		String mline="1 2 3 4 8 7 6 5";
		String[] str = mline.split("\\s+");
		Integer[] input=new Integer[str.length];
		int t=0;
		for(String a:str){
			input[t]=Integer.parseInt(a);
			t++;
		}

		if(!isIncreasing(input)){
			int i=1;
			for(i=1;i<input.length;i++){

				if(input[i]>input[i-1]){

				}else{
					break;
				}
			}

			int j=i;
			for(j=i;j<input.length;j++){
				if(input[j]<input[j-1]){

				}else{
					break;
				}
			}

			int start=i-1;
			int end=j-1;

			int c=0;

			Integer[] newarr=new Integer[input.length];
			for(int a=0;a<input.length;a++){
				if(a<start || a>end){
					newarr[a]=input[a];
				}else{
					newarr[a]=input[end-c];
					c++;
				}
			}
			start=start+1;
			end=end+1;



			if(isIncreasing(newarr)){
				System.out.println(start+" "+end);
			}else{
				System.out.println("-1 -1");
			}

		}else{
			System.out.println("-1 -1");
		}
	}

	private static boolean isIncreasing(Integer[] newarr) {
		for(int i=1;i<newarr.length;i++){
			if(newarr[i]<newarr[i-1]){
				return false;
			}
		}
		return true;
	}

}
