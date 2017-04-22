# bract.demo.diceroll

A minimal demo web app for the Bract framework. The problem statement this app solves is as follows:

- Randomly pick a roll of dice on every web request
- Render the rolled dice in a visual text form
- Use [Ring](https://github.com/ring-clojure) for handling HTTP requests


## Usage

### Starting the server

You can build the app locally and run it as follows:

```shell
$ lein do clean, uberjar
$ java -jar target/uberjar/bract.demo.diceroll-0.1.0-SNAPSHOT-standalone.jar -vf config.edn
```

Alternatively, you may want to run it as follows in development:

```shell
$ lein do clean, ring server-headless
```

### Browsing the app

In your web browser you can visit the following URLs:

http://localhost:3000
http://localhost:3000?char=@
http://localhost:3000/info


## License

Copyright © 2017 Shantanu Kumar (kumar.shantanu@gmail.com, shantanu.kumar@concur.com)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
