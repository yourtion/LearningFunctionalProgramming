(ns com.yourtion.PatternDemo.example
  (:require [com.yourtion.Pattern01.person-example :as p1])
  (:require [com.yourtion.Pattern01.person-example-ex :as p2]))

(println "PersonExample :")
(p1/run)
(println)

(println "PersonExampleEx :")
(p2/run)
