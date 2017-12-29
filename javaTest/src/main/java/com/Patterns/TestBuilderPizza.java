package com.Patterns;

class Pizza12 {
	private String dough = "";
	private String sauce = "";
	private String topping = "";

	public void setDough(final String dough) {
		this.dough = dough;
	}

	public void setSauce(final String sauce) {
		this.sauce = sauce;
	}

	public void setTopping(final String topping) {
		this.topping = topping;
	}
}

/* "Abstract Builder" */
abstract class PizzaBuilder {
	protected Pizza12 pizza;

	public Pizza12 getPizza() {
		return pizza;
	}

	public void createNewPizzaProduct() {
		pizza = new Pizza12();
	}

	public abstract void buildDough();

	public abstract void buildSauce();

	public abstract void buildTopping();
}

/* "ConcreteBuilder" */
class HawaiianPizzaBuilder extends PizzaBuilder {
	@Override
	public void buildDough() {
		pizza.setDough("cross");
	}

	@Override
	public void buildSauce() {
		pizza.setSauce("mild");
	}

	@Override
	public void buildTopping() {
		pizza.setTopping("ham+pineapple");
	}
}

/* "ConcreteBuilder" */
class SpicyPizzaBuilder extends PizzaBuilder {
	@Override
	public void buildDough() {
		pizza.setDough("pan baked");
	}

	@Override
	public void buildSauce() {
		pizza.setSauce("hot");
	}

	@Override
	public void buildTopping() {
		pizza.setTopping("pepperoni+salami");
	}
}

/* "Director" */
class Waiter {
	private PizzaBuilder pizzaBuilder;

	public void setPizzaBuilder(final PizzaBuilder pb) {
		pizzaBuilder = pb;
	}

	public Pizza12 getPizza() {
		return pizzaBuilder.getPizza();
	}

	public void constructPizza() {
		pizzaBuilder.createNewPizzaProduct();
		pizzaBuilder.buildDough();
		pizzaBuilder.buildSauce();
		pizzaBuilder.buildTopping();
	}
}

/* A customer ordering a pizza. */
class BuilderExample {
	public static void main(final String[] args) {
		final Waiter waiter = new Waiter();
		final PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder(); // Like Regulatory
																				// Reporting...
		final PizzaBuilder spicy_pizzabuilder = new SpicyPizzaBuilder();

		waiter.setPizzaBuilder(hawaiian_pizzabuilder);
		waiter.constructPizza();

		final Pizza12 pizza = waiter.getPizza();
	}
}