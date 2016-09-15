(ns com.yourtion.Pattern01.person-example-ex)

(def p1 {:first-name "Aaron" :middle-name "Jeffrey" :last-name "Smith"})
(def p2 {:first-name "Aaron" :middle-name "Bailey" :last-name "Zanthar"})
(def p3 {:first-name "Brian" :middle-name "Adams" :last-name "Smith"})
(def people [p1 p2 p3])
(defn complicated-sort [p1 p2]
  (let [first-name-compare (compare (p1 :first-name) (p2 :first-name))
        middle-name-compare (compare (p1 :middle-name) (p2 :middle-name))
        last-name-compare (compare (p1 :last-name) (p2 :last-name))]
    (cond
      (not (= 0 first-name-compare)) first-name-compare
      (not (= 0 last-name-compare)) last-name-compare
      :else middle-name-compare)))

(def sorted_people (sort complicated-sort people))

(defn run [] (doseq [col sorted_people :when (not= col nil)]
               (println (col :first-name) (col :middle-name) (col :last-name))))
