;   Copyright (c) Shantanu Kumar. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file LICENSE at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.


(ns demo.diceroll.test-init
  (:require
    [bract.ring.dev :as ring-dev]))


(defonce config nil)


(defn update-config!
  [app-config]
  (alter-var-root #'config (fn [_] app-config)))


(ring-dev/init-once!)