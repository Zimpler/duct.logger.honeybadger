duct.logger.honeybadger
=======================

A [Timbre](https://github.com/ptaoussanis/timbre) appender that sends log events into
 [Honeybadger](https://www.honeybadger.io/) for [Duct](https://github.com/duct-framework/duct) framework.

This library DOES NOT include Timbre nor [Honeybadger](https://clojars.org/camdez/honeybadger).
 A host project has to include itself.

[![Build Status](https://travis-ci.com/Zimpler/duct.logger.honeybadger.svg?branch=master)](https://travis-ci.com/Zimpler/duct.logger.honeybadger)
[![Dependencies Status](https://jarkeeper.com/zimpler/duct.logger.honeybadger/status.png)](https://jarkeeper.com/zimpler/duct.logger.honeybadger)
[![License](https://img.shields.io/badge/MIT-Clause-blue.svg)](https://opensource.org/licenses/MIT)


Leiningen/Boot
--------------

To install, add the following to you project `:dependencies`:

```clojure
[duct.logger.honeybadger "0.1.0"]
```

Documentation
-------------

Add following configuration into project's config:

```edn
{:duct.logger.honeybadger/timbre
 {:config {:api-key "YOUR-SECRET-KEY"
           :env :development}}
  :options {:min-level :warn}

 :duct.logger/timbre
 {:appenders {:duct.logger.honeybadger/timbre #ig/ref :duct.logger.honeybadger/timbre
              :duct.logger.timbre/brief #ig/ref :duct.logger.timbre/brief}}}
```
