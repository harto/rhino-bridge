# rhino-bridge

A mechanism for exporting Java objects (e.g. Clojure functions) into a
Rhino-based ClojureScript environment.

Status: proof-of-concept (i.e. possibly an insane idea that I'm not sure
I even need)

## Usage

Export objects using Clojure like this:

    (let [env (cljs.repl.rhino/repl-env)]
      (rhino-bridge.core/init! env)
      (rhino-bridge.core/export! env "foo" :bar)
      (cljs.repl/repl env))

Then, access the exported objects using ClojureScript like this:

    (rhino-bridge.exports/get "foo")

## TODO

 * Provide sugar for transparent interop, e.g. calling Clojure fns
 * Can the REPL dependency be removed?
