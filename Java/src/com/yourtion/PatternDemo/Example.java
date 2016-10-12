package com.yourtion.PatternDemo;

import com.yourtion.Pattern06.FullGradeReporter;
import com.yourtion.Pattern06.PlusMinusGradeReporter;

/**
 * Created by Yourtion on 9/7/16.
 */
public class Example {

    public static void main(String[] args){
        System.out.println("Template Example : \n");

        System.out.println("FullGradeReporter : ");
        new FullGradeReporter().run();
        System.out.println("");

        System.out.println("PlusMinusGradeReporter :");
        new PlusMinusGradeReporter().run();
        System.out.println("");


    }
}
