# normalize

A Clojure library that ports [normalize.css](http://necolas.github.io/normalize.css/) to [Garden](https://github.com/noprompt/garden).

## Usage

Add the following dependency to your project.clj file:

```
[normalize "0.1.0-SNAPSHOT"]
```

## Example


```clojure
(ns example
  (:require [hiccup.page :refer [html5]]
            [garden.core :refer [css]]
            [normalize.core :refer [normalize]]))

(defn index []
  (html5 {:lang "en"}
         [:head
                [:title "Hello World"]
                [:style (css normalize)]]
         [:body
                [:h1 "hello world!"]]))
```

The above example contains an `index` function that will generate HTML including an inline `<style>` tag containing the normalize styles. Alternatively, you can choose to render this content to an external file.
