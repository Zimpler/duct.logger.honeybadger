(ns timbre.appenders.honeybadger
  (:require
   [honeybadger.core :as hb]))

(defn honeybadger-appender
  "It return a configuration for an appender composed form a given maps:
   - `config` a Honeybadger configuration e.g.: {:api-key 1234, :env :development}
   - `options` an options for a Timbre appender (for a whole list of options see Timbre's documentation)
     https://github.com/ptaoussanis/timbre#configuration
     - `event-fn` can be used to modify the raw event before sending it to Honeybadger
     - `min-level` a level keyword, or nil (=> no minimum level), default `:warn`
     - `enabled?` toggles an appender, default `true`
     - `async?` dispatched using agent? Useful for slow appenders (clj only)
     - `rate-limit` `[[ncalls-limit window-ms]` <...>], or `nil`
     - `output-fn` optional override for inherited (fn [data]) -> string`"
  [config {:keys [event-fn] :or {event-fn identity} :as options}]
  (merge {:enabled? true
          :async? true
          :min-level :warn
          :rate-limit nil
          :output-fn :inherit
          :fn (fn [{:keys [level output_]}]
                (hb/notify config (-> output_ force event-fn) {:tags [level]}))}
         options))
