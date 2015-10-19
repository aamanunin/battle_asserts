(ns battle-asserts.issues.pair-with-maximum-product
  (:require [clojure.test.check.generators :as gen]
            [faker.generate :as faker]))

(def level :easy)

(def description "Given an array with both +ive and -ive integers, return a pair with highest product.")

(defn arguments-generator []
  (gen/tuple (gen/vector gen/int 2 25)))

(def test-data
  [{:expected [6 7]
    :arguments [[1 4 3 6 7 0]]}
   {:expected [-5 -4]
    :arguments [[-1 -3 -4 2 0 -5]]}
   {:expected [3 4]
    :arguments [[-1 -2 -4 -3 0 4 3 2 1]]}])

(defn product [array]
  (apply * array))

(defn solution [array]
  (let [sort-array (sort array)
        two-max (take-last 2 sort-array)
        two-min (take 2 sort-array)]
    (if (>
         (product two-min)
         (product two-max))
      two-min
      two-max)))