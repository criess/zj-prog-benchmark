# ZJ-Prog-Benchmark

## Environment

* It is a springboot app (with server/tomcat bundled everything ready to go!)
* It should be built through maven
* Tested with openjdk 1.8.0.171 and maven 3.5

## Build and run

* you need maven and java installed (see Environment)
```
git clone
cd
mvn package
java -jar
```

Now you may navigate to http://localhost:8080 inside a browser.

## Known issues

* Inline source code docs (non-existant at the moment)
* only EUR supported for basic plan as source-currency (else HTTP 500 error)
* Frontend needs polish (I am not a frontend guy)
* hardcoded API_KEY constant ideally set through java env e.g. -Dsomeapi.key=abcdef
* better error and exception handling
* honor/set coding standard *did it just with gedit because installing IDE would take too long*
* better handling of numeric values in conversionModel class
* missing Tests
* maybe even more! there is always potential
