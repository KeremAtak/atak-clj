(ns leiningen.new.util)

(def file-paths
  [["env/dev/clj/{{sanitized}}/dev_middleware.clj" "env/dev/clj/atak_clj/dev_middleware.clj"]
   ["env/dev/clj/{{sanitized}}/env.clj" "env/dev/clj/atak_clj/env.clj"]
   ["env/dev/clj/user.clj" "env/dev/clj/user.clj"]
   ["env/dev/resources/config.edn" "env/dev/resources/config.edn"]
   ["env/dev/resources/logback.xml" "env/dev/resources/logback.xml"]

   ["env/prod/clj/{{sanitized}}/env.clj" "env/prod/clj/atak_clj/env.clj"]
   ["env/prod/resources/config.edn" "env/prod/resources/config.edn"]
   ["env/prod/resources/logback.xml" "env/prod/resources/logback.xml"]

   ["env/test/resources/config.edn" "env/test/resources/config.edn"]
   ["env/test/resources/logback.xml" "env/test/resources/logback.xml"]

   ["resources/docs/docs.md" "resources/docs/docs.md"]

   ["resources/html/error.html" "resources/html/error.html"]

   ["resources/migrations/20200922222602-add-users-table.down.sql" "resources/migrations/20200922222602-add-users-table.down.sql"]
   ["resources/migrations/20200922222602-add-users-table.up.sql" "resources/migrations/20200922222602-add-users-table.up.sql"]

   ["resources/sql/math-queries.sql" "resources/sql/math-queries.sql"]

   ["resources/favicon.ico" "resources/favicon.ico"]

   ["src/clj/{{sanitized}}/db/core.clj" "src/clj/atak_clj/db/core.clj"]

   ["src/clj/{{sanitized}}/middleware/exception.clj" "src/clj/atak_clj/middleware/exception.clj"]
   ["src/clj/{{sanitized}}/middleware/formats.clj" "src/clj/atak_clj/middleware/formats.clj"]

   ["src/clj/{{sanitized}}/routes/api.clj" "src/clj/atak_clj/routes/api.clj"]
   ["src/clj/{{sanitized}}/routes/files.clj" "src/clj/atak_clj/routes/files.clj"]
   ["src/clj/{{sanitized}}/routes/health.clj" "src/clj/atak_clj/routes/health.clj"]
   ["src/clj/{{sanitized}}/routes/math.clj" "src/clj/atak_clj/routes/math.clj"]

   ["src/clj/{{sanitized}}/schemas/files.clj" "src/clj/atak_clj/schemas/files.clj"]
   ["src/clj/{{sanitized}}/schemas/math.clj" "src/clj/atak_clj/schemas/math.clj"]

   ["src/clj/{{sanitized}}/services/file.clj" "src/clj/atak_clj/services/file.clj"]
   ["src/clj/{{sanitized}}/services/math.clj" "src/clj/atak_clj/services/math.clj"]

   ["src/clj/{{sanitized}}/config.clj" "src/clj/atak_clj/config.clj"]
   ["src/clj/{{sanitized}}/core.clj" "src/clj/atak_clj/core.clj"]
   ["src/clj/{{sanitized}}/handler.clj" "src/clj/atak_clj/handler.clj"]
   ["src/clj/{{sanitized}}/layout.clj" "src/clj/atak_clj/layout.clj"]
   ["src/clj/{{sanitized}}/middleware.clj" "src/clj/atak_clj/middleware.clj"]
   ["src/clj/{{sanitized}}/nrepl.clj" "src/clj/atak_clj/nrepl.clj"]

   ["test/clj/{{sanitized}}/test/handler.clj" "test/clj/atak_clj/test/handler.clj"]

   [".gitignore" ".gitignore"]
   ["Capstanfile" "Capstanfile"]
   ["dev-config.edn" "dev-config.edn"]
   ["Dockerfile" "Dockerfile"]
   ["LICENSE" "LICENSE"]
   ["Procfile" "Procfile"]
   ["project.clj" "project.clj"]
   ["README.md" "README.md"]
   ["test-config.edn" "test-config.edn"]])

(def binary-file-paths
  [["resources/public/img/warning_clojure.png" "resources/public/img/warning_clojure.png"]])
