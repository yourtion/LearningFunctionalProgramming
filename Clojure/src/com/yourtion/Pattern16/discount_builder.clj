(ns com.yourtion.Pattern16.discount-builder)

(defn discount [percentage]
  {:pre [(and (>= percentage 0) (<= percentage 100))]}
  (fn [price] (- price (* price percentage 0.01))))

(defn run []
  (println "DiscountBuilder")
  (println  "200 50% discount -> " ((discount 50) 200))
  (println  "200 0% discount -> " ((discount 0) 200))
  (println  "200 100% discount -> " ((discount 100) 200))
  (def twenty-five-percent-off (discount 25))
  (println "Multi1 : "  (apply + (map twenty-five-percent-off [100.0 25.0 50.0 25.0])))
  (println "Multi2 : "  (apply + (map twenty-five-percent-off [75.0 25.0])))
  (println ""))
