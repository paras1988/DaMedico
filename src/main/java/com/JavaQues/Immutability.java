package com.JavaQues;

public class Immutability {
	public static void main(final String[] args) {
		final Customer c = Customer.getInstance();

		tryModify(c);
		System.out.println(c.getD().aa);
	}

	private static void tryModify(final Customer c) {
		// c.getD() = 22;
		System.out.println("df");
	}
}

final class Customer {

	// final
	private final Integer a;

	// non final
	private final Address d;

	// make Constructor private
	private Customer(final Integer a, final Address d) {
		this.a = a;
		this.d = d;
	}

	// use factory method for return.
	public static Customer getInstance() {
		final Address abc = new Address();
		return new Customer(34, abc);
	}

	// no setter
	public Address getD() {
		return new Address();
	}

	public Integer getA() { // can return original for immutable(final)
		return a;
	}

}

class Address {
	int aa = 10;
}
