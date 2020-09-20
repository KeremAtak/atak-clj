(ns {{name}}.routes.files
  (:require [{{name}}.services.file :refer [get-picture]]
            [reitit.ring.middleware.multipart :as multipart]))

{{! Change mustache delimiter to <% and %>}}
{{=<% %>=}}
(defn file-routes []
   ;; swagger documentation
  ["/files"
   {:swagger {:tags ["files"]}}
   ["/upload"
    {:post {:summary "upload a file"
            :parameters {:multipart {:file multipart/temp-file-part}}
            :responses {200 {:body {:name string?, :size int?}}}
            :handler (fn [{{{:keys [file]} :multipart} :parameters}]
                       {:status 200
                        :body {:name (:filename file)
                               :size (:size file)}})}}]
   ["/download"
    {:get {:summary "downloads a file"
           :swagger {:produces ["image/png"]}
           :handler (fn [_]
                      {:status 200
                       :headers {"Content-Type" "image/png"}
                       :body (get-picture)})}}]])
<%! Reset mustache delimiter %>
<%={{ }}=%>
