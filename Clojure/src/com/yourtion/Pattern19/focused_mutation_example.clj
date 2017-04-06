(ns com.yourtion.Pattern19.focused-mutation-example)

(def one-million 1000000)
(def five-hundred-thousand 500000)

(defmacro time-runs [fn count]
  `(dotimes [_# ~count]
     (time ~fn)))

(defn test-mutable [count]
  (loop [i 0 s (transient [])]
    (if (< i count)
      (recur (inc i) (conj! s i))
      (persistent! s))))

(defn test-immutable [count]
  (loop [i 0 s []]
    (if (< i count)
      (recur (inc i) (conj s i))
      s)))

(defn make-test-purchase []
  {:store-number (rand-int 100)
   :customer-number (rand-int 100)
   :item-number (rand-int 500)})
(defn infinite-test-purchases []
  (repeatedly make-test-purchase))

(defn immutable-sequence-event-processing [count]
  (let [test-purchases (take count (infinite-test-purchases))]
    (reduce
      (fn [map-of-purchases {:keys [store-number] :as current-purchase}]
        (let [purchases-for-store (get map-of-purchases store-number '())]
          (assoc map-of-purchases store-number
                                  (conj purchases-for-store current-purchase))))
      {}
      test-purchases)))

(defn mutable-sequence-event-processing [count]
  (let [test-purchases (take count (infinite-test-purchases))]
    (persistent! (reduce
                   (fn [map-of-purchases {:keys [store-number] :as current-purchase}]
                     (let [purchases-for-store (get map-of-purchases store-number '())]
                       (assoc! map-of-purchases store-number
                               (conj purchases-for-store current-purchase))))
                   (transient {})
                   test-purchases))))
(defn run []
  (println "Immutable :")
  (time-runs (test-immutable one-million) 5)
  (println "")

  (println "Mutable :")
  (time-runs (test-mutable one-million) 5)
  (println "")

  (println "fiveTestPurchases :")
  (println "Immutable :")
  (time-runs (immutable-sequence-event-processing five-hundred-thousand) 5)
  (println "Mutable :")
  (time-runs (mutable-sequence-event-processing five-hundred-thousand) 5)

  (println ""))
