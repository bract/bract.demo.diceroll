;   Copyright (c) Shantanu Kumar. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file LICENSE at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.


(ns bract.demo.diceroll.web-test
  (:require
    [clojure.string :as string]
    [clojure.test :refer :all]
    [bract.ring.dev :as ring-dev]
    [bract.demo.diceroll.config :as config]
    [bract.demo.diceroll.core   :as core]
    [bract.demo.diceroll.web    :as web]
    [bract.demo.diceroll.test-init :as ti])
  (:import
    [java.util.regex Pattern]))


(def rolled-set (->> core/rolls
                  (map #(subs % 1))
                  set))


(deftest test-default
  (let [config-set (->> rolled-set
                     (map #(string/replace % (re-pattern (Pattern/quote "X")) (config/cfg-dice-char ti/config)))
                     set)
        params-set (->> rolled-set
                     (map #(string/replace % (re-pattern (Pattern/quote "X")) "@"))
                     set)]
    (let [response (ring-dev/handler {})]
      (is (= 200 (:status response)))
      (is (contains? config-set (:body response))))
    (let [response (ring-dev/handler {:query-params {"char" "@"}})]
      (is (= 200 (:status response)))
      (is (contains? params-set (:body response))))))
