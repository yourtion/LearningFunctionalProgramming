(ns com.yourtion.Pattern10.visitor-example)

(defprotocol NameExtractor
  (extract-name [this] "Extracts a name from a person."))

(defrecord SimplePerson [first-name last-name house-num street])

(extend-type SimplePerson
  NameExtractor
  (extract-name [this]
    (str (:first-name this) " " (:last-name this))))

(defrecord ComplexPerson [name address]
  NameExtractor
  (extract-name [this]
    (str (-> this :name :first) " " (-> this :name :last))))

(defprotocol
  AddressExtractor
  (extract-address [this] "Extracts and address from a person."))

(extend-type SimplePerson
  AddressExtractor
  (extract-address [this]
    (str (:house-num this) " " (:street this))))

(extend-type ComplexPerson
  AddressExtractor
  (extract-address [this]
    (str (-> this :address :house-num)
         " "
         (-> this :address :street))))

(defmulti test-multimethod (fn [keyword] keyword))

(defmethod test-multimethod :foo [a-map]
  "foo-method was called")

(defmethod test-multimethod :bar [a-map]
  "bar-method was called")

(defmulti perimeter (fn [shape] (:shape-name shape)))
(defmethod perimeter :circle [circle]
  (* 2 Math/PI (:radius circle)))
(defmethod perimeter :rectangle [rectangle]
  (+ (* 2 (:width rectangle)) (* 2 (:height rectangle))))

(def some-shapes [{:shape-name :circle :radius 4}
                  {:shape-name :rectangle :width 2 :height 2}])

(defmulti area (fn [shape] (:shape-name shape)))
(defmethod area :circle [circle]
  (* Math/PI (:radius circle) (:radius circle)))
(defmethod area :rectangle [rectangle]
  (* (:width rectangle) (:height rectangle)))

(defmethod perimeter :square [square]
  (* 4 (:side square)))
(defmethod area :square [square]
  (* (:side square) (:side square)))

(def more-shapes (conj some-shapes
                       {:shape-name :square :side 4}))

(defn run []
  (println "SimplePerson : ")
  (def simple-person (->SimplePerson "Yourtion" "Guo" 123 "Fake. St."))
  (println (:first-name simple-person))
  (println (extract-name simple-person))
  (println (extract-address simple-person))
  (println "")

  (println "ComplexPerson : ")
  (def complex-person (->ComplexPerson {:first "yourtion" :last "guo"} {:house-num 456 :street "Fake2. St."}))
  (println (extract-name complex-person))
  (println (extract-address complex-person))
  (println "")

  (println "TestMultimethod : ")
  (println (test-multimethod :foo))
  (println (test-multimethod :bar))
  (println "")

  (println "SecondShapeExample :")
  (println (for [shape some-shapes] (perimeter shape)))
  (println (for [shape some-shapes] (area shape)))
  (println "")

  (println "ThirdShapeExample :")
  (println (for [shape more-shapes] (perimeter shape)))
  (println (for [shape more-shapes] (area shape)))

)
