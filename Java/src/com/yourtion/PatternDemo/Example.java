package com.yourtion.PatternDemo;

import com.yourtion.Pattern01.PersonExample;
import com.yourtion.Pattern01.PersonExampleEx;
import com.yourtion.Pattern02.PersonExampleCC;

/**
 * Created by Yourtion on 9/7/16.
 */
public class Example {

    public static void main(String[] args){
        System.out.println("PersonExample : \n");
        new PersonExample().run();
        System.out.println("");

        System.out.println("PersonExampleEx : \n");
        new PersonExampleEx().run();
        System.out.println("");

        System.out.println("PersonExampleCC : \n");
        new PersonExampleCC().run();
    }
}
