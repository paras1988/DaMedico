package com.Patterns;

/*
 * Example: Reader like InputStream or BufferedStream
 * int cost=0
 * if(Pizza is Normal){
 * cost=NBase cost
 * if(topping is cheese){
 * cost=cost+cheese cost
 * }
 * if(topping is tomato){
 * cost=cost+tomato cost
 * }
 * }
 * else if(Pizza is Advance){
 * same as above....
 * }
 */

public class Decorator {
	public static void main(final String[] args) {
		final MyPizza nPizza = PizzaFactory.getPizza(PizzaType.N);

		final Topping cheesePizza = new CheeseTopping(nPizza);
		final Topping tomatoPizza = new TomatoTopping(cheesePizza);

		System.out.println(nPizza.cost() + "::" + cheesePizza.cost() + "::" + tomatoPizza.cost()
				+ ":" + nPizza.cost());

		System.out.println(new TomatoTopping(new CheeseTopping(PizzaFactory.getPizza(PizzaType.N)))
				.cost());
	}
}

interface MyPizza {
	public int cost();
}

class NPizza implements MyPizza {
	int cost;

	public NPizza() {
		cost = 100;
	}

	@Override
	public int cost() {

		return cost;
	}

}

class APizza implements MyPizza {
	@Override
	public int cost() {

		return 1000;
	}
}

abstract class Topping implements MyPizza {
	MyPizza pizza;

	@Override
	abstract public int cost();
}

class CheeseTopping extends Topping {

	CheeseTopping(final MyPizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int cost() {
		return (pizza.cost() + 20);
	}
}

class TomatoTopping extends Topping {
	TomatoTopping(final MyPizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int cost() {
		return pizza.cost() + 50;
	}
}

enum PizzaType {
	N, A;
}

class PizzaFactory {
	static MyPizza getPizza(final PizzaType pizzaType) {
		switch (pizzaType) {
			case N:
				return new NPizza();
			case A:
				return new APizza();
			default:
				return null;
		}
	}
}
