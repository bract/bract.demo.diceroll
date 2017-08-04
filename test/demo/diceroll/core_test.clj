;   Copyright (c) Shantanu Kumar. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file LICENSE at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.


(ns demo.diceroll.core-test
  (:require
    [clojure.test :refer :all]
    [clojure.string          :as string]
    [demo.diceroll.core      :as core]
    [demo.diceroll.test-init :as ti])
  (:import
    [java.util.regex Pattern]))


(deftest test-roll
  (let [rolled-set (->> core/rolls
                     (map #(subs % 1))
                     set)
        custom-set (->> rolled-set
                     (map #(string/replace % (re-pattern (Pattern/quote "X")) "@"))
                     set)]
    (let [rolled (core/roll-now)]     (is (contains? rolled-set rolled)))
    (let [rolled (core/roll-now "@")] (is (contains? custom-set rolled)))))
