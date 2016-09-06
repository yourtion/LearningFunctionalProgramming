package com.yourtion.TinyWebDemo;

import com.yourtion.TinyWeb.RenderingStrategy;

import java.util.List;
import java.util.Map;

/**
 * Created by Yourtion on 9/5/16.
 */
public class GreetingRenderingStrategy implements RenderingStrategy {

    @Override
    public String renderView(Map<String, List<String>> model) {
        List<String> greetings = model.get("greetings");
        StringBuffer responseBody = new StringBuffer();
        responseBody.append("<h1>Friendly Greetings:</h1>\n");
        for (String greeting : greetings) {
            responseBody.append(
                    String.format("<h2>%s</h2>\n", greeting));

        }
        return responseBody.toString();
    }
}
