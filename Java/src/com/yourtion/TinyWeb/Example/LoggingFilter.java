package com.yourtion.TinyWeb.Example;

import com.yourtion.TinyWeb.Filter;
import com.yourtion.TinyWeb.HttpRequest;

/**
 * Created by Yourtion on 9/5/16.
 */
public class LoggingFilter implements Filter {

    @Override
    public HttpRequest doFilter(HttpRequest request) {
        System.out.println("In Logging Filter - request for path: "
                + request.getPath());
        return request;
    }

}