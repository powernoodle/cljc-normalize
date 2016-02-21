(ns normalize.core
  (:require [garden.core :refer [css]]
            [garden.selectors :as s]
            [garden.color :refer [rgb]]
            [garden.units :refer [em px percent]]))

(def base
  "normalize.css v3.0.3"
  [(comment "1. Set default font family to sans-serif."
            "2. Prevent iOS and IE text size adjust after device orientation change, without disabling user zoom.")
   [:html {:font-family "sans-serif" ;1
           :-ms-text-size-adjust (percent 100) ;2
           :-webkit-text-size-adjust (percent 100) ;2
           }]
   (comment "Remove default margin.")
   [:body {:margin 0}]])

(def html5
  "HTML5 display definitions."
  [(comment "Correct `block` display not defined for any HTML5 element in IE 8/9."
            "Correct `block` display not defined for `details` or `summary` in IE 10/11 and Firefox."
            "Correct `block` display not defined for `main` in IE 11.")
   [:article :aside :details :figcaption
    :figure :footer :header :main
    :menu :nav :section :summary {:display "block"}]
   (comment "1. Correct `inline-block` display not defined in IE 8/9."
            "2. Normalize vertical alignment of `progress` in Chrome, Firefox, and Opera.")
   [:audio :canvas :progress :video {:display "inline-block" ;1
                                     :vertical-align "baseline" ;2
                                     }]
   (comment "Prevent displaying `audio` without controls in Mobile Safari 4/5/6/7.")
   ["audio:not([controls])" {:display "none"
                             :height 0}]
   (comment "Address `[hidden]` styling not present in IE 8/9/10."
            "Hide the `template` element in IE 8/9/10/11, Safari, and Firefox < 22.")
   ["[hidden]" :template {:display "none"}]])

(def links
  "Links"
  [(comment "Remove the gray background color from active links in IE 10.")
   [:a {:background-color "transparent"}]
   (comment "Improve readability of focused elements when they are also in an active/hover state.")
   [:a [:&:active]
       [:&:hover] {:outline 0}]])

(def text
  "Text-level semantics"
  [(comment "Address inconsistent styling of `abbr[title]`."
            "1. Correct styling in Firefox 39 and Opera 12."
            "2. Correct missing styling in Chrome, Edge, IE, Opera, and Safari.")
   ["abbr[title]" {:border-bottom "none" ;1
                   :text-decoration "underline" ;2
                   }
                  {:text-decoration "underline dotted"} ;2
                  ]
   (comment "Address inconsistent styling of b and strong."
            "1. Correct duplicate application of `bolder` in Safari 6.0.2."
            "2. Correct style set to `bold` in Edge 12+, Safari 6.2+, and Chrome 18+.")
   [:b :strong {:font-weight "inherit"}] ;1
   [:b :strong {:font-weight "bolder"}] ;2
   (comment "Address styling not present in Safari and Chrome.")
   [:dfn {:font-style "italic"}]
   (comment "Address variable `h1` font-size and margin within `section` and `article` contexts in Firefox 4+, Safari, and Chrome.")
   [:h1 {:font-size (em 2)
         :margin [(em 0.67) 0]}]
   (comment "Address styling not present in IE 8/9.")
   [:mark {:background-color (rgb 255 255 0)
           :color (rgb 0 0 0)}]
   (comment "Address inconsistent and variable font size in all browsers.")
   [:small {:font-size (percent 80)}]
   (comment "Prevent `sub` and `sup` affecting `line-height` in all browsers.")
   [:sub :sup {:font-size (percent 75)
               :line-height 0
               :position "relative"
               :vertical-align "baseline"}]
   [:sup {:top (em -0.5)}]
   [:sub {:bottom (em -0.25)}]])

(def embedded
  "Embedded content"
  [(comment "Remove border when inside `a` element in IE 8/9/10.")
   [:img {:border 0}]
   (comment "Correct overflow not hidden in IE 9/10/11.")
   ["svg:not(:root)" {:overflow "hidden"}]])

(def grouping
  "Grouping content"
  [(comment "Address margin not present in IE 8/9 and Safari.")
   [:figure {:margin [(em 1)
                      (px 40)]}]
   (comment "Address inconsistent styling of `hr`."
            "1. Correct `box-sizing` set to `border-box` in Firefox."
            "2. Correct `overflow` set to `hidden` in IE 8/9/10/11 and Edge 12.")
   [:hr {:height 0 ;1
         :overflow "visible" ;2
         }]
   (comment "Contain overflow in all browsers.")
   [:pre {:overflow "auto"}]
   (comment "1. Correct inheritance and scaling of font-size for preformatted text."
            "2. Address odd `em`-unit font size rendering in all browsers.")
   [:code :kbd :pre :samp {:font-family "monospace, monospace" ;1
                           :font-size (em 1) ;2
                           }]])

