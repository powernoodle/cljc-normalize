(ns normalize.core
  (:require [garden.core :refer [css]]
            [garden.color :as color]
            [garden.selectors :as s]
            [garden.color :refer [rgb]]
            [garden.units :refer [em px percent]]))

(s/defpseudoclass   -moz-focusring)
(s/defpseudoelement -moz-focus-inner)
(s/defpseudoelement -webkit-file-upload-button)
(s/defpseudoelement -webkit-inner-spin-button)
(s/defpseudoelement -webkit-outer-spin-button)
(s/defpseudoelement -webkit-search-cancel-button)
(s/defpseudoelement -webkit-search-decoration)

(def document
  [(comment "1. Correct the line height in all browsers."
            "2. Prevent adjustments of font size after orientation changes in"
            "   IE on Windows Phone and in iOS.")
   [:html {:line-height 1.15
           :-ms-text-size-adjust (percent 100)
           :-webkit-text-size-adjust (percent 100)}]])

(def sections
  [(comment "Add the correct display in IE 9-.")
   [:article :aside :footer :header :nav :section
    {:display "block"}]
   (comment "Correct the font size and margin on `h1` elements within `section`"
            "and `article` contexts in Chrome, Firefox, and Safari.")
   [:h1
    {:font-size (em 2)
     :margin [[(em 0.67) 0]]}]])

(def grouping-content
  [(comment "Add the correct display in IE 9-."
            "1. Add the correct display in IE.")
   [:figcaption :figure :main
    {;; 1
     :display :block}]
   (comment "Add the correct margin in IE 8.")
   [:figure
    {:margin [[(em 1) (px 40)]]}]
   (comment "1. Add the correct box sizing in Firefox."
            "2. Show the overflow in Edge and IE.")
   [:hr
    {;; 1
     :box-sizing :content-box
     ;; 1
     :height 0
     ;; 2
     :overflow :visible}]
   (comment
     "1. Correct the inheritance and scaling of font size in all browsers."
     "2. Correct the odd `em` font sizing in all browsers.")
   [:pre
    {;; 1
     :font-family [:monospace :monospace]
     ;; 2
     :font-size (em 1)}]])

(def text-level-semantics
  [(comment "1. Remove the gray background on active links in IE 10."
            "2. Remove gaps in links underline in iOS 8+ and Safari 8+.")
   [:a
    {;; 1
     :background-color :transparent
     ;; 2
     :-webkit-text-decoration-skip :objects}]
   (comment "1. Remove the bottom border in Chrome 57- and Firefox 39-."
            "2. Add the correct text decoration in"
            "   Chrome, Edge, IE, Opera, and Safari.")
   [(s/abbr (s/attr :title))
    {;; 1
     :border-bottom :none
     ;; 2
     :text-decoration :underline}
    {;; 2
     :text-decoration [[:underline :dotted]]
     }]
   (comment "Prevent the duplicate application of `bolder` by the next"
            "rule in Safari 6.")
   [:b :strong
    {:font-weight :inherit}]
   (comment "Add the correct font weight in Chrome, Edge, and Safari.")
   [:b :strong
    {:font-weight :bolder}]
   (comment
     "1. Correct the inheritance and scaling of font size in all browsers."
     "2. Correct the odd `em` font sizing in all browsers.")
   [:code :kbd :samp
    {;; 1
     :font-family [:monospace :monospace]
     ;; 2
     :font-size (em 1)}]
   (comment "Add the correct font style in Android 4.3-.")
   [:dfn
    {:font-style :italic}]
   (comment "Add the correct background and color in IE 9-.")
   [:mark
    {:background-color (-> (color/rgb [255 255 0]) color/as-hex)
     :color (-> (color/rgb [0 0 0]) color/as-hex)}]
   (comment "Add the correct font size in all browsers.")
   [:small
    {:font-size (percent 80)}]
   (comment "Prevent `sub` and `sup` elements from affecting the line height"
            "in all browsers.")
   [:sub :sup
    {:font-size (percent 75)
     :line-height 0
     :position :relative
     :vertical-align :baseline}]
   [:sub
    {:bottom (em -0.25)}]
   [:sup
    {:top (em -0.5)}]])

(def embedded-content
  [(comment "Add the correct display in IE 9-.")
   [:audio :video
    {:display :inline-block}]
   (comment "Add the correct display in iOS 4-7.")
   [(s/audio (s/not (s/attr :controls)))
    {:display :none
     :height 0}]
   (comment "Remove the border on images inside links in IE 10-.")
   [:img
    {:border-style :none}]
   (comment "Hide the overflow in IE.")
   [(s/svg (s/not (s/root)))
    {:overflow :hidden}]])

(def forms
  [(comment "Remove the margin in Firefox and Safari.")
   [:button :input :optgroup :select :textarea
    {:margin 0}]
   (comment "Show the overflow in IE."
            "1. Show the overflow in Edge.")
   [:button :input
    {;; 1
     :overflow :visible}]
   (comment "Remove the inheritance of text transform in Edge, Firefox, and IE."
            "1. Remove the inheritance of text transform in Firefox.")
   [:button :select
    {;; 1
     :text-transform :none}]
   (comment
     "1. Prevent a WebKit bug where (2) destroys native `audio` and `video`"
     "   controls in Android 4."
     "2. Correct the inability to style clickable types in iOS and Safari.")
   [:button
    (s/html (s/attr= :type :button)) ;; 1
    (s/attr= :type :reset)
    (s/attr= :type :submit)
    {;; 2
     :-webkit-appearance :button}]
   (comment "Remove the inner border and padding in Firefox.")
   [(s/button -moz-focus-inner)
    ((s/attr= :type :button) -moz-focus-inner)
    ((s/attr= :type :reset) -moz-focus-inner)
    ((s/attr= :type :submit) -moz-focus-inner)
    {:border-style :none
     :padding 0}]
   (comment "Restore the focus styles unset by the previous rule.")
   [(s/button -moz-focusring)
    ((s/attr= :type :button) -moz-focusring)
    ((s/attr= :type :reset) -moz-focusring)
    ((s/attr= :type :submit) -moz-focusring)
    {:outline [[(px 1) :dotted :ButtonText]]}]
   (comment
     "1. Correct the text wrapping in Edge and IE."
     "2. Correct the color inheritance from `fieldset` elements in IE."
     "3. Remove the padding so developers are not caught out when they zero out"
     "   `fieldset` elements in all browsers.")
   [:legend
    {;; 1
     :box-sizing :border-box
     ;; 2
     :color :inherit
     ;; 1
     :display :table
     ;; 1
     :max-width (percent 100)
     ;; 3
     :padding 0
     ;; 1
     :white-space :normal}]
   (comment
     "1. Add the correct display in IE 9-."
     "2. Add the correct vertical alignment in Chrome, Firefox, and Opera.")
   [:progress
    {;; 1
     :display :inline-block
     ;; 2
     :vertical-align :baseline}]
   (comment "Remove the default vertical scrollbar in IE.")
   [:textarea
    {:overflow :auto}]
   (comment "1. Add the correct box sizing in IE 10-."
            "2. Remove the padding in IE 10-.")
   [(s/attr= :type :checkbox)
    (s/attr= :type :radio)
    {;; 1
     :box-sizing :border-box
     ;; 2
     :padding 0}]
   (comment
     "Correct the cursor style of increment and decrement buttons in Chrome.")
   [((s/attr= :type :number) -webkit-inner-spin-button)
    ((s/attr= :type :number) -webkit-outer-spin-button)
    {:height :auto}]
   (comment "1. Correct the odd appearance in Chrome and Safari."
            "2. Correct the outline style in Safari.")
   [(s/attr= :type :search)
    {;; 1
     :-webkit-appearance :textfield
     ;; 2
     :outline-offset (px -2)}]
   (comment "Remove the inner padding and cancel buttons in Chrome"
            "and Safari on macOS.")
   [((s/attr= :type :search) -webkit-search-cancel-button)
    ((s/attr= :type :search) -webkit-search-decoration)
    {:-webkit-appearance :none}]
   (comment
     "1. Correct the inability to style clickable types in iOS and Safari."
     "2. Change font properties to `inherit` in Safari.")
   [-webkit-file-upload-button
    {;; 1
     :-webkit-appearance :button
     ;; 2
     :font :inherit}]])

(def interactive
  [(comment "Add the correct display in IE 9-."
            "1. Add the correct display in Edge, IE, and Firefox.")
   [:details ;;1
    :menu
    {:display :block}]
   (comment "Add the correct display in all browsers.")
   [:summary
    {:display :list-item}]])

(def scripting
  [(comment "Add the correct display in IE 9-.")
   [:canvas
    {:display :inline-block}]
   (comment "Add the correct display in IE.")
   [:template
    {:display :none}]])

(def hidden
  [(comment "Add the correct display in IE 10-.")
   [(s/attr :hidden)
    {:display :none}]])

(def normalize
  [document
   sections
   grouping-content
   text-level-semantics
   embedded-content
   forms
   interactive
   scripting
   hidden])

(def normalize-css
  (css {:pretty-print? false} normalize))

(defn -main
  []
  (println normalize-css))
