# demo.diceroll

A minimal demo web app for the Bract framework. The problem statement this app solves is as follows:

- Randomly pick a roll of dice on every web request
- Render the rolled dice in a visual text form
- Use [Ring](https://github.com/ring-clojure) for handling HTTP requests


## Usage

### Starting the server

You can build the app locally and run it as follows:

```shell
$ lein do clean, uberjar
$ java -jar target/uberjar/demo.diceroll-0.6.2-SNAPSHOT-standalone.jar -vf config/config.edn
```

Alternatively, you may want to run it as follows in development:

```shell
$ lein do clean, ring server-headless
```


### Browsing the application

In your web browser you can visit the following URLs:

- http://localhost:3000
- http://localhost:3000?char=@
- http://localhost:3000/info


### REPL based development

Run `lein do clean, repl` to launch the REPL:

```clojure
bract.dev.repl=> (help)  ; shows the help screen
```


### Running tests

Run tests using `lein do clean, test` command.


## License

Copyright © 2017-2021 [Shantanu Kumar](https://github.com/kumarshantanu)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
