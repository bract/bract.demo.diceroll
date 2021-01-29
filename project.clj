(defproject bract/demo.diceroll "0.6.2-SNAPSHOT"
  :description "Bract sample Ring webapp to roll a dice"
  :url "https://github.com/bract/demo.diceroll"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :global-vars {*warn-on-reflection* true
                *assert* true
                *unchecked-math* :warn-on-boxed}
  :min-lein-version "2.7.1"
  :pedantic?    :warn
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [bract/bract.cli     "0.6.2-0.1.1-beta2"]
                 [bract/bract.ring    "0.6.2-0.2.0-beta2"]
                 ;; web servers (uncomment any one)
                 ;;[aleph                   "0.4.6" :exclusions [org.clojure/tools.logging]]
                 [http-kit                "2.3.0"]
                 ;;[org.immutant/immutant   "2.1.10"]
                 ;;[ring/ring-jetty-adapter "1.6.3"]
                 ;; web
                 [ring/ring-core "1.6.3"]]
  :target-path "target/%s"
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler bract.ring.dev/handler
         :init    bract.ring.dev/init!
         :port    3000
         :nrepl   {:start? true :port 3001}}
  :profiles {:dev {:dependencies [[bract/bract.dev "0.6.2-0.2.0-beta2" :exclusions [bract/bract.core]]]
                   :repl-options {:init-ns bract.dev.repl
                                  :port 3001}
                   ;; :source-paths ["dev"]
                   :main ^:skip-aot bract.core.main
                   }
             :uberjar {:aot [bract.core.main]
                       :main ^:skip-aot bract.core.main
                       :pedantic? :abort}})
