package com.yourtion.TinyWeb.Example;

import com.yourtion.TinyWeb.HttpRequest;
import com.yourtion.TinyWeb.TemplateController;
import com.yourtion.TinyWeb.View;

import java.util.*;

/**
 * Created by Yourtion on 9/5/16.
 */
public class GreetingController extends TemplateController {
    private Random random;
    public GreetingController(View view) {
        super(view);
        random = new Random();
    }

    @Override
    public Map<String, List<String>> doRequest(HttpRequest httpRequest) {
        Map<String, List<String>> helloModel =
                new HashMap<String, List<String>>();
        helloModel.put("greetings",
                generateGreetings(httpRequest.getBody()));
        return helloModel;
    }

    private List<String> generateGreetings(String namesCommaSeparated) {
        String[] names = namesCommaSeparated.split(",");
        List<String> greetings = new ArrayList<String>();
        for (String name : names) {
            greetings.add(makeGreeting(name));
        }
        return greetings;
    }

    private String makeGreeting(String name) {
        String[] greetings =
                { "Hello", "Greetings", "Salutations", "Hola" };
        String greetingPrefix = greetings[random.nextInt(4)];
        return String.format("%s, %s", greetingPrefix, name);
    }
}

