(ns com.yourtion.Pattern18.lazy-sequence-example)

(def integers (range Integer/MAX_VALUE))

(def randoms (repeatedly (fn [] (rand-int Integer/MAX_VALUE))))

(defn get-page [page-num]
  (cond
    (= page-num 1) "Page1"
    (= page-num 2) "Page2"
    (= page-num 3) "Page3"
    :default nil))

(defn paged-sequence [page-num]
  (let [page (get-page page-num)]
    (when page
      (cons page (lazy-seq (paged-sequence (inc page-num)))))))

(defn paged-sequence-print [page-num]
  (let [page (get-page page-num)]
    (when page
      (println (str "Realizing " page))
      (cons page (lazy-seq (paged-sequence (inc page-num)))))))

(defn print-num [num] (print (str num " ")))

(def print-hellos (repeatedly (fn [] (println "hello, world"))))

(defn run []
  (println "Some Ints :")
  (println (take 5 integers))
  (println "")

  (println "aFewRabdom :")
  (println (take 5 randoms))
  (println "")

  (println "aFewMoreRabdom :")
  (println (take 6 randoms))
  (println "")

  (println "print Hello :")
  (println (take 5 print-hellos))
  (println "")

  (println "pages :")
  (println (paged-sequence 1))
  (println (take 2 (paged-sequence 1)))

  (println ""))
