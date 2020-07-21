(ns leiningen.new.{{name}}
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :refer [info]]))

(def render (renderer "{{name}}"))

(defn {{name}}
  "FIXME: write documentation"
  [name]
  (let [data {:name      name
              :sanitized (name-to-path name)}]
    (info "Generating fresh 'lein new' {{name}} project.")
    (->files data
             ["src/{{sanitized}}/core.clj" (render "src/{{name}}/core.clj" data)]
             ["test/{{sanitized}}/core_test.clj" (render "test/{{name}}/core_test.clj" data)]
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render ".gitignore" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)])))
