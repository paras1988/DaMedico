package com.Patterns;

public class Builder {
	public static void main(final String[] args) {
		final Manufacturer m = new Manufacturer();
		final MobilePhone mP = new Iphone();
		final MobilePhone newmobile = m.construct(mP);

		System.out.println(newmobile.battery() + " " + newmobile.screen());
	}
}

class Manufacturer {
	MobilePhone construct(final MobilePhone m) {
		m.screen();
		m.battery();
		return m;
	}
}

interface MobilePhone {
	Battery battery();

	Screen screen();
}

class Iphone implements MobilePhone {
	@Override
	public Battery battery() {
		return Battery.a4300v;
	}

	@Override
	public Screen screen() {
		return Screen.TOUCH;
	}
}

class WindowsPhone implements MobilePhone {
	@Override
	public Battery battery() {
		return Battery.a4300v;
	}

	@Override
	public Screen screen() {
		return Screen.NON_TOUCH;
	}
}

enum Battery {
	a4300v, b2400v;
}

enum Screen {
	TOUCH, NON_TOUCH;
}