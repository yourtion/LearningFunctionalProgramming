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
)
