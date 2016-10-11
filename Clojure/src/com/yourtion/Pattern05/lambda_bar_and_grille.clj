(ns com.yourtion.Pattern05.lambda-bar-and-grille)

(def close-zip? #{19123 19103})

(defn generate-greetings [people]
  (for [{:keys [name address]} people :when (close-zip? (address :zip-code))]
    (str "Hello, " name ", and welcome to the Lambda Bar And Grille!")))

(defn print-greetings [people]
  (doseq [{:keys [name address]} people :when (close-zip? (address :zip-code))]
    (println (str "Hello, " name ", and welcome to the Lambda Bar And Grille!"))))

(def p1 {:name "Yourtion1", :address {:zip-code 19123}})
(def p2 {:name "Yourtion2", :address {:zip-code 19103}})
(def p3 {:name "Yourtion3", :address {:zip-code 19129}})
(def p4 {:name "Yourtion4", :address {:zip-code 19103}})
(def p5 {:name "Yourtion5", :address {:zip-code 19111}})
(def people [p1 p2 p3 p4 p5])

(defn run []
  (println "All person: " people)
  (println generate-greetings people)
  (println "-------------")
  (print-greetings people))
