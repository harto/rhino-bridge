;; An API for exporting Java objects into a Rhino-based ClojureScript environment.

(ns rhino-bridge.core
  (:require [cljs.analyzer :as analyzer]
            [cljs.repl :as repl])
  (:import [org.mozilla.javascript Context ScriptableObject]))

(defn- evaluate-form
  "Compiles and executes a form in a ClojureScript environment. (This is
   essentially the 'eval' part of `cljs.repl/repl'.)"
  [repl-env form]
  (repl/evaluate-form repl-env (analyzer/empty-env) "<rhino-bridge initialiser>" form))

(defn init! [env]
  (binding [analyzer/*cljs-ns* 'cljs.user]
    (repl/-setup env)
    (repl/load-file env "rhino_bridge/exports.cljs")))

(defn export!
  "Exports a Java object into a ClojureScript environment. The object can
   subsequently be retrieved using the ClojureScript function
   `rhino-bridge.exports/get'."
  [env k v]
  (let [exported-key-name (str (gensym "__rhino_bridge_exported_key_"))
        exported-val-name (str (gensym "__rhino_bridge_exported_val_"))
        scope (:scope env)
        dump (fn [k v] (ScriptableObject/putProperty scope k (Context/javaToJS v scope)))
        undump (fn [k] (ScriptableObject/deleteProperty scope k))]
    ;; Dump the key/value pair directly into the JS global scope.
    (dump exported-key-name k)
    (dump exported-val-name v)
    ;; Now that the key/value pair are exposed as JS objects, put them into our
    ;; well-known location.
    (evaluate-form env
      `(rhino-bridge.exports/export!
        ~(symbol "js" exported-key-name)
        ~(symbol "js" exported-val-name)))
    ;; Unpollute the global scope
    (undump exported-key-name)
    (undump exported-val-name)))
