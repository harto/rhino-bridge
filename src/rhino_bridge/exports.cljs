;; An API for accessing Java objects exported into the ClojureScript
;; environment.

(ns rhino-bridge.exports
  (:refer-clojure :exclude [get]))

(def exports
  "The set of exported Java objects."
  (atom {}))

(defn export!
  "Export a Java object into the ClojureScript runtime. This is called by the
   Clojure function `rhino-bridge.core/export!' -- it shouldn't normally be
   called by ClojureScript code."
  [k v]
  (swap! exports assoc k v))

(defn get
  "Look up an exported Java object."
  [k]
  (clojure.core/get @exports k))
