package com.yourtion.Pattern15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yourtion on 01/04/2017.
 */
public class ChainExample {
    public void run() {

        System.out.println("PersonExample");
        ImmutablePerson.Builder b = ImmutablePerson.newBuilder();
        ImmutablePerson p = b.firstName("Peter").lastName("Jones").build();
        System.out.println(p.toString());

        System.out.println("");

        System.out.println("ListExample");
        List<String> names = new ArrayList<String>();
        names.add("Michael Bevilacqua Linn");
        System.out.println(names);
        System.out.println(names.get(0).toUpperCase());
    }
}
