(defproject duct.logger.honeybadger "0.1.0"
  :description "A Timbre appender that sends log events into Honeybadger for Duct framework"
  :url "https://github.com/Zimpler/duct.logger.honeybadger"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}

  :dependencies [[duct/core "0.6.2"]
                 [integrant "0.6.3"]]

  :cloverage {:fail-threshold 95
              :ns-exclude-regex [#"dev" #"user"]}

  :profiles {:dev {:plugins [[lein-cloverage "1.0.11"]
                             [lein-kibit "0.1.6"]
                             [jonase/eastwood "0.2.8"]
                             [venantius/ultra "0.5.2"]]
                   :dependencies [[org.clojure/clojure "1.9.0"]]
                   :source-paths ["src" "dev/src"]}
             :test {:dependencies [[org.clojure/clojure "1.9.0"]]}})
