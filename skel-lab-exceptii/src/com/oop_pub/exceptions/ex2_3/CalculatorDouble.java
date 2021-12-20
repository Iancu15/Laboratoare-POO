package com.oop_pub.exceptions.ex2_3;

import java.util.Collection;

public class CalculatorDouble implements Calculator {

    @Override
    public Double add(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }

        Double sum = nr1 + nr2;
        if (sum.equals(Double.POSITIVE_INFINITY)) {
            throw new OverflowException();
        }

        if (sum.equals(Double.NEGATIVE_INFINITY)) {
            throw new UnderflowException();
        }

        return sum;
    }

    @Override
    public Double divide(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }

        if (nr2.equals(0.0)) {
            throw new DivideByZeroException();
        }

        return nr1 / nr2;
    }

    // constructorul Double(int) e deprecated, it works don't care
    @SuppressWarnings("deprecation")
    @Override
    public Double average(Collection<Double> numbers) {
        if (numbers == null) {
            throw new NullParameterException();
        }

        Double sum = 0.0;
        for (Double number : numbers) {
            sum = add(sum, number);
        }

        return divide(sum, new Double(numbers.size()));
    }

}
