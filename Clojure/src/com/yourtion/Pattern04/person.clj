(ns com.yourtion.Pattern04.person)

(def p
  {:first-name "John"
   :middle-name "Quincy"
   :last-name "Adams"})

(defrecord Cat [color name])

(defrecord Dog [color name])

(defprotocol NoiseMaker
  (make-noise [this]))

(defrecord NoisyCat [color name]
  NoiseMaker
  (make-noise [this] (str (:name this) " meows!")))

(defrecord NoisyDog [color name]
  NoiseMaker
  (make-noise [this] (str (:name this) " barks!")))

(def cat1 (Cat. "Calico" "Fuzzy McBootings"))
(def dog1 (Dog. "Brown" "Brown Dog"))

(def noisy-cat (NoisyCat. "Calico" "Fuzzy McBootings"))
(def noisy-dog (NoisyDog. "Brown" "Brown Dog"))

(defn run []
  (println "# use map")
  (println (p :first-name) (p :middle-name) (p :last-name))
  (println "Upper: " (into {} (for [[k, v] p] [k (.toUpperCase v)])))
  (println)

  (println "# use record")
  (println "cat: " (:name cat1))
  (println "dog: " (:name dog1))

  (println "noisy-cat: " (:name noisy-cat))
  (println "noisy-dog: " (:name noisy-dog))
  (println (make-noise noisy-cat))
  (println (make-noise noisy-dog))
  )
