;   Copyright (c) Shantanu Kumar. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file LICENSE at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.


(ns demo.diceroll.web
  (:require
    [clojure.pprint :as pp]
    [ring.middleware.params :as rmp]
    [bract.core.keydef      :as core-kdef]
    [demo.diceroll.keydef   :as kdef]
    [demo.diceroll.core     :as core]))


(defn roll-dice
  [dice-char request]
  {:status 200
   :headers {"Content-type" "text/plain"}
   :body (core/roll-now (-> request
                          (get-in [:query-params "char"])
                          (or dice-char)))})


(defn make-ring-handler
  [config]
  (let [dice-char (kdef/cfg-dice-char config)]
    (fn [request]
      (roll-dice dice-char request))))


(defn info-middleware
  [handler]
  (fn [request]
    (let [^String uri (:uri request)]
      (if (#{"/info" "/info/"} uri)
        {:status 200
         :headers {"Content-type" "text/plain"}
         :body (let [^Runtime rt (Runtime/getRuntime)
                     mbytes (fn [^long n] (str (int (/ n (* 1024 1024))) " MBytes"))]
                 (with-out-str
                   (pp/pprint {:available-processors (.availableProcessors rt)
                               :free-memory  (mbytes (.freeMemory  rt))
                               :total-memory (mbytes (.totalMemory rt))
                               :max-memory   (mbytes (.maxMemory   rt))})))}
        (handler request)))))


(defn apply-info-middleware
  [handler context]
  (let [config (core-kdef/ctx-config context)]
    (if (kdef/cfg-info-enabled? config)
      (info-middleware handler)
      handler)))


(defn apply-wrap-params-middleware
  [handler context]
  (let [config (core-kdef/ctx-config context)]
    (if (kdef/cfg-wrap-params? config)
      (rmp/wrap-params handler)
      handler)))
