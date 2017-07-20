;   Copyright (c) Shantanu Kumar. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file LICENSE at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.


(ns demo.diceroll.init
  (:require
    [org.httpkit.server   :as server]
    [bract.core.echo      :as echo]
    [demo.diceroll.keydef :as kdef]
    [demo.diceroll.web    :as web]))


(defn app-init
  "Initialize application and return context with Ring handler."
  [context]
  (->> (kdef/ctx-bract-config context)
    web/make-ring-handler
    (assoc context (key kdef/ctx-ring-handler))))


(defn launch
  "Launch server using HTTP-Kit."
  [context]
  (let [handler (kdef/ctx-ring-handler context)
        config  (kdef/ctx-bract-config context)
        hk-cfg  (kdef/cfg-http-kit-opts config)
        stopper (server/run-server handler hk-cfg)]
    (echo/echo "Started HTTP-Kit server using options:" hk-cfg)
    (assoc context
      :bract.core/stopper stopper)))
