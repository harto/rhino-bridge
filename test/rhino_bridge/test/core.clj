(ns rhino-bridge.test.core
  (:use [clojure.test]
        [rhino-bridge.core])
  (:require [cljs.repl.rhino :as rhino]))

(defn- cljs-env []
  (init! (rhino/repl-env)))

(deftest test-export!
  (let [env (cljs-env)]
    (export! env "foo" "bar")
    (is (= "bar" (evaluate-form env '(rhino-bridge.exports/get "foo"))))))