(def forms
  "Forms"
  [(comment "Known limitation: by default, Chrome and Safari on OS X allow very limited styling of `select`, unless a `border` property is set."
            "1. Correct font properties not being inherited."
            "2. Address margins set differently in Firefox 4+, Safari, and Chrome.")
   [:button :input :optgroup :select :textarea {:font "inherit" ;1
                                                :margin 0 ;2
                                                }]
   (comment "Address `overflow` set to `hidden` in IE 8/9/10/11.")
   [:button {:overflow "visible"}]
   (comment "Address inconsistent `text-transform` inheritance for `button` and `select`."
            "All other form control elements do not inherit `text-transform` values."
            "Correct `button` style inheritance in Firefox, IE 8/9/10/11, and Opera."
            "Correct `select` style inheritance in Firefox.")
   [:button :select {:text-transform "none"}]
   (comment "1. Avoid the WebKit bug in Android 4.0.* where (2) destroys native `audio` and `video` controls."
            "2. Correct inability to style clickable `input` types in iOS."
            "3. Improve usability and consistency of cursor style between image-type `input` and others.")
   [:button
    ["html input[type=\"button\"]"] ;1
    "input[type=\"reset\"]"
    "input[type=\"submit\"]" {:-webkit-appearance "button" ;2
                              :cursor "pointer" ;3
                              }]
   (comment "Re-set default cursor for disabled elements.")
   ["button[disabled]"
    ["html input[disabled]"] {:cursor "pointer"}]
   (comment "Remove inner padding and border in Firefox 4+.")
   ["button::-moz-focus-inner"
    "input::-moz-focus-inner" {:border 0
                               :padding 0}]
   (comment "Replace focus style removed in the border reset above")
   ["button::-moz-focusring"
    "input::-moz-focusring" {:outline "1px dotted ButtonText"}]
   (comment "Address Firefox 4+ setting `line-height` on `input` using `!important` in the UA stylesheet.")
   [:input {:line-height "normal"}]
   (comment "It's recommended that you don't attempt to style these elements."
            "Firefox's implementation doesn't respect box-sizing, padding, or width."
            "1. Address box sizing set to `content-box` in IE 8/9/10."
            "2. Remove excess padding in IE 8/9/10.")
   ["input[type=\"checkbox\"]"
    "input[type=\"radio\"]" {:box-sizing "border-box" ;1
                             :padding 0 ;2
                             }]
   (comment "Fix the cursor style for Chrome's increment/decrement buttons. For certain `font-size` values of the `input`, it causes the cursor style of the decrement button to change from `default` to `text`.")
   ["input[type=\"number\"]::-webkit-inner-spin-button"
    "input[type=\"number\"]::-webkit-outer-spin-button" {:height "auto"}]
   (comment "Address `appearance` set to `searchfield` in Safari and Chrome.")
   ["input[type=\"search\"]" {:-webkit-appearance "textfield"}]
   (comment "Remove inner padding and search cancel button in Safari and Chrome on OS X."
            "Safari (but not Chrome) clips the cancel button when the search input has padding (and `textfield` appearance).")
   ["input[type=\"search\"]::-webkit-search-cancel-button"
    "input[type=\"search\"]::-webkit-search-decoration" {:-webkit-appearance "none"}]
   (comment "Define consistent border, margin, and padding.")
   [:fieldset {:border [(px 1) "solid" (rgb 192 192 192)]
               :margin [0 (px 2)]
               :padding [(em 0.35) (em 0.625) (em 0.75)]}]
   (comment "1. Correct `color` not being inherited in IE 8/9/10/11."
            "2. Remove padding so people aren't caught out if they zero out fieldsets.")
   [:legend {:border 0 ;1
             :padding 0 ;2
             }]
   (comment "Remove default vertical scrollbar in IE 8/9/10/11.")
   [:textarea {:overflow "auto"}]
   (comment "Don't inherit the `font-weight` (applied by a rule above)."
            "NOTE: the default cannot safely be changed in Chrome and Safari on OS X.")
   [:optgroup {:font-weight "bold"}]])

(def normalize
  [base
   html5
   links
   text
   embedded
   grouping
   forms])

(def normalize-css
  (css normalize))

(defn -main
  []
  (println normalize-css))
