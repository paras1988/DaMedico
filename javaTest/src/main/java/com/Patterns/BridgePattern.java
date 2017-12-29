package com.Patterns;

public class BridgePattern {
	public static void main(final String[] args) {
		final Switch fancySwitch = new FancySwitch();
		final Switch normalSwitch = new NormalSwitch();

		final IEquipment fan = new Fan();
		final IEquipment light = new Light();

		fancySwitch.equipment = fan;
		normalSwitch.equipment = light;

		fancySwitch.on();
		normalSwitch.on();
	}
}

class Switch {
	IEquipment equipment;

	void on() {
		equipment.powerOn();
	}

	void off() {
		equipment.powerOff();
	}
}

class NormalSwitch extends Switch {
}

class FancySwitch extends Switch {
}

interface IEquipment {

	void powerOn();

	void powerOff();
}

class Fan implements IEquipment {

	@Override
	public void powerOn() {
		System.out.println("Fan is on");
	}

	@Override
	public void powerOff() {
		System.out.println("Fan is off");
	}
}

class Light implements IEquipment {

	@Override
	public void powerOn() {
		System.out.println("Light is on");
	}

	@Override
	public void powerOff() {
		System.out.println("Light is off");
	}
}