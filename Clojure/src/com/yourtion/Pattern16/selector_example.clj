(ns com.yourtion.Pattern16.selector-example)

(defn selector [& path]
  {:pre [(not (empty? path))]}
  (fn [ds] (get-in ds path)))

(defn run []
  (println "SelectorExample : ")
  (def simple-person {:name "Yourtion Guo"})
  (def name (selector :name))
  (println "name from simplePerson: " (name simple-person))
  (def more-complex-person {:name {:first "Yourtion" :last "Guo"}})
  (def first-name (selector :name :first))
  (println "firstName from moreComplexPerson: " (first-name more-complex-person))
  (def middle-name (selector :name :middle))
  (println "middleName from moreComplexPerson: " (middle-name more-complex-person))
  (println ""))

