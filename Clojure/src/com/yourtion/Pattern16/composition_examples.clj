(ns com.yourtion.Pattern16.composition-examples)

(defn append-a [s] (str s "a"))
(defn append-b [s] (str s "b"))
(defn append-c [s] (str s "c"))

(def request
  {:headers
         {"Authorization" "auth"
          "X-RequestFingerprint" "fingerprint"}
   :body "body"})

(defn check-authorization [request]
  (let [auth-header (get-in request [:headers "Authorization"])]
    (assoc
      request
      :principal
      (if-not (nil? auth-header)
        "AUser"))))

(defn log-fingerprint [request]
  (let [fingerprint (get-in request [:headers "X-RequestFingerprint"])]
    (println (str "FINGERPRINT=" fingerprint))
    request))

(defn compose-filters [filters]
  (reduce
    (fn [all-filters, current-filter] (comp all-filters current-filter))
    filters))

(defn run []
  (println "CompositionExamples: ")
  (def append-cba (comp append-a append-b append-c))
  (println (append-cba "z"))
  (println "")

  (def request {:headers
                {"Authorization" "auth"
                 "X-RequestFingerprint" "fingerprint"}
                :body "Body"})
  (def filter-chain (compose-filters [check-authorization log-fingerprint]))
  (println (filter-chain request))
  (println ""))
