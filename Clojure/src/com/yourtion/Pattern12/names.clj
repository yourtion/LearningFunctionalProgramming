(ns com.yourtion.Pattern12.names)

(defn make-people [first-names last-names]
  (loop [first-names first-names last-names last-names people []]
    (if (seq first-names)
      (recur
        (rest first-names)
        (rest last-names)
        (conj
          people
          {:first (first first-names) :last (first last-names)}))
      people)))

(defn shorter-make-people [first-names last-names]
  (for [[first last] (partition 2 (interleave first-names last-names))]
    {:first first :last last}))

(defn run []
  (println "Moke : ")
  (println (make-people ["Yourtion1", "Yourtion2"] ["Guo1", "Guo2"]))
  (println (shorter-make-people ["Yourtion1", "Yourtion2"] ["Guo1", "Guo2"]))
  (println ""))
