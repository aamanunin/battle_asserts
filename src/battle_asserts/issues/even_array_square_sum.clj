(ns battle-asserts.issues.even-array-square-sum
  (:require [clojure.string :as s]
            [clojure.test.check.generators :as gen]
            [faker.generate :as faker]))

(def level :elementary)

(def description "Find square sum of all even numbers in array.")

(def signature
  {:input [{:argument-name "arr" :type {:name "array" :nested {:name "integer"}}}]
   :output {:type {:name "integer"}}})

(defn arguments-generator
  []
  (gen/tuple (gen/vector (gen/choose -20 20) 2 5)))

(def test-data
  [{:expected 20
    :arguments [[1 2 3 4]]}
   {:expected 264
    :arguments [[2 2 16 -1]]}
   {:expected 0
    :arguments [[1 0 -1 -5]]}
   {:expected 48
    :arguments [[4 4 4]]}
   {:expected 48
    :arguments [[4 4 4]]}])

(defn solution [arr]
  (reduce (fn [p num] (+ p (* num num))) 0 (filter even? arr)))
