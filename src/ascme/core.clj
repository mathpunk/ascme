(ns ascme.core
  (:gen-class))

;; Tag a file
defn tag file tags
with-program
"tmsu"
"tmsu" "tag" file tags

;; Tag a number of files



;; List files from tags
defn items tags
with-program
"tmsu"
"tmsu" "files" tags

;; Get the tag vocabulary, and return it as a set.
defn v
"tmsu"
"tmsu" "tags"

;; Get all subsets of the tag vocabulary
def subsets
combinatorics/subsets v


;; MEASUREMENT
;; ===========

;; Get the subsets that have nonzero sizes of files
def topics
filter subsets


;; Okay now I have to write a bit.


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; Start a repl
  (println "Hello, World!"))
