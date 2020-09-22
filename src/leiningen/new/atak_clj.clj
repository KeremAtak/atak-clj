(ns leiningen.new.atak-clj
  (:require [leiningen.core.main :refer [info]]
            [leiningen.new.templates :refer [->files name-to-path raw-resourcer renderer]]
            [leiningen.new.util :refer [binary-file-paths file-paths]]))

(def template-name "atak-clj")
(def render (renderer template-name))

(defn generate-binary-file [[first second]]
  (let [raw (raw-resourcer template-name)]
    [first (raw second)]))

(defn generate-file [[first second] data]
  [first (render second data)])

(defn atak-clj
  "FIXME: write documentation"
  [name]
  (let [data {:name      name
              :sanitized (name-to-path name)}]
    (info "Generating fresh 'lein new' atak-clj project.")
    (apply ->files data
           (into
            (map #(generate-file % {:name name}) file-paths)
            (map generate-binary-file binary-file-paths)))))
