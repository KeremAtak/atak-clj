(ns {{name}}.routes.math
  (:require [{{name}}.services.math :refer [sum]]))

{{! Change mustache delimiter to <% and %>}}
{{=<% %>=}}

(defn math-routes []
   ;; swagger documentation
  ["/math"
   {:swagger {:tags ["math"]}}
   ["/plus"
    {:get {:summary "plus with spec query parameters"
           :parameters {:query {:x int?, :y int?}}
           :responses {200 {:body {:total pos-int?}}}
           :handler (fn [{{:keys [query]} :parameters}]
                      {:status 200
                       :body {:total (sum query)}})}
     :post {:summary "plus with spec body parameters"
            :parameters {:body {:x int?, :y int?}}
            :responses {200 {:body {:total pos-int?}}}
            :handler (fn [{{:keys [body]} :parameters}]
                       {:status 200
                        :body {:total (sum body)}})}}]])
<%! Reset mustache delimiter %>
<%={{ }}=%>
