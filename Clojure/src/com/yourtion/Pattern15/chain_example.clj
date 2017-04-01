(ns com.yourtion.Pattern15.chain-example
  (:require [clojure.string :as string]))

(def my-name "michael bevilacqua linn")
(defn get-intitals []
  (apply str (map first (string/split my-name #" "))))

(def v1
  {:title "Pianocat Plays Carnegie Hall"
   :type :cat
   :length 300})

(def v2
  {:title "Paint Drying"
   :type :home-improvement
   :length 600})

(def v3
  {:title "Fuzzy McMittens Live At The Apollo"
   :type :cat
   :length 200})

(def videos [v1 v2 v3])

(defn cat-time [videos]
  (apply +
         (map :length
              (filter (fn [video] (= :cat (:type video))) videos))))
(defn more-cat-time [videos]
  (->> videos
       (filter (fn [video] (= :cat (:type video))))
       (map :length)
       (apply +)))

(defn run []
  (println "get-intitals")
  (def my-name "michael bevilacqua linn")
  (defn get-intitals []
    (apply str (map first (string/split my-name #" "))))
  (println (get-intitals) )
  (println "")
  (println "cat-time:" (cat-time videos))
  (println "")
  (println (-> 4 (- 2) (- 2)))
  (println (->> 4 (- 2) (- 2)))
  (println "")
  (println "more-cat-time:" (more-cat-time videos))
  (println ""))
