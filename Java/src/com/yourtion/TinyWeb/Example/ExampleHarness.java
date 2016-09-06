package com.yourtion.TinyWeb.Example;

import com.yourtion.TinyWeb.*;

import java.util.*;

/**
 * Created by Yourtion on 9/5/16.
 */
public class ExampleHarness {

    public static void main(String[] args){

        TinyWeb tinyWeb = new TinyWeb(makeRoutes(), makeFilters());

        HttpRequest testRequest = HttpRequest.Builder.newBuilder()
                .path("greeting/")
                .body("Mike,Joe,John,Steve")
                .addHeader("X-Example", "exampleHeader")
                .build();

        HttpResponse testResponse = tinyWeb.handleRequest(testRequest);

        System.out.println("responseCode: " + testResponse.getResponseCode());
        System.out.println("responseBody: ");
        System.out.println(testResponse.getBody());
    }

    private static Map<String, Controller> makeRoutes(){
        GreetingRenderingStrategy viewRenderer = new GreetingRenderingStrategy();
        StrategyView greetingView = new StrategyView(viewRenderer);
        GreetingController greetingController = new GreetingController(greetingView);

        Map<String, Controller> controllers = new HashMap<String, Controller>();
        controllers.put("greeting/", greetingController);
        return Collections.unmodifiableMap(controllers);
    }

    private static List<Filter> makeFilters(){
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(new LoggingFilter());
        return filters;
    }
}
