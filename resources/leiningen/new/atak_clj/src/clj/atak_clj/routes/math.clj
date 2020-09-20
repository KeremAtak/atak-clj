(ns {{name}}.routes.math)

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
           :handler (fn [{{{:keys [x y]} :query} :parameters}]
                      {:status 200
                       :body {:total (+ x y)}})}
     :post {:summary "plus with spec body parameters"
            :parameters {:body {:x int?, :y int?}}
            :responses {200 {:body {:total pos-int?}}}
            :handler (fn [{{{:keys [x y]} :body} :parameters}]
                       {:status 200
                        :body {:total (+ x y)}})}}]])
<%! Reset mustache delimiter %>
<%={{ }}=%>
