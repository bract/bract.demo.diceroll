(defproject bract/demo.diceroll "0.5.0-SNAPSHOT"
  :description "Bract sample Ring webapp to roll a dice"
  :url "https://github.com/bract/demo.diceroll"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :global-vars {*warn-on-reflection* true
                *assert* true
                *unchecked-math* :warn-on-boxed}
  :min-lein-version "2.7.1"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [bract/bract.cli     "0.5.0-SNAPSHOT"]
                 [bract/bract.ring    "0.5.0-SNAPSHOT"]
                 ;; web
                 [ring/ring-core "1.6.3"]
                 [http-kit "2.2.0"]]
  :target-path "target/%s"
  :plugins [[lein-ring "0.12.3"]]
  :ring {:handler bract.ring.dev/handler
         :init    bract.ring.dev/init!
         :port    3000
         :nrepl   {:start? true :port 3001}}
  :profiles {:dev {:dependencies [[bract/bract.dev "0.5.0-SNAPSHOT"]]
                   :source-paths ["dev"]}
             :uberjar {:aot [bract.cli.main]
                       :main ^:skip-aot bract.cli.main
                       :pedantic? :abort}})
