;   Copyright (c) Shantanu Kumar. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file LICENSE at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.


(ns demo.diceroll.config
  (:require
    [keypin.core :as keypin]
    [keypin.util :as kputil]))


(keypin/defkey  ; context keys
  ctx-bract-config  [:bract.core/config         map?         "Config read by Bract"]
  ctx-ring-handler  [:bract.ring/ring-handler   fn?          "Application Ring handler"])


(keypin/defkey  ; config keys
  cfg-http-kit-opts ["http-kit.opts"            map?         "Option map for HTTP-Kit server"
                     {:parser kputil/any->edn}]
  cfg-dice-char     ["dice.point.char"        (every-pred
                                                string? seq) "Character to use as a dice point"]
  ;; Ring middleware
  cfg-wrap-params?  ["ring.wrap.params.enabled" kputil/bool? "Apply wrap-params middleware to Ring handler?"
                     {:parser kputil/any->bool}]
  cfg-info-enabled? ["ring.info.route.enabled"  kputil/bool? "Is /info route enabled?"])
