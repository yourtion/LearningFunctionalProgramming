(ns com.yourtion.Pattern07.people-collector-example)

(defn first-name-valid? [person]
  (not (nil? (:first-name person))))

(defn full-name-valid? [person]
  (and
    (not (nil? (:first-name person)))
    (not (nil? (:middle-name person)))
    (not (nil? (:last-name person)))))

(defn person-collector [valid?]
  (let [valid-people (atom [])]
    (fn [person]
      (if (valid? person)
        (swap! valid-people conj person))
      @valid-people)))


(def p1 {:first-name "Yourtion" :middle-name nil :last-name "Guo"})
(def p2 {:first-name "John" :middle-name "Quincy" :last-name "Adams"})
(def p3 {:first-name nil :middle-name "John" :last-name "Adams"})
(def p4 {:first-name nil :middle-name nil :last-name nil})

(def c1 (person-collector first-name-valid?))
(def c2 (person-collector full-name-valid?))
(c1 p1)
(c1 p2)
(c1 p3)
(def res1 (c1 p4))
(c2 p1)
(c2 p2)
(c2 p3)
(def res2 (c2 p4))

(defn run []
  (println "FirstNameValidator Collector list  ")
  (println res1)
  (println "")
  (println "FullNameValidator Collector list ")
  (println res2))
