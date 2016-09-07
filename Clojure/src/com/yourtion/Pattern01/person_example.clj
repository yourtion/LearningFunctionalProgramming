(ns com.yourtion.Pattern01.person-example)

(def p1 {:first-name "Michael" :last-name "Bevilacqua"})
(def p2 {:first-name "Pedro" :last-name "Vasquez"})
(def p3 {:first-name "Robert" :last-name "Aarons"})

(def people [p1 p2 p3])


(def sorted_people (sort (fn [p1 p2] (compare (p1 :last-name) (p2 :last-name))) people))

;(sort (fn [p1 p2] (compare (p1 :first-name) (p2 :first-name))) people)

(defn run [] (doseq [col sorted_people :when (not= col \B)]
            (println (col :first-name) (col :last-name))))
