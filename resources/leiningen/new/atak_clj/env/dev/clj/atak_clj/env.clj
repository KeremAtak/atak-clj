(ns {{name}}.env
  (:require [{{name}}.dev-middleware :refer [wrap-dev]]
            [clojure.tools.logging :as log]
            [selmer.parser :as parser]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[{{name}} started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[{{name}} has shut down successfully]=-"))
   :middleware wrap-dev})
