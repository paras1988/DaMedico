package com.JavaQues;

import java.io.IOException;

public class EdgeVerverQues1 {

	/*public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String line = br.readLine();
		int num = -1000000;//Integer.parseInt(line);

		int temp=Math.abs(num);
		int temp2=Math.abs(num);
		int res=0;
		for(int i=1;i<temp;i++){
			for(int j=temp;j>1;j--){
				if(Math.pow(j,i)==temp2 && i>res){
					res=i;
					break;
				}
			}
			temp=temp/i;
		}

		if(num<0 && res%2==0){
			System.out.println(1);
		}
		else{
			System.out.println(res);
		}
	}*/

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String line = br.readLine();
		int num =4;//Integer.parseInt(line);

		int temp=num;
		int res=0;
		if(num>0){
			for(int i=1;i<temp;i++){
				for(int j=temp;j>1;j--){
					if(Math.pow(j,i)==num && i>res){
						res=i;
						break;
					}
				}
				temp=temp/i;
			}
		}else{
			for(int i=1;i<Math.abs(temp);i++){
				for(int j=temp;j<1;j++){
					if(Math.pow(j,i)==num && i>res){
						res=i;
						break;
					}
				}
				temp=temp/i;
			}
		}


		if(Math.abs(num)==1){
			System.out.println(1);
		}else{
			System.out.println(res);
		}
	}
}
