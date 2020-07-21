(ns swagger-example.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [swagger-example.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[swagger-example started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[swagger-example has shut down successfully]=-"))
   :middleware wrap-dev})
