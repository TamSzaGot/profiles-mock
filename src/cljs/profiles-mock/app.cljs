(ns profiles-mock.app)

;; -- VIEW --------------------------------------------------------------------

(defn header
  []
  [:header {:class "sv-vertical sv-layout cms notranslate sv-skip-spacer sv-template-layout", :id "svid10_7f0846ac15f0dd8153b12e65"}
 [:div {:class "sv-layout sv-skip-spacer sv-template-portlet", :id "svid30_7f0846ac15f0dd8153b12ea2"}
  [:div {:id "headerlankas"}]
  [:div {:class "sv-script-portlet sv-portlet sv-skip-spacer sv-template-portlet", :id "svid12_7f0846ac15f0dd8153b14a8b"}
   [:div {:id "menystruktur"}]
   [:nav {:class "header-nav", :role "navigation", :aria-label "Global navigering"}
    [:div {:class "container"}
     [:ul {:class "header-list"}
      [:li {:class "header-list__item"}
       [:a {:class "header-list__link header-list__link--logo", :href "#"}
        [:img {:class "header-list__img", :src "img/logo.svg", :alt "Arbetsförmedlingen - till startsidan"}]]]
      [:li {:class "header-list__item header-list__item--search d-md-none"}
       [:button {:class "btn btn-link header-list__link header-list__link--search js-search-toggle"}
        [:i {:class "i-af-search", :aria-hidden "true"}]
        [:span {:class "sr-only"} "Sök"]]]]
     [:ul {:class "role-nav d-none d-lg-flex"}
      [:li {:class "role-nav__item"} ]
      [:li {:class "role-nav__item"} ]]
     [:ul {:class "functions-nav d-none d-md-flex"}
      [:li {:class "functions-nav__item"}
       [:a {:href "#", :class "functions-nav__link"}
        [:i {:class "i-af-user-alt", :aria-hidden "true"}]"Logga ut"]]
      [:li {:class "functions-nav__item"}
       [:a {:href "#", :class "functions-nav__link functions-nav__link--lang"}
        [:i {:class "i-l-languages", :aria-hidden "true"}]
        [:span {:class "functions-nav__link--hidden"} "Languages"]]]
      [:li {:class "functions-nav__item"}
       [:button {:class "btn btn-link functions-nav__link functions-nav__link--search js-search-toggle"}
        [:i {:class "i-af-search", :aria-hidden "true"}]
        [:span {:class "functions-nav__link--hidden"} "Sök"]]]
      [:li {:class "functions-nav__item"}
       [:button {:class "btn btn-link functions-nav__link js-open-menu"}
        [:i {:class "i-bars", :aria-hidden "true"}]
        [:span {:class "functions-nav__link--hidden"} "Meny"]]]]]
    [:div {:class "main-menu__overlay", :aria-hidden "true"}]]
   [:nav {:class "header-nav d-md-none", :role "navigation", :aria-label "Mobilanpassad global navigering"}
    [:div {:class "container"}
     [:ul {:class "functions-nav"}
      [:li {:class "functions-nav__item d-none d-md-flex"}
       [:a {:href "#", :class "functions-nav__link js-search-toggle"}
        [:i {:class "i-af--search", :aria-hidden "true"}]"Sök"]]
      [:li {:class "functions-nav__item"} "\t"
       [:a {:href "#", :class "functions-nav__link"}
        [:i {:class "i-af-user-alt", :aria-hidden "true"}]"Logga ut"]]
      [:li {:class "functions-nav__item"}
       [:button {:class "btn btn-link btn-block functions-nav__link js-open-menu"}
        [:i {:class "i-bars", :aria-hidden "true"}]"Meny"]]]]]]]])

