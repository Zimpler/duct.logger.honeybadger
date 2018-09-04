(ns duct.logger.honeybadger-test
  (:require
   [clojure.test :refer [deftest is]]
   [integrant.core :as ig]
   [duct.logger.honeybadger]))

(deftest generate-configuration-test
  (let [hb-config {:api-key "1234", :env :development}]
    (with-redefs [honeybadger.core/notify (fn [conf event context]
                                            (is (= hb-config conf))
                                            (is (instance? java.lang.Exception event))
                                            (is (= {:tags [:warn]} context)))]
      (let [config (ig/init-key :duct.logger.honeybadger/timbre {:config hb-config
                                                                 :options {:min-level :debug}})
            notify (:fn config)]
        (is (= {:async? true
                :enabled? true
                :min-level :debug
                :output-fn :inherit
                :rate-limit nil}
               (dissoc config :fn)))
        (notify {:output_ (Exception. "foo"), :level :warn})))))
