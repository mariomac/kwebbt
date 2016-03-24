Webapp bootstrap
==================

Cool maven skeleton used as a rapid starting point on Kotlin web aplications with traditional, rock-solid Java frameworks

* Struts and Tiles for MVC and multi-language support
* Jersey for REST
* Shiro for Security

To start the service:

    mvn jetty:run

To test GUI Security, open your browser and go to [http://localhost:8080](http://localhost:8080).

To test API Security:

    curl -H "X-ApiKey: test" http://localhost:8080/api/v1/hello

Published under [Beer-ware license](https://www.tldrlegal.com/l/beerware)
