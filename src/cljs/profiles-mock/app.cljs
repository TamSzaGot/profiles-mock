(ns profiles-mock.app
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [clojure.string :as str]
            [ajax.core :as ajax]
            [day8.re-frame.http-fx]))


;; -- reframe components --------------------------------------------------------------------

  (defn accordion-card
  "defines a bootstrap accordion card"
  [accordion-id card-id title-text body expanded?]
  (let [accordion-card-id (str accordion-id "card" card-id)
        accordion-card-body-id (str accordion-card-id "body")]
    [:div.card {:id accordion-card-id}
     [:div.card-title.collapsed {:type "button"
                                               :data-toggle "collapse"
                                               :data-target (str "#" accordion-card-body-id)
                                               :aria-expanded (if expanded? "true" "false")
                                               :aria-controls accordion-card-body-id}
      title-text]
     [:div.collapse {:class (if expanded? "show" "")
                     :id accordion-card-body-id
                     :aria-labelledby accordion-card-id
                     :data-parent (str "#" accordion-id)}
      [:div.card-body
       body]]]))

(defn accordion
  "creates a bootstrap accordion with the cards in the cards collection
  accordion-id    the id of this accordion
  cards           list of card components
  "
  [id cards]
  (let [accordion-id (str "accordion" id)]
    (into [:div.accordion {:id accordion-id}] (map-indexed (fn [idx itm] (accordion-card accordion-id idx (:title itm) (:body itm) false)) cards))))

;; In-browser state

(defonce profile-name-atom (r/atom "test"))

;; Helpers

(defn target-value
  "Get the value from a dom event"
  [event]
  (some-> event .-target .-value))

;; -- VIEW --------------------------------------------------------------------


(defn header
  []
  [:div {:class "header-main"}
   [:div {:class "header-inner3"}
    [:div {:class "header-list"}
     [:div {:class "aflogo"}
      [:a {:class "aflogo", :href "#"}
       [:img {:class "aflogo-img", :src "img/logo.svg", :alt "Arbetsförmedlingen - till startsidan"}]]]
     [:div
      [:button {:class "search-button0"}
       [:i {:class "i-af-search"}]]]]
    [:div {:class "header-buttons"}
     [:div {:class "logout-button"}
      [:button {:class "header-button"}
       [:i {:class "i-af-user-alt"}]
       [:span {:class "logout-button"} "Logga ut"]]]
     [:div {:class "lang-button"}
      [:button {:class "header-button"}
       [:i {:class "i-l-languages"}]
       [:span {:class "lang-button"} "Languages"]]]
     [:div {:class "search-button"}
      [:button {:class "header-button"}
       [:i {:class "i-af-search"}]
       [:span {:class "search-button"} "Sök"]]]
     [:div {:class "menu-button"}
      [:button {:class "header-button"}
       [:i {:class "i-bars"}]
       [:span {:class "menu-button"} "Meny"]]]]]])

(defn link-back
  []
  [:div {:class "cont"}
   [:img {:class "rupoc-img", :src "img/rupoc.svg"}]
   [:div {:class "link-back"}
    [:a {:href "#"}
     [:div {:class "button-text"}
      [:div {:class "arrow-left"}
       [:svg {:width "9", :height "14", :viewBox "0 0 9 14", :xmlns "http://www.w3.org/2000/svg"}
        [:path {:d "M8 13L2 6.926 7.853 1", :stroke "currentColor", :stroke-width "2", :fill "none", :fill-rule "evenodd"}]]]
      [:div "Mina profiler"]]]
    [:blue-button
     [:button {:class "blue-button", :type "button"}
      [:div {:class "button-text"}
       [:div "Granska och publicera"]
       [:div {:class "arrow-right"}
        [:svg {:width "9", :height "14", :viewBox "0 0 9 14", :xmlns "http://www.w3.org/2000/svg"}
         [:path {:d "M1 13l6-6.074L1.147 1", :stroke-width "2", :fill "none", :fill-rule "evenodd"}]]]]]]]])


