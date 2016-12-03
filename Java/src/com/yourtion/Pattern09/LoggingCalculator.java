package com.yourtion.Pattern09;

/**
 * Created by Yourtion on 28/11/2016.
 */
public class LoggingCalculator extends CalculatorImpl {

    @Override
    public int Add(int a, int b) {
        int result = super.Add(a, b);
        System.out.println("Result is: " + result);
        return result;
    }

    @Override
    public int Subtract(int a, int b) {
        int result = super.Subtract(a, b);
        System.out.println("Result is: " + result);
        return result;
    }

    @Override
    public int Divide(int a, int b) {
        int result = super.Divide(a, b);
        System.out.println("Result is: " + result);
        return result;
    }

    @Override
    public int Multiply(int a, int b) {
        int result = super.Multiply(a, b);
        System.out.println("Result is: " + result);
        return result;
    }
}
