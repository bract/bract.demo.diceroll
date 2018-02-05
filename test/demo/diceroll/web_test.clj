;   Copyright (c) Shantanu Kumar. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file LICENSE at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.


(ns demo.diceroll.web-test
  (:require
    [clojure.test :refer :all]
    [clojure.string       :as string]
    [bract.core.dev       :as bc-dev]
    [bract.core.keydef    :as bc-kdef]
    [bract.ring.keydef    :as br-kdef]
    [demo.diceroll.keydef :as kdef]
    [demo.diceroll.core   :as core]
    [demo.diceroll.web    :as web]
    [demo.diceroll.test-init])
  (:import
    [java.util.regex Pattern]))


(def rolled-set (->> core/rolls
                  (map #(subs % 1))
                  set))


(deftest test-default
  (let [;; initialized context is at bract.core.dev/app-context
        config     (bc-kdef/ctx-config       bc-dev/app-context)  ; get initialized config
        handler    (br-kdef/ctx-ring-handler bc-dev/app-context)  ; get initialized Ring handler
        config-set (->> rolled-set
                     (map #(string/replace % (re-pattern (Pattern/quote "X")) (kdef/cfg-dice-char config)))
                     set)
        params-set (->> rolled-set
                     (map #(string/replace % (re-pattern (Pattern/quote "X")) "@"))
                     set)]
    (let [response (handler {:uri "/"})]
      (is (= 200 (:status response)))
      (is (contains? config-set (:body response))))
    (let [response (handler {:uri "/"
                             :query-params {"char" "@"}})]
      (is (= 200 (:status response)))
      (is (contains? params-set (:body response))))))
