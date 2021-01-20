(ns profiles-mock.core
  (:require [reagent.dom :as dom]
            [devtools.core :as devtools]
            [profiles-mock.app :as app]))

(devtools/install!)
(enable-console-print!)

;; -- VIEW --------------------------------------------------------------------

(defn app-component
  []
  [:div
   [app/component]])

(dom/render [app-component]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  (dom/force-update-all))
