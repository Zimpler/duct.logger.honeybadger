(ns duct.logger.honeybadger
  (:require
   [integrant.core :as ig]
   [timbre.appenders.honeybadger :refer [honeybadger-appender]]))

(defmethod ig/init-key ::timbre
  [_ {:keys [config options]}]
  (honeybadger-appender config options))
