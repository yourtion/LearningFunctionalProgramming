(ns com.yourtion.Pattern08.person-example
  (:require [clojure.string :as string]))

(def null-person {:first-name "John" :last-name "Doe"})
(defn fetch-person [people id]
  (get id people null-person))

(defn person-greeting [person]
  (if person
    (->> (:first-name person)
         string/capitalize
         (str "Hello, "))
    "Hello, John"))

(defn build-person [first-name last-name]
  (if (and first-name last-name)
    {:first-name first-name :last-name last-name}
    {:first-name "John" :last-name "Doe"}))

(defn run []
  (println "BuildPerson : ")
  (println "Not null: " (build-person "Yourtion" "Guo"))
  (println "Null first name: " (build-person nil "Guo"))
  (println "Null last name: " (build-person "Yourtion" nil))
  (println "")
  (println "FetchPerson : ")
  (def people {1 {:first-name "Yourtion" :last-name "Guo"}})
  (println "Not null: " (fetch-person 1 people))
  (println "Null: " (fetch-person 2 people)))
