(ns {{name}}.middleware
    (:require [{{name}}.config :refer [env]]
              [{{name}}.env :refer [defaults]]
              [{{name}}.layout :refer [error-page]]
              [{{name}}.middleware.formats :as formats]
              [cheshire.generate :as cheshire]
              [clojure.tools.logging :as log]
              [cognitect.transit :as transit]
              [muuntaja.middleware :refer [wrap-format wrap-params]]
              [ring.adapter.undertow.middleware.session :refer [wrap-session]]
              [ring.middleware.anti-forgery :refer [wrap-anti-forgery]]
              [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
              [ring.middleware.flash :refer [wrap-flash]]))

(defn wrap-internal-error [handler]
  (fn [req]
    (try
      (handler req)
      (catch Throwable t
        (log/error t (.getMessage t))
        (error-page {:status 500
                     :title "Something very bad has happened!"
                     :message "We've dispatched a team of highly trained gnomes to take care of the problem."})))))

(defn wrap-csrf [handler]
  (wrap-anti-forgery
    handler
    {:error-response
     (error-page
       {:status 403
        :title "Invalid anti-forgery token"})}))


(defn wrap-formats [handler]
  (let [wrapped (-> handler wrap-params (wrap-format formats/instance))]
    (fn [request]
      ;; disable wrap-formats for websockets
      ;; since they're not compatible with this middleware
      ((if (:websocket? request) handler wrapped) request))))

(defn wrap-base [handler]
  (-> ((:middleware defaults) handler)
      wrap-flash
      (wrap-session {:cookie-attrs {:http-only true}})
      (wrap-defaults
        (-> site-defaults
            (assoc-in [:security :anti-forgery] false)
            (dissoc :session)))
      wrap-internal-error))
