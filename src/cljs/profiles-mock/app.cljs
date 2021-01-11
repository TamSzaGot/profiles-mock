(ns profiles-mock.app)

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
  [:div {:class "cont"}
   [:div {:class "notification"}
    [:div {:class "notification-icon"}
     [:svg {:width "42", :height "42", :viewBox "0 0 42 42", :xmlns "http://www.w3.org/2000/svg"}
      [:g {:fill "currentColor", :fill-rule "nonzero"}
       [:path {:d "M21 39c9.941 0 18-8.059 18-18S30.941 3 21 3 3 11.059 3 21s8.059 18 18 18zm0 3C9.402 42 0 32.598 0 21S9.402 0 21 0s21 9.402 21 21-9.402 21-21 21z"}]
       [:path {:d "M22 10c2.071 0 3.75 1.485 3.75 3.316 0 1.831-1.679 3.316-3.75 3.316-2.071 0-3.75-1.485-3.75-3.316C18.25 11.485 19.929 10 22 10zm5 20.053c0 .523-.48.947-1.071.947H18.07C17.48 31 17 30.576 17 30.053v-1.895c0-.523.48-.947 1.071-.947h1.072v-5.053H18.07c-.591 0-1.071-.424-1.071-.947v-1.895c0-.523.48-.948 1.071-.948h5.715c.591 0 1.071.425 1.071.948v7.895h1.072c.591 0 1.071.424 1.071.947v1.895z"}]]]]
    [:div {:class "notification-content"}
     [:button {:type "button", :class "notification-close", :aria-label "Stäng meddelandet"}
      [:div {:class "notification-close-text"} "Stäng"]
      [:div {:class "icon-x"}
       [:svg {:width "12", :height "12", :viewBox "0 0 12 12", :xmlns "http://www.w3.org/2000/svg"}
        [:g {:stroke "currentColor", :stroke-width "2", :fill "none", :fill-rule "evenodd", :stroke-linecap "square"}
         [:path {:d "M2 2l7.986 7.986M9.986 2L2 9.986"}]]]]]
     [:div message]]]])

(defn profile-name
  []
  [:div {:class "cont"}
   [:div {:class "sect"}
    [:h2 "Ge profilen ett namn"]
    [:p {:class "s1"} "Namnet är synligt bara för dig och du kan när du vill ändra profilnamnet."]
    [:form {:class "form-inl"}
     [:prof-name-input
      [:input {:class "prof-name-input", :type "text", :id "namn", :maxLength "40"}]]
     [:blue-button
      [:button {:class "blue-button prof-name-button", :type "button"}
       [:div "Spara"]]]]
    [:prof-error-message]]])

(defn body
  []
  [:body-section
   (notification "Glöm inte att publicera din profil för att göra den synlig för arbetsgivare")
   [:div {:class "cont"}
    [:h1 {:class "create-profile"} "Skapa profil"]]
   (profile-name)
   [:div {:class "example-text"} "this is a text"]])


(defn component
  []
  [:div
   (header)
   (link-back)
   (body)])

