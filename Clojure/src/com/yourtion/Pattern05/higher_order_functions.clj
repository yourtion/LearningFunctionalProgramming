(ns com.yourtion.Pattern05.higher-order-functions)

(defn sum-sequence [s]
  {:pre [(not (empty? s))]}
  (reduce + s))

(defn prepend-hello [names]
  (map (fn [name] (str "Hello, " name)) names))

(def vowel? #{\a \e \i \o \u})
(defn vowels-in-word [word]
  (set (filter vowel? word)))

(def name-list ["Yourtion", "Sophia"])

(defn run []
  (println "vowelsInWord: " (vowels-in-word "Yourtion"))
  (println)
  (println "person: " name-list)
  (println "prependHello: " (prepend-hello name-list))
  (println)
  (println "sumSequence: " (sum-sequence [1 2 3 4 5])))
