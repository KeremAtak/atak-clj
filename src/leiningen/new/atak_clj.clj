(ns leiningen.new.atak-clj
  (:require [leiningen.core.main :refer [info]]
            [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.new.util :refer [file-paths]]))

(def render (renderer "atak-clj"))

(defn generate-file-path [[first second] data]
  [first (render second data)])

(defn atak-clj
  "FIXME: write documentation"
  [name]
  (let [data {:name      name
              :sanitized (name-to-path name)}]
    (info "Generating fresh 'lein new' atak-clj project.")
    (apply ->files data
           (map #(generate-file-path % {:name name}) file-paths))))
