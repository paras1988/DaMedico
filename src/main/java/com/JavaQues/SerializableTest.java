package com.JavaQues;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest {
	public static void main(final String[] args) throws IOException, ClassNotFoundException {

		final Dog d=new Dog();

		final FileOutputStream fout = new FileOutputStream("C:\\Users\\43901757\\Desktop\\address.ser");
		final ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(d);

		final FileInputStream fin = new FileInputStream("C:\\Users\\43901757\\Desktop\\address.ser");
		final ObjectInputStream iis = new ObjectInputStream(fin);

		final Dog n=(Dog)iis.readObject();


		System.out.println(n.c.colVal);
	}
}

class Dog implements Serializable{
	Collar c=new Collar(23);
}

class Collar implements Serializable{
	int colVal=10;
	Collar(final int val){
		colVal=val;
	}
}
