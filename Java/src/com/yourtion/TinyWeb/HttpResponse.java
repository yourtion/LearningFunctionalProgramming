package com.yourtion.TinyWeb;

/**
 * Created by Yourtion on 9/5/16.
 */
public class HttpResponse {
    private final String body;
    private final Integer responseCode;

    public String getBody() {
        return body;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    private HttpResponse(Builder builder) {
        body = builder.body;
        responseCode = builder.responseCode;
    }

    public static class Builder {
        private String body;
        private Integer responseCode;

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder responseCode(Integer responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public HttpResponse build() {
            return new HttpResponse(this);
        }

        public static Builder newBuilder() {
            return new Builder();
        }
    }
}
