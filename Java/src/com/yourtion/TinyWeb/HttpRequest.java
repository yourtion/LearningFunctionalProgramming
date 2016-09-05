package com.yourtion.TinyWeb;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yourtion on 9/5/16.
 */
public class HttpRequest {
    private Map<String, String> headers;
    private String body;
    private String path;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public String getPath() {
        return path;
    }

    private HttpRequest(Builder builder) {
        this.headers = Collections.unmodifiableMap(builder.headers);
        this.body = builder.body;
        this.path = builder.path;
    }

    public static class Builder {
        private Map<String, String> headers;
        private String body;
        private String path;

        private Builder() {
            headers = new HashMap<String, String>();
        }

        public Builder addHeader(String name, String value) {
            headers.put(name, value);
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static Builder builderFrom(HttpRequest request) {
            Builder builder = new Builder();
            builder.path(request.getPath());
            builder.body(request.getBody());

            Map<String, String> headers = request.getHeaders();
            for (String headerName : headers.keySet())
                builder.addHeader(headerName,
                        headers.get(headerName));

            return builder;
        }
    }
}
