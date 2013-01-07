;; Use Clojure objects (data structures, fns) transparently in ClojureScript

(ns rhino-bridge.clj)

;; Define a wrapper type that can implement various ClojureScript core protocols
(deftype ClojureObject [object])

(defn ->clj [x]
  (ClojureObject. x))

(defn ->cljs [x]
  (.-object x))

(extend-type ClojureObject
  IFn
  (-invoke
    ([this]
       (.invoke (.-object this)))
    ([this a]
       (.invoke (.-object this) a))
    ([this a b]
       (.invoke (.-object this) a b))
    ([this a b c]
       (.invoke (.-object this) a b c))
    ([this a b c d]
       (.invoke (.-object this) a b c d))
    ([this a b c d e]
       (.invoke (.-object this) a b c d e))
    ([this a b c d e f]
       (.invoke (.-object this) a b c d e f))
    ([this a b c d e f g]
       (.invoke (.-object this) a b c d e f g))
    ([this a b c d e f g h]
       (.invoke (.-object this) a b c d e f g h))
    ([this a b c d e f g h i]
       (.invoke (.-object this) a b c d e f g h i))
    ([this a b c d e f g h i j]
       (.invoke (.-object this) a b c d e f g h i j))
    ([this a b c d e f g h i j k]
       (.invoke (.-object this) a b c d e f g h i j k))
    ([this a b c d e f g h i j k l]
       (.invoke (.-object this) a b c d e f g h i j k l))
    ([this a b c d e f g h i j k l m]
       (.invoke (.-object this) a b c d e f g h i j k l m))
    ([this a b c d e f g h i j k l m n]
       (.invoke (.-object this) a b c d e f g h i j k l m n))
    ([this a b c d e f g h i j k l m n o]
       (.invoke (.-object this) a b c d e f g h i j k l m n o))
    ([this a b c d e f g h i j k l m n o p]
       (.invoke (.-object this) a b c d e f g h i j k l m n o p))
    ([this a b c d e f g h i j k l m n o p q]
       (.invoke (.-object this) a b c d e f g h i j k l m n o p q))
    ([this a b c d e f g h i j k l m n o p q r]
       (.invoke (.-object this) a b c d e f g h i j k l m n o p q r))
    ([this a b c d e f g h i j k l m n o p q r s]
       (.invoke (.-object this) a b c d e f g h i j k l m n o p q r s))
    ([this a b c d e f g h i j k l m n o p q r s t]
       (.invoke (.-object this) a b c d e f g h i j k l m n o p q r s t))
    ([this a b c d e f g h i j k l m n o p q r s t rest]
       ;; FIXME: this almost certainly doesn't work; write a test case
       (.invoke (.-object this) a b c d e f g h i j k l m n o p q r s t rest))
    ))
