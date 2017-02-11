(defproject ascme "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [me.raynes/conch "0.8.0"]
                 [swiss-arrows "1.0.0"]
                 [org.clojure/math.combinatorics "0.1.4"]]
  :main ^:skip-aot ascme.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