(defn notification
  [message]
  [:digi-ng-notification-alert {:class "d-block ng-star-inserted"}
   [:div {:data-digi-ng-component "", :class "my-4 digi-ng-notification-alert digi-ng-notification-alert--closeable digi-ng-notification-alert--l digi-ng-notification-alert--info", :aria-live "assertive"}
    [:digi-ng-layout-media-object
     [:div {:data-digi-ng-component "", :class "digi-ng-layout-media-object digi-ng-layout-media-object--align-center"}
      [:div {:class "digi-ng-layout-media-object__first"}
       [:div {:data-slot-first "", :class "digi-ng-notification-alert__icon"}
        [:digi-ng-layout-icon-container
         [:div {:data-digi-ng-component "", :data-digi-ng-icon-adaptive "", :class "digi-ng-layout-icon-container digi-ng-layout-icon-container--m"}
          [:digi-ng-icon-info-circle-reg {:class "ng-star-inserted"}
           [:svg {:width "42", :height "42", :viewBox "0 0 42 42", :xmlns "http://www.w3.org/2000/svg", :class "digi-ng-icon-info-circle-reg"}
            [:g {:fill "currentColor", :fill-rule "nonzero", :class "digi-ng-icon-info-circle-reg__shape"}
             [:path {:d "M21 39c9.941 0 18-8.059 18-18S30.941 3 21 3 3 11.059 3 21s8.059 18 18 18zm0 3C9.402 42 0 32.598 0 21S9.402 0 21 0s21 9.402 21 21-9.402 21-21 21z"}]
             [:path {:d "M22 10c2.071 0 3.75 1.485 3.75 3.316 0 1.831-1.679 3.316-3.75 3.316-2.071 0-3.75-1.485-3.75-3.316C18.25 11.485 19.929 10 22 10zm5 20.053c0 .523-.48.947-1.071.947H18.07C17.48 31 17 30.576 17 30.053v-1.895c0-.523.48-.947 1.071-.947h1.072v-5.053H18.07c-.591 0-1.071-.424-1.071-.947v-1.895c0-.523.48-.948 1.071-.948h5.715c.591 0 1.071.425 1.071.948v7.895h1.072c.591 0 1.071.424 1.071.947v1.895z"} ]]]]]]]]
      [:div {:class "digi-ng-layout-media-object__last"}
       [:div {:data-slot-last "", :class "digi-ng-notification-alert__text"}
        [:button {:type "button", :class "digi-ng-notification-alert__close-button ng-star-inserted", :aria-label "Stäng meddelandet"}
         [:p {:class "digi-ng-notification-alert__close-button-text"} "Stäng"]
         [:digi-ng-icon-x {:aria-hidden "true", :class "digi-ng-notification-alert__close-button-icon"}
          [:svg {:width "12", :height "12", :viewBox "0 0 12 12", :xmlns "http://www.w3.org/2000/svg", :class "digi-ng-icon-x"}
           [:g {:stroke "currentColor", :stroke-width "2", :fill "none", :fill-rule "evenodd", :stroke-linecap "square", :class "digi-ng-icon-x__shape"}
            [:path {:d "M2 2l7.986 7.986M9.986 2L2 9.986"}]]]]]
        [:div {:class "digi-ng-notification-alert__message-container"}
         [:div {:class "digi-ng-notification-alert__content"} message ]]]]]]]])

