(ns com.yourtion.Pattern16.partial-examples)

(defn add-two-ints [int-one int-two] (+ int-one int-two))

(defn tax-for-state [state amount]
  (cond
    (= :ny state) (* amount 0.0645)
    (= :pa state) (* amount 0.045)))

(defn run []
  (println "PartialExamples :")
  (def add-fourty-two (partial add-two-ints 42))
  (println "100 addFortyTwo: " (add-fourty-two 100))
  (def ny-tax (partial tax-for-state :ny))
  (println "nyTax 100 : " (ny-tax 100))
  (def pa-tax (partial tax-for-state :pa))
  (println "paTax 100 : " (pa-tax 100))
  (println ""))
