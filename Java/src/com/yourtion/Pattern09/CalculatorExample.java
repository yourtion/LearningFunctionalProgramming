package com.yourtion.Pattern09;

/**
 * Created by Yourtion on 28/11/2016.
 */
public class CalculatorExample {

    public void run() {
        System.out.println("Without Logging :");

        CalculatorImpl cal1 = new CalculatorImpl();
        System.out.println(cal1.Add(1, 2));
        System.out.println(cal1.Subtract(4,3));
        System.out.println(cal1.Divide(6,2));
        System.out.println(cal1.Multiply(2,3));

        System.out.println("");
        System.out.println("Logging :");

        CalculatorImpl cal2 = new LoggingCalculator();
        System.out.println(cal2.Add(1,2));
        System.out.println(cal2.Subtract(4,3));
        System.out.println(cal2.Divide(6,2));
        System.out.println(cal2.Multiply(2,3));

    }
}