(defn notification1
  [message]
  [:div {:class "container"}
   [:img {:class "rupoc-img", :src "img/rupoc.svg"}]
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
  [:prof-profile-name
   [:div {:class "section-plate section-plate-details"}
    [:h2 "Ge profilen ett namn"]
    [:p {:class "mb-3"} "Namnet är synligt bara för dig och du kan när du vill ändra profilnamnet."]
    [:form {:noValidate "", :class "form-inline form-name"}
     [:div {:class "custom1"}
      [:div {:class "form-group mb-2 mr-md-3"}
       [:label {:for "namn", :class "sr-only"} "Namn"]
       [:input {:type "text", :id "namn", :required "", :class "form-control custom1", :maxLength "40"}]]]
     [:div {:class "prof-state-button-sm-down-block mb-2"}
      [:digi-ng-button-base
       [:button {:class "digi-ng-button-base digi-ng-button-base--primary digi-ng-button-base--m", :type "button"}
        [:div {:class "digi-ng-button__content"} "Spara"]]]]]
    [:prof-error-message]]])

(defn body
 []
 [:prof-root {:class "prof-root", :lang "sv", :ng-version "10.2.3"}
  [:div {:class "prof-root-container"}
   [:img {:alt "beta", :class "beta-img", :src "css/beta-flag.svg"}]
   [:prof-details-page {:class "ng-star-inserted"}
    [:div {:class "container ng-star-inserted"}
    [:prof-navigation-section {:_ngcontent-var-c122 "", :class "ng-star-inserted"}
    [:div {:class "d-flex justify-content-between align-items-center mb-4"}
     [:a {:class "link-back", :href "#"}
      [:digi-ng-icon-arrow-left {:_nghost-var-c27 ""}
       [:svg {:width "9", :height "14", :viewBox "0 0 9 14", :xmlns "http://www.w3.org/2000/svg", :data-digi-ng-component "", :class "digi-ng-icon-arrow-left"}
        [:path {:d "M8 13L2 6.926 7.853 1", :stroke "currentColor", :stroke-width "2", :fill "none", :fill-rule "evenodd", :class "digi-ng-icon-arrow-left__shape"}]]]" Mina profiler"]
     [:div {:class "d-flex align-items-center"}
      [:digi-ng-button-icon-text {:afreverse "true"}
       [:digi-ng-button-base
        [:button {:data-digi-ng-component "", :class "digi-ng-button-base digi-ng-button-base--primary digi-ng-button-base--m", :type "button"}
         [:div {:class "digi-ng-button-icon-text__content"}
          [:digi-ng-typography-icon-text {:_ngcontent-var-c40 "", :_nghost-var-c28 ""}
           [:div {:data-digi-ng-component "", :class "digi-ng-typography-icon-text digi-ng-typography-icon-text--reverse digi-ng-typography-icon-text--relative-icon-size"}
            [:span {:class "digi-ng-typography-icon-text__text ng-star-inserted"} "Granska"]
            [:div {:class "digi-ng-typography-icon-text__icon"}
             [:digi-ng-icon-arrow-right {:_nghost-var-c5 "", :class "ng-star-inserted"}
              [:svg {:width "9", :height "14", :viewBox "0 0 9 14", :xmlns "http://www.w3.org/2000/svg", :data-digi-ng-component "", :class "digi-ng-icon-arrow-right"}
               [:path {:d "M1 13l6-6.074L1.147 1", :stroke "currentColor", :stroke-width "2", :fill "none", :fill-rule "evenodd", :class "digi-ng-icon-arrow-right__shape"}]]]]]]]]]]]]]
      (notification "Glöm inte att publicera din profil för att göra den synlig för arbetsgivare")
      [:h1 {:class "create-profile"} "Skapa profil"]
      (profile-name)
      [:div {:class "example-text"} "this is a text"]
      ]]]])

(defn footer
  []
  [:footer
 [:div {:class "footer-wrapper"}
  [:div {:class "container footer"}
   [:div {:class "row footer-top"}
    [:div {:class "footer-col1 col-md-8"}
     [:div {:class "row footer-services"}
      [:div {:class "col-md-6"}
       [:ul {:class "footer-links list-unstyled"}
        [:li {:class "footer-links__item"}
         [:a {:href "#", :class "footer-links__link"}
          [:i {:class "i-l-languages"}]"Other languages"]]
        [:li {:class "footer-links__item"}
         [:a {:href "#", :class "footer-links__link"}
          [:i {:class "i-af-sign"}]"Teckenspråk"]]
        [:li {:class "footer-links__item"}
         [:a {:href "#", :class "footer-links__link", :data-event-category "AS - Webbplatsen", :data-event-action "AS - Webbplatsen - Sidfot - Tillgänglighet - Link - Click", :data-event-name "AS - Webbplatsen - Tillgänglighet", :data-event-value "1"}
          [:i {:class "i-universal-access"}]"Tillgänglighetsredogörelse"]]]]
      [:div {:class "col-md-6"}
       [:ul {:class "footer-links list-unstyled"}
        [:li {:class "footer-links__item"}
         [:a {:href "#", :class "footer-links__link", :data-event-category "AS - All products", :data-event-action "AS - All products - Kontakta oss - Footer - Link - Click", :data-event-name "AS - All products - Kontakt", :data-event-value "1"}
          [:i {:class "kontakta-oss-ikon"}]"Kontakta oss"]]
        [:li {:class "footer-links__item meeting-item"}
         [:button {:class "meeting-button footer-links__link"}
          [:i {:class "i-arrow-square-right"}]"Möteskod"]]]]]
     [:div {:class "row footer-global"}
      [:div {:class "col-md"}
       [:ul {:class "footer-links list-unstyled"}
        [:li {:class "footer-links__item"}
         [:a {:href "#", :class "footer-links__link", :data-event-category "AS - Webbplatsen", :data-event-action "AS - Webbplatsen - Sidfot - Press och media - Link - Click", :data-event-name "AS - Webbplatsen - Press", :data-event-value "1"} "För press och media"]]
        [:li {:class "footer-links__item"}
         [:a {:href "#", :class "footer-links__link"} "För leverantörer"]]
        [:li {:class "footer-links__item"}
         [:a {:href "#", :class "footer-links__link"} "För hälso- och sjukvården"]]
        [:li {:class "footer-links__item"}
         [:a {:href "#", :class "footer-links__link"} "Om webbplatsen"]]
        [:li {:class "footer-links__item"}
         [:a {:class "footer-links__link", :href "#"} "Så hanterar vi dina personuppgifter"]]]]]]
    [:div {:class "footer-col2 col-md-4"}
     [:ul {:class "main-menu main-menu--role"}
      [:li {:class "main-menu__item"}
       [:a {:href "#", :class "main-menu__link"}
        [:p {:class "main-menu__link--heading"} "Arbetsgivare"]
        [:p {:class "main-menu__link--desc"} "När du behöver rekrytera hjälper vi dig att hitta värdefull kompetens"]
        [:span {:class "i-stack", :aria-hidden "true"}
         [:i {:class "i-circle"}]
         [:i {:class "i-angle-right"}]]]]
      [:li {:class "main-menu__item"}
       [:a {:href "#", :class "main-menu__link"}
        [:p {:class "main-menu__link--heading"} "Om oss"]
        [:p {:class "main-menu__link--desc"} "När du vill veta mer om vår myndighet och våra uppdrag"]
        [:span {:class "i-stack", :aria-hidden "true"}
         [:i {:class "i-circle"}]
         [:i {:class "i-angle-right"}]]]]
      [:li {:class "main-menu__item"}
       [:a {:href "#", :class "main-menu__link"}
        [:p {:class "main-menu__link--heading", :data-event-category "AS - Webbplatsen", :data-event-action "AS - Webbplatsen - Sidfot - Statistik - Link - Click", :data-event-name "AS - Webbplatsen - Statistik", :data-event-value "1"} "Statistik"]
        [:p {:class "main-menu__link--desc"} "När du vill ha statistik och analyser"]
        [:span {:class "i-stack", :aria-hidden "true"}
         [:i {:class "i-circle"}]
         [:i {:class "i-angle-right"}]]]]]]]
   [:div {:class "row footer-bottom"}
    [:div {:class "col-md-5"}
     [:div {:class "footer__logo-container"}
      [:a {:class "footer__logo-link", :href "#"}
       [:img {:class "footer__logo", :src "img/logo-vit.svg", :alt "Arbetsförmedlingen"}]]]]
    [:div {:class "col-md-7 footer-social"}
     [:span {:class "footer-social__heading"} "Följ oss på"]
     [:a {:class "footer-social__link", :aria-label "Besök vår sida på Facebook", :href "#"} "Facebook"]
     [:a {:class "footer-social__link", :aria-label "Besök vår sida på Linkedin", :href "#"} "Linkedin"]
     [:a {:class "footer-social__link", :aria-label "Besök vår sida på Youtube", :href "#"} "Youtube"]]]]]])

(defn component
  []
  [:div
   (header)
   (body)
   (footer)])

