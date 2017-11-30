package com.design;

public class CompositionOverInheritance {
	public static void main(String[] args) {
		Dog d=new Dog();
		//2.Inheritance : It will change
		d.peel();


		Dog2 d2=new Dog2();
		//4.It will not change..
		d2.peel();
	}
}

class Animal{
	//1.Check if this function changes.
	int peel(){
		return 0;
	}
}

class Dog extends Animal{}

class Dog2{
	Animal a=new Animal();


	int peel(){
		//3.Composition it will change..
		return a.peel();
	}
}