package com.Patterns;

public class ActualBuilder {

	public static void main(String[] args) {
		IWheels w=WheelsFactory.getInstance(Wheels.Two_Wheeler);
		Vehicle v=new Vehicle.VehicleBuilder().setWheels(w).setColor(Color.RED).build();
		System.out.println(v);
	}
}

enum Wheels{
	Two_Wheeler,
	Four_Wheeler
}
enum Fuel_type{
	LPG,
	Diesel
}
enum Color{
	RED,
	BLACK
}

class Vehicle{

	public Vehicle(IWheels wheel, Color color) {
		this.wheel=wheel;
		this.color=color;
	}

	IWheels wheel;
	Fuel_type fuel;
	Color color;

	public static class VehicleBuilder{

		IWheels wheel;
		Fuel_type fuel;
		Color color;

		public VehicleBuilder setWheels(IWheels wheels) {
			this.wheel=wheels;
			return this;
		}

		public VehicleBuilder setColor(Color color) {
			this.color=color;
			return this;
		}

		public Vehicle build(){
			Vehicle v=new Vehicle(wheel,color);
			return v;
		}
	}
}

class WheelsFactory{
	public static IWheels getInstance(Wheels wheel){
		switch(wheel){
		case Four_Wheeler:
			return new FourWheeler();
		case Two_Wheeler:
			return new TwoWheeler();
		}
		return null;
	}
}

interface IWheels{}
class TwoWheeler implements IWheels{}
class FourWheeler implements IWheels{}
