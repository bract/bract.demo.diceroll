(defproject bract/demo.diceroll "0.4.1-SNAPSHOT"
  :description "Bract sample Ring webapp to roll a dice"
  :url "https://github.com/bract/demo.diceroll"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :global-vars {*warn-on-reflection* true
                *assert* true
                *unchecked-math* :warn-on-boxed}
  :min-lein-version "2.7.1"
  :pedantic? :abort
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [bract/bract.cli     "0.4.1"]
                 [bract/bract.ring    "0.4.1"]
                 ;; web
                 [ring/ring-core "1.6.1"]
                 [http-kit "2.2.0"]]
  :target-path "target/%s"
  :plugins [[lein-ring "0.12.0"]]
  :ring {:handler bract.ring.dev/handler
         :init    bract.ring.dev/init!
         :port    3000
         :nrepl   {:start? true :port 3001}}
  :profiles {:dev {:dependencies [[bract/bract.dev "0.4.1"]]
                   :source-paths ["dev"]}
             :uberjar {:aot [bract.cli.main]
                       :main ^:skip-aot bract.cli.main}})
