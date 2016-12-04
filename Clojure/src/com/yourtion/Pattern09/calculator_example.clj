(ns com.yourtion.Pattern09.calculator-example)

(defn add [a b] (+ a b))
(defn subtract [a b] (- a b))
(defn multiply [a b] (* a b))
(defn divide [a b] (/ a b))

(defn make-logger [calc-fn]
  (fn [a b]
    (let [result (calc-fn a b)]
      (println (str "Result is: " result))
      result)))

(def logging-add (make-logger add))
(def logging-subtract (make-logger subtract))
(def logging-multiply (make-logger multiply))
(def logging-divide (make-logger divide))

(defn run []
  (println "Without Logging : ")
  (println (add 1 2))
  (println (subtract 4 3))
  (println (divide 6 2))
  (println (multiply 2 3))

  (println "")
  (println "Logging : ")

  (println (logging-add 1 2))
  (println (logging-subtract 4 3))
  (println (logging-divide 6 2))
  (println (logging-multiply 2 3)))