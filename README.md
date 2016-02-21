# normalize

A Clojure library that ports [normalize.css](http://necolas.github.io/normalize.css/) to [Garden](https://github.com/noprompt/garden).

## Usage

Add the following dependency to your project.clj file:

```
[normalize "0.1.3"]
```

## Example

To use with Garden just include the normalize css rules in your apps styles list before your other styles and compile normally with Garden.

```clojure
(ns example
  (:require [normalize.core :refer [normalize]]))

(def app-styles
  [normalize
   [:a {:text-decoration "none"}]
   [:button {:text-transform "uppercase"}]])
```

You can also consume the raw css without Garden.

This example contains an `index` function that will generate HTML including an internal `<style>` tag containing the normalize styles. Alternatively, you can choose to render this content to an external file.

```clojure
(ns example
  (:require [hiccup.page :refer [html5]]
            [normalize.core :refer [normalize-css]]))

(defn index
  []
  (html5 {:lang "en"}
         [:head
                [:title "Hello World"]
                [:style normalize-css]]
         [:body
                [:h1 "hello world!"]]))
```
