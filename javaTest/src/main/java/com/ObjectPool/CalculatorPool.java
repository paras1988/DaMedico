package com.ObjectPool;


public class CalculatorPool extends ObjectPoolService<Calculator> {

    public CalculatorPool(int minIdle, int maxIdle) {
        super(minIdle, maxIdle);
    }

    @Override
    public Calculator createObject() {
        return new Calculator(created() + 1);
    }
}
