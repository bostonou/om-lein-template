(ns {{name}}.navigation
  (:require [cljs.core.async :refer [put! chan <! alts!]]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [sablono.core :as html :refer-macros [html]]
            [secretary.core :as secretary :include-macros true :refer [defroute]])
  (:require-macros [cljs.core.async.macros :refer [go-loop]]))

(defn- navigate! [chan route]
  (fn [e]
    (.preventDefault e)
    (put! chan route)))

(defn component [app owner]
  (reify
    om/IInitState
    (init-state [_]
      {:navigation-chan (chan)})
    om/IWillMount
    (will-mount [this]
      (let [{:keys [navigation-chan]} (om/get-state owner)]
        (go-loop [route (<! navigation-chan)]
                 (secretary/dispatch! route)
                 (recur (<! navigation-chan)))))
    om/IRenderState
    (render-state [this {:keys [navigation-chan]}]
      (html [:div.container
             [:div.navbar-header
              [:a.navbar-brand {:href "#"
                                :on-click (navigate! navigation-chan "/")}
               "{{name}}"]]]))))
