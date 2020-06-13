(defproject component "0.1.0-SNAPSHOT"

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.stuartsierra/component "1.0.0"]]


  :main simple.main

  :uberjar-name "simple-main.jar"

  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev     {:plugins [[lein-shell "0.5.0"]]}}

  :aliases
  {"native"
                ["shell"
                 "native-image" "--report-unsupported-elements-at-runtime" "--no-server"
                 "--initialize-at-build-time"
                 "-jar" "./target/${:uberjar-name:-${:name}-${:version}-standalone.jar}"
                 "-H:Name=./target/${:name}"]

   "run-native" ["shell" "./target/${:name}"]})
