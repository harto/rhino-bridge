;; Helpers for evaluating ClojureScript code

(ns rhino-bridge.cljs
  (:require [cljs.analyzer :as analyzer]
            [cljs.repl :as repl]))

(defn evaluate-form
  "Compiles and executes a form in a ClojureScript environment. (This is
   essentially the 'eval' part of `cljs.repl/repl'.)"
  [repl-env form]
  (repl/evaluate-form repl-env
                      (analyzer/empty-env)
                      "<rhino-bridge initialiser>"
                      form))
