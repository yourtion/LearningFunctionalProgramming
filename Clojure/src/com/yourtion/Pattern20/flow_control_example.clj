(ns com.yourtion.Pattern20.flow-control-example)

(defmacro make-logger [name form]
  `(defn ~name []
     (println (str "Calling " ~name))
     ~form))

(defn choose [num first second third]
  (cond
    (= 1 num) (first)
    (= 2 num) (second)
    (= 3 num) (third)))

(defmacro simpler-choose [num first second third]
  `(cond
     (= 1 ~num) ~first
     (= 2 ~num) ~second
     (= 3 ~num) ~third))

(defn time-run [to-time]
  (let [start (System/currentTimeMillis)]
    (to-time)
    (- (System/currentTimeMillis) start)))

(defmacro avg-time [times to-time]
  `(let [total-time#
         (apply + (for [_# (range ~times)] (time-run (fn [] ~to-time))))]
     (float (/ total-time# ~times))))

(defn avg-time-fn [times to-time]
  (let [total-time
        (apply + (for [_ (range times)] (time-run to-time)))]
    (float (/ total-time times))))

(let
  [total-time
   (apply + (for [_ (range 5)] (time-run (fn [] (Thread/sleep 100)))))]
  (float (/ total-time 5)))

(defn run []
  (println "choose :")
  (choose 2
          (fn [] (println "hello, world"))
          (fn [] (println "goodbye, cruel world"))
          (fn [] (println "meh, indifferent world")))
  (println "")

  (println "simpler-choose :")
  (simpler-choose 2
                  (println "hello, world")
                  (println "goodbye, cruel world")
                  (println "meh, indifferent world"))
  (println "")

  (println "avg-time :")
  (println (avg-time 5 (Thread/sleep 1000)))
  
  (println ""))
