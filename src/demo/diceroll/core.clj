;   Copyright (c) Shantanu Kumar. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file LICENSE at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.


(ns demo.diceroll.core
  (:require
    [clojure.string :as string]))


(def rolls
  [;; one
   "
+-------+
|       |
|   X   |
|       |
+-------+
"
   ;; two
   "
+-------+
|     X |
|       |
| X     |
+-------+
"
   ;; three
   "
+-------+
|     X |
|   X   |
| X     |
+-------+
"
   ;; four
   "
+-------+
| X   X |
|       |
| X   X |
+-------+
"
   ;; five
   "
+-------+
| X   X |
|   X   |
| X   X |
+-------+
"
   ;; six
   "
+-------+
| X   X |
| X   X |
| X   X |
+-------+
"
   ])


(defn roll-now
  "Roll the dice, using the dice point character when specified."
  ([]
    (subs (get rolls (rand-int 6)) 1))
  ([ch]
    (let [rolled (roll-now)]
      (if ch
        (string/replace rolled "X" (str (first (str ch))))
        rolled))))
