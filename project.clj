(defproject rhino-bridge "0.0.1-SNAPSHOT"
  :description "A way to export Java objects into a Rhino-based ClojureScript environment"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojurescript "0.0-1450"]]
  :plugins [[lein-cljsbuild "0.2.2"]]
  :cljsbuild {:builds [{:source-path "src"}]})
