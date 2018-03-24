# demo.diceroll Change Log


## [WIP] 0.6.0 / 2018-March-??

- Use Bract 0.6.0
  - [TODO] Use the GA version
  - Use `bract.core.main` as entrypoint (main class)
  - Define context entries in `bract-context.edn` and `bract-context.dev.edn`
  - Remove inducer and launcher entries from `baseconfig.edn` and config files
  - Upgrade HTTP Kit to `2.3.0-beta2`


## 0.5.1 / 2018-March-05

- Use Bract 0.5.1
- Use `bract.core.dev-init` to initialize test namespaces


## 0.5.0 / 2018-February-18

- Use Bract 0.5.0
- Use Clojure 1.9.0
- Upgrade ring-core to 1.6.3 (and lein-ring 0.12.3)
- Switch from own Ring wrappers to those from bract.ring
- Add `/config` endpoint via Ring wrapper to dump config


## 0.4.1 / 2017-August-08

- Use Bract 0.4.1
- Add more common config to `resources/baseconfig.edn`
  - Config files `config/config.edn` and `config/config.dev.edn` derive from it


## 0.4.0 / 2017-August-05

- Use Bract 0.4.0
- Rename namespace `demo.diceroll.config` to `demo.diceroll.keydef`


## 0.3.1 / 2017-June-30
- Use Bract 0.3.1 components
- Rename project to `demo.diceroll`


## 0.3.0 / 2017-June-11
### Changed
- Use bract.core 0.3
- Use bract.cli  0.3
- Use bract.ring 0.3
- Use bract.dev  0.3
- Use parameterized inducer to avoid inducer config duplication


## 0.2.0 / 2017-June-04
### Changed
- Use bract.core 0.2
- Use bract.cli  0.2
- Use bract.ring 0.2
- Use bract.dev  0.2 for REPL-based dev workflow


## 0.1.0 / 2017-April-25
### Added
- Rolling dice
- Use configured dice point char
- Ring middleware
  - Wrap HTTP request params
  - Add `/info` URI endpoint
- Automated tests
  - Using example input
  - Using external config
- REPL based development helpers
