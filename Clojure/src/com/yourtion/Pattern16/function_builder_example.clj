(ns com.yourtion.Pattern16.function-builder-example
  (:require [com.yourtion.Pattern16.discount-builder :as discount-builder])
  (:require [com.yourtion.Pattern16.selector-example :as selector-example])
  (:require [com.yourtion.Pattern16.composition-examples :as composition-examples]))

(defn run []
  (discount-builder/run)
  (println "")
  (selector-example/run)
  (println "")
  (composition-examples/run)
  (println ""))
