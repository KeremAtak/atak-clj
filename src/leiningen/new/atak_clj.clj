(ns leiningen.new.atak-clj
  (:require [leiningen.core.main :refer [info]]
            [leiningen.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "atak-clj"))

(defn atak-clj
  "FIXME: write documentation"
  [name]
  (let [data {:name      name
              :sanitized (name-to-path name)}]
    (info "Generating fresh 'lein new' atak-clj project.")
    (->files data
             ["env/dev/clj/{{sanitized}}/dev_middleware.clj" (render "env/dev/clj/atak_clj/dev_middleware.clj" data)]
             ["env/dev/clj/{{sanitized}}/env.clj" (render "env/dev/clj/atak_clj/env.clj" data)]
             ["env/dev/clj/user.clj" (render "env/dev/clj/user.clj" data)]
             ["env/dev/resources/config.edn" (render "env/dev/resources/config.edn" data)]
             ["env/dev/resources/logback.xml" (render "env/dev/resources/logback.xml" data)]
             ["env/prod/clj/{{sanitized}}/env.clj" (render "env/prod/clj/atak_clj/env.clj" data)]
             ["env/prod/resources/config.edn" (render "env/prod/resources/config.edn" data)]
             ["env/prod/resources/logback.xml" (render "env/prod/resources/logback.xml" data)]
             ["env/test/resources/config.edn" (render "env/test/resources/config.edn" data)]
             ["env/test/resources/logback.xml" (render "env/test/resources/logback.xml" data)]
             ["resources/docs/docs.md" (render "resources/docs/docs.md" data)]
             ["resources/html/error.html" (render "resources/html/error.html" data)]
             ["resources/public/img/warning_clojure.png" (render "resources/public/img/warning_clojure.png" data)]
             ["resources/favicon.ico" (render "resources/favicon.ico" data)]
             ["src/clj/{{sanitized}}/middleware/exception.clj" (render "src/clj/atak_clj/middleware/exception.clj" data)]
             ["src/clj/{{sanitized}}/middleware/formats.clj" (render "src/clj/atak_clj/middleware/formats.clj" data)]
             ["src/clj/{{sanitized}}/routes/services.clj" (render "src/clj/atak_clj/routes/services.clj" data)]
             ["src/clj/{{sanitized}}/config.clj" (render "src/clj/atak_clj/config.clj" data)]
             ["src/clj/{{sanitized}}/core.clj" (render "src/clj/atak_clj/core.clj" data)]
             ["src/clj/{{sanitized}}/handler.clj" (render "src/clj/atak_clj/handler.clj" data)]
             ["src/clj/{{sanitized}}/layout.clj" (render "src/clj/atak_clj/layout.clj" data)]
             ["src/clj/{{sanitized}}/middleware.clj" (render "src/clj/atak_clj/middleware.clj" data)]
             ["src/clj/{{sanitized}}/nrepl.clj" (render "src/clj/atak_clj/nrepl.clj" data)]
             ["test/clj/{{name}}/test/handler.clj" (render "test/clj/atak_clj/test/handler.clj" data)]

             [".gitignore" (render ".gitignore" data)]
             ["Capstanfile" (render "Capstanfile" data)]
             ["dev-config.edn" (render "dev-config.edn" data)]
             ["Dockerfile" (render "Dockerfile" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["Procfile" (render "Procfile" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["test-config.edn" (render "test-config.edn" data)])))
