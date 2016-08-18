# decorator

## Usage

### Run without sale

``` sh
$ mvn clean package \
  && java -jar point-processor-client/target/point-processor-client-swarm.jar
```

``` sh
$ curl 'localhost:8080?price=1000'
{"value":10,"expireDay":"2016-11-17"}
```

### Run with sale

``` sh
$ mvn clean package -Psale \
  && java -jar point-processor-client/target/point-processor-client-swarm.jar
```

``` sh
$ curl 'localhost:8080?price=1000'
{"value":50,"expireDay":"2016-11-17"}
```