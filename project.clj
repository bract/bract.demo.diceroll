(defproject bract/bract.demo.diceroll "0.2.0-SNAPSHOT"
  :description "Bract sample Ring webapp to roll a dice"
  :url "https://github.com/bract/bract.demo.diceroll"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :global-vars {*warn-on-reflection* true
                *assert* true
                *unchecked-math* :warn-on-boxed}
  :min-lein-version "2.7.1"
  :pedantic? :abort
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [bract/bract.cli  "0.2.0-SNAPSHOT"]
                 [bract/bract.ring "0.2.0-SNAPSHOT"]
                 ;; web
                 [ring/ring-core "1.5.1"]
                 [http-kit "2.2.0"]]
  :main ^:skip-aot bract.cli.main
  :target-path "target/%s"
  :plugins [[lein-ring "0.11.0"]]
  :ring {:handler bract.ring.dev/handler
         :init    bract.ring.dev/init!
         :port    3000
         :nrepl   {:start? true :port 3001}}
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]
                   :source-paths ["dev"]}
             :uberjar {:aot [bract.cli.main]}})
