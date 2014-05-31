(ns {{name}}.core
  (:require [om.core :as om :include-macros true]
            [sablono.core :as html :refer-macros [html]]
            [secretary.core :as secretary :include-macros true :refer [defroute]]
            [{{name}}.navigation :as navigation]))

(def app-state (atom {}))

(secretary/set-config! :prefix "#")

(defn component [app owner]
  (reify
    om/IRender
    (render [this]
      (html [:h1 "{{name}}"]))))

(defn root [app-state]
  (om/root component app-state
         {:target (. js/document (getElementById "app"))}))

(defroute "/" {} (root app-state))

(om/root navigation/component app-state
         {:target (. js/document (getElementById "navigation"))})

(secretary/dispatch! "/")