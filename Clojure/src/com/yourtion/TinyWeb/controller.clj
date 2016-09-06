(ns com.yourtion.TinyWeb.controller
    (:import (com.yourtion.TinyWeb HttpRequest$Builder RenderingException)))

(defn test-controller [http-request]
      {:name (http-request :body)})

(def test-builder (HttpRequest$Builder/newBuilder))

(def test-http-request (.. test-builder (body "Mike") (path "/say-hello") build))

(defn test-controller-with-map [http-request]
      {:name (http-request :body)})

(defn test-view [model]
      (str "<h1>Hello, " (model :name) "</h1>"))

(defn- render [view model]
       (try
         (view model)
         (catch Exception e (throw (RenderingException. e)))))
