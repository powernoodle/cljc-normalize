(ns normalize.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as string]
            [normalize.core :refer [normalize-css]]))

(def official-normalize
  (-> (->> (slurp "resources/normalize v6.0.0.css")
           string/trim-newline
           string/split-lines
           (map (comp string/trim string/trim-newline))
           (apply str))
      (string/replace " {" "{")
      (string/replace "{ " "{")
      (string/replace ": " ":")
      (string/replace ", " ",")
      (string/replace "; " ";")
      (string/replace " [" "[")
      (string/replace "0.67em" ".67em")
      (string/replace "bottom:none" "bottom:0")
      (string/replace #"/\*.+?\*/" "")
      (string/replace ";}" "}")))

(deftest normalize
  (testing "Matches latest normalize.css"
    (is (= normalize-css
           official-normalize))))
