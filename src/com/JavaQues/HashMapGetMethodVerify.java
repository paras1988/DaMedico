package com.JavaQues;

import java.util.HashMap;
public class HashMapGetMethodVerify {

}


/*class Dog{

}

public boolean equals(Object o){
    Cat c=(Cat)o;
    if(this.legs==c.legs)   //if number of legs are equal return true;
        return true;
}
}
Now we get the object from Map

Map animal=new HashMap<Dog,Integer>();
Dod d=new Dog(4);        //constructor taking no. of legs as arg in Dog Class

animal.put(d,1);
Cat c=new Cat(4);        //constructor taking no. of legs as arg in Cat class

int i=animal.get(c);      // This will work as get() uses the Object to retrieve
sysout(i);                //Return 1 as it just check the equality*/



enum AnimalCategory{
	Mammal("4 Legs"),Humans("2 legs"),Aquatic("3 legs");

	String str;
	private AnimalCategory(final String str) {
		this.str=str;
	}

	@Override
	public String toString() {
		return str;
	}
}

