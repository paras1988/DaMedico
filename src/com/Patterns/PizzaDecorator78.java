package com.Patterns;

public class PizzaDecorator78 {
	public static void main(String[] args) {
		System.out.println(new TomatoToppingDecorator(new TomatoToppingDecorator
				(new OnionToppingDecorator(new SimplePizza()))).cost());
	}
}
interface BasePizza{
	int cost();
}


abstract class ToppingDecorator implements BasePizza{
	BasePizza bp;
}

class TomatoToppingDecorator extends ToppingDecorator{
	public TomatoToppingDecorator(BasePizza basePizza) {
		bp=basePizza;
	}

	@Override
	public int cost() {
		return bp.cost()+20;
	}
}
class OnionToppingDecorator extends ToppingDecorator{
	public OnionToppingDecorator(BasePizza basePizza) {
		bp=basePizza;
	}

	@Override
	public int cost() {
		return bp.cost()+10;
	}
}

class SimplePizza implements BasePizza{
	public SimplePizza() {

	}

	@Override
	public int cost() {
		return 500;
	}
}

class AdvancePizza implements BasePizza{
	public AdvancePizza() {

	}

	@Override
	public int cost() {
		return 1000;
	}
}