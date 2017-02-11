(ns ascme.asc
  (:require [clojure.math.combinatorics :refer [subsets]]
            [clojure.set :refer [union subset?]]
            [me.raynes.conch :refer [programs]]
            [swiss.arrows :refer :all]))

(programs tmsu)

(def items (tmsu "files" {:seq true}))

(def base-simplices-by-items
  (->> items
       (mapcat (fn [f] (tmsu "tags" f {:seq true})))
       (map #(clojure.string/split % #": "))
       (map (juxt first #(clojure.string/split (second %) #" " )))
       (into {})))

(def base-simplices (vals base-simplices-by-items))

(def complex (map set (set (mapcat subsets base-simplices) )))

(def ground
  (reduce clojure.set/union base-simplices))

;; Now, the Txxxxx topology, if you can hack it. Note it's our first definition of a function rather than data.

(defn star [x]
  (filter (partial subset? (if (set? x) x #{ x } )) complex))

(star #{"resistance"})

(star #{"money"})