(defn notification
  [message]
  (r/with-let
    [closed (r/atom false)]
    (when (not @closed)
      [:div {:class "cont"}
       [:div {:class "notification"}
        [:div {:class "notification-icon"}
         [:svg {:width "42", :height "42", :viewBox "0 0 42 42", :xmlns "http://www.w3.org/2000/svg"}
          [:g {:fill "currentColor", :fill-rule "nonzero"}
           [:path {:d "M21 39c9.941 0 18-8.059 18-18S30.941 3 21 3 3 11.059 3 21s8.059 18 18 18zm0 3C9.402 42 0 32.598 0 21S9.402 0 21 0s21 9.402 21 21-9.402 21-21 21z"}]
           [:path {:d "M22 10c2.071 0 3.75 1.485 3.75 3.316 0 1.831-1.679 3.316-3.75 3.316-2.071 0-3.75-1.485-3.75-3.316C18.25 11.485 19.929 10 22 10zm5 20.053c0 .523-.48.947-1.071.947H18.07C17.48 31 17 30.576 17 30.053v-1.895c0-.523.48-.947 1.071-.947h1.072v-5.053H18.07c-.591 0-1.071-.424-1.071-.947v-1.895c0-.523.48-.948 1.071-.948h5.715c.591 0 1.071.425 1.071.948v7.895h1.072c.591 0 1.071.424 1.071.947v1.895z"}]]]]
        [:div {:class "notification-content"}
         [:button {:type "button", :class "notification-close", :aria-label "Stäng meddelandet"
                   :on-click #(reset! closed true)}
          [:div {:class "notification-close-text"} "Stäng"]
          [:div {:class "icon-x"}
           [:svg {:width "12", :height "12", :viewBox "0 0 12 12", :xmlns "http://www.w3.org/2000/svg"}
            [:g {:stroke "currentColor", :stroke-width "2", :fill "none", :fill-rule "evenodd", :stroke-linecap "square"}
             [:path {:d "M2 2l7.986 7.986M9.986 2L2 9.986"}]]]]]
         [:div message]]]]))
  )

(defn section-name
  []
  (r/with-let
   [input-name (r/atom @profile-name-atom)]
     [:div {:class "sect"}
      [:h2 "Ge profilen ett namn"]
      [:p {:class "s1"} "Namnet är synligt bara för dig och du kan när du vill ändra profilnamnet."]
      [:form {:class "form-inl"}
       [:prof-name-input
        [:input#namn.prof-name-input {:type      "text"
                                      :value     @input-name
                                      :on-change #(reset! input-name (target-value %))
                                      :maxLength "40"}]]
       [:blue-button
        [:button.blue-button.prof-name-button {:type     "button"
                                               :on-click #(reset! profile-name-atom @input-name)}
         [:div {:class "digi-ng-button__content"} "Spara"]]]]
      [:prof-error-message]]))

(defn dummy1
  []
  [:div
   [:h2 "Title"]
   [:div "Morbi a metus. Phasellus enim erat, vestibulum vel, aliquam a, posuere eu, velit. Nullam sapien sem, ornare ac, nonummy non, lobortis a, enim. Nunc tincidunt ante vitae massa. Duis ante orci, molestie vitae, vehicula venenatis, tincidunt ac, pede. Nulla accumsan, elit sit amet varius semper, nulla mauris mollis quam, tempor suscipit diam nulla vel leo. Etiam commodo dui eget wisi. Donec iaculis gravida nulla. Donec quis nibh at felis congue commodo. Etiam bibendum elit eget erat. Morbi a metus. Phasellus enim erat, vestibulum vel, aliquam a, posuere eu, velit. Nullam sapien sem, ornare ac, nonummy non, lobortis a, enim. Nunc tincidunt ante vitae massa. Duis ante orci, molestie vitae, vehicula venenatis, tincidunt ac, pede. Nulla accumsan, elit sit amet varius semper, nulla mauris mollis quam, tempor suscipit diam nulla vel leo. Etiam commodo"]])

(defn dummy2
  []
  [:div
   [:h2 "Title"]
   [:div "Morbi a metus. Phasellus enim erat, vestibulum vel, aliquam a, posuere eu, velit. Nullam sapien sem, ornare ac, nonummy non, lobortis a, enim. Nunc tincidunt ante vitae massa. Duis ante orci, molestie vitae, vehicula venenatis, tincidunt ac, pede. Nulla accumsan, elit sit amet varius semper, nulla mauris mollis quam, tempor suscipit diam nulla vel leo. Etiam commodo dui eget wisi. Donec iaculis gravida nulla. Donec quis nibh at felis congue commodo. Etiam bibendum elit eget erat. Morbi a metus. Phasellus enim erat, vestibulum vel, aliquam a, posuere eu, velit. Nullam sapien sem, ornare ac, nonummy non, lobortis a, enim. Nunc tincidunt ante vitae massa. Duis ante orci, molestie vitae, vehicula venenatis, tincidunt ac, pede. Nulla accumsan, elit sit amet varius semper, nulla mauris mollis quam, tempor suscipit diam nulla vel leo. Etiam commodo"]])

(defn dummy3
  []
  [:div
   [:h2 "Title"]
   [:div "Morbi a metus. Phasellus enim erat, vestibulum vel, aliquam a, posuere eu, velit. Nullam sapien sem, ornare ac, nonummy non, lobortis a, enim. Nunc tincidunt ante vitae massa. Duis ante orci, molestie vitae, vehicula venenatis, tincidunt ac, pede. Nulla accumsan, elit sit amet varius semper, nulla mauris mollis quam, tempor suscipit diam nulla vel leo. Etiam commodo dui eget wisi. Donec iaculis gravida nulla. Donec quis nibh at felis congue commodo. Etiam bibendum elit eget erat. Morbi a metus. Phasellus enim erat, vestibulum vel, aliquam a, posuere eu, velit. Nullam sapien sem, ornare ac, nonummy non, lobortis a, enim. Nunc tincidunt ante vitae massa. Duis ante orci, molestie vitae, vehicula venenatis, tincidunt ac, pede. Nulla accumsan, elit sit amet varius semper, nulla mauris mollis quam, tempor suscipit diam nulla vel leo. Etiam commodo"]])

(defn dummy4
  []
  [:div
   [:h2 "Title"]
   [:div "Morbi a metus. Phasellus enim erat, vestibulum vel, aliquam a, posuere eu, velit. Nullam sapien sem, ornare ac, nonummy non, lobortis a, enim. Nunc tincidunt ante vitae massa. Duis ante orci, molestie vitae, vehicula venenatis, tincidunt ac, pede. Nulla accumsan, elit sit amet varius semper, nulla mauris mollis quam, tempor suscipit diam nulla vel leo. Etiam commodo dui eget wisi. Donec iaculis gravida nulla. Donec quis nibh at felis congue commodo. Etiam bibendum elit eget erat. Morbi a metus. Phasellus enim erat, vestibulum vel, aliquam a, posuere eu, velit. Nullam sapien sem, ornare ac, nonummy non, lobortis a, enim. Nunc tincidunt ante vitae massa. Duis ante orci, molestie vitae, vehicula venenatis, tincidunt ac, pede. Nulla accumsan, elit sit amet varius semper, nulla mauris mollis quam, tempor suscipit diam nulla vel leo. Etiam commodo"]])


(def card-list [{:title "Presentation och önskat yrke" :body [dummy1]}
                {:title "Arbetslivserfarenhet och utbildning" :body [dummy2]}
                {:title "Kompetenser och övriga meriter" :body [dummy3]}
                {:title "Anställningsvillkor och kontaktsätt" :body [dummy4]}])

(defn section-job
  []
  [:div {:class "sect"}
   [:h2 "Fyll i uppgifter om dig och jobben du söker"]
   [:p {:class "s1"} "Här börjar du bygga upp ett komplett cv för jobben du vill ha. De avsnitt som är märkta “frivillig uppgift” går att hoppa över. Profilen sparas automatiskt i Mina profiler."]
   [accordion 33 card-list]
   ])

(defn content
  []
  [:div {:class "cont"}
   [:h1 {:class "create-profile"} "Skapa profil"]
   [section-name]
   [section-job]])

(defn body
  []
  [:body-section
   [notification "Glöm inte att publicera din profil för att göra den synlig för arbetsgivare"]
   [content]
   (when (not-empty @profile-name-atom)
       [:div {:class "example-text"} "Profile name: " @profile-name-atom])])


(defn component
  []
  [:div
   [header]
   [link-back]
   [body]])
