(ns ascme.asc
  (:require [clojure.math.combinatorics :refer [cartesian-product subsets]]
            [clojure.set :refer [union subset?]]
            [me.raynes.conch :refer [programs]]
            [swiss.arrows :refer :all]
            [clojure.test :refer [is]]))

(programs tmsu)

;; Data & Labels
;; =============
(def items (tmsu "files" {:seq true}))

(def labels
  "Should perhaps be a multi-arity function, where 0 arguments gets every tag."
  (tmsu "tags" {:seq true}))

;; Simplices
;; =========
(def base-simplices-by-items
  (->> items
       (mapcat (fn [f] (tmsu "tags" f {:seq true})))
       (map #(clojure.string/split % #": "))
       (map (juxt first #(clojure.string/split (second %) #" " )))
       (into {})))

(def base-simplices (vals base-simplices-by-items))

(def complex
  (map set (set (mapcat subsets base-simplices))))









;; Reading this now, I'm thinking that those defs are going to become functions that take a source as an argument in the process of parameterizing & protocoling this code for reuse. But again, we want to concentrate on this first implementation of sheaves for tmsu data, and then generalize to bookmarks or other folksonomy-style data.

;; From http://drmichaelrobinson.net/sheaftutorial/20150825_tutorial_3.pdf:

;; ## The attachment diagram
;; The attachment diagram shows how simplices fit together: it's a graph of simplices with directed arrows that are like Hasse arrows --- they're not quite the inclusion map, because there are not arrows for every subset relation, but for "smallest subset" relation. Is this the 'covering map' then? Yes, it looks like we want the =transitive reduction=, the digraph with the fewest arrows that still has the same reachability. Huh. How to implement this?

;; ## A sheaf is...

;; A set assigned to each simplex (the set is called the stalk over its simplex), and...

;; ...a function assigned to each simplex inclusion on the transitive reduction (the function is called a restriction)...

;; ...so that the diagram commutes.

;; ## A global section is...

;; An assignment of values from each of the stalks that is consistent with the restrictions.

;; ## A local section is...

;; An assignment of values, but maybe not defined for all simplices or it doesn't agree with restrictions.

;; A local section can maybe be extended to a global section. If /every/ local section can be, then it's a 'flabby' or 'flasque' sheaf. Flabby sheaves don't have interesting invariatns but they can be good for decomposing other sheaves.



