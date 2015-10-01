package com.Patterns;

public class FactoryPattern {
	public static void main(final String[] args) {

		final IUser user = UserFactory.getUser(USER_ENUM.NO);
		user.setDiscount(34);
	}
}

interface IUser {
	int setDiscount(int discount);
}

class Premium implements IUser {
	int discount;

	@Override
	public int setDiscount(final int discounta) {
		discount = discounta;
		return 0;
	}
}

class Normal implements IUser {
	int discount;

	@Override
	public int setDiscount(final int discounta) {
		discount = discounta;
		return 0;
	}
}

class Other implements IUser {
	int discount;

	@Override
	public int setDiscount(final int discounta) {
		discount = discounta;
		return 0;
	}
}

class UserFactory {
	static IUser getUser(final USER_ENUM user) {
		switch (user) {
			case PR:
				return new Premium();
			case NO:
				return new Normal();
			default:
				return new Other();
		}
	}
}

enum USER_ENUM {
	PR, NO, OT;

}