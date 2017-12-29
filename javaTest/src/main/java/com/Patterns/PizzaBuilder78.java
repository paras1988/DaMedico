package com.Patterns;

public class PizzaBuilder78 {
	public static void main(String[] args) {

		Pizza p=new Pizza.Builder().setTopping(Topping78.Tomato).setSize(Size.Large).build();
		System.out.println(p.getPrice());
	}
}

class Pizza{

	Topping78 topping;
	Size size;
	int price;

	public Pizza(Builder b) {
		this.topping=b.topping;
		this.size=b.size;
		this.price=b.price;
	}
	public int getPrice() {
		return price;
	}
	public static class Builder {
		Topping78 topping;
		Size size;
		int price=0;

		static Builder b=new Builder();

		public Builder setTopping(Topping78 tomato) {
			b.topping=tomato;
			b.price=b.price+tomato.getPrice();
			return b;
		}
		public Builder setSize(Size large) {
			b.size=large;
			b.price=b.price+large.getPrice();
			return b;
		}
		public Pizza build() {
			return new Pizza(b);
		}
	}
}

enum Topping78{
	Tomato{

		@Override
		protected int getPrice() {
			// TODO Auto-generated method stub
			return 10;
		}

	},Onion{

		@Override
		protected int getPrice() {
			// TODO Auto-generated method stub
			return 20;
		}

	};

	protected abstract int getPrice();
}

enum Size{
	Large {
		@Override
		protected int getPrice() {
			return 30;
		}
	},Small {
		@Override
		protected int getPrice() {
			return 40;
		}
	};

	protected abstract int getPrice();
}