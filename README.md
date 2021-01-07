# profiles-mock
A mock of Arbetsförmedlingen MinaSidor/MinaProfiler implementation

# prerequisite
[Leiningen](https://leiningen.org/) build tool and the
[Clojure](https://clojure.org/guides/getting_started) compiler


# the app
The source code for the ClojureScript application is located in src/cljs/profiles-mock/app.cljs and is compiled to JavaScript that is being used from the resources/public/index.html file. a developer environment can be started with:

<pre>
>lein figwheel
</pre>

# playground
The file resources/public/dev.html is currently used for developing a simpler layout. It can be opened with VSCode Live Server directly.

# Usable VS Code plugins
Some usable plugins for development is Calva and clj-condo for Clojure development, and HTML Boilerplate and Beautify for the HTML development.
