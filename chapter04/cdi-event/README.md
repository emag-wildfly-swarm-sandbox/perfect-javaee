# cdi-event

## Usage

``` sh
$ mvn wildfly-swarm:run
```

### POST Minor or Major level alert

``` sh
$ curl -X POST -H "Content-Type: application/json" -d '{"level" : "MINOR", "title" : "minor incident"}' localhost:8080
```

and then you can see the following log in wildfly-swarm console log.

``` sh
2016-08-20 19:25:39,323 INFO  [perfectjavaee.chapter04.cdi_event.AlertLogger] (default task-1) Alert{id=0, level=MINOR, title='minor incident'}
```

### POST Serious level alert

``` sh
$ curl -X POST -H "Content-Type: application/json" -d '{"level" : "SERIOUS", "title" : "serious incident"}' localhost:8080
```

and then you can see the following log in wildfly-swarm console log.

``` sh
2016-08-20 19:28:40,981 INFO  [perfectjavaee.chapter04.cdi_event.AlertLogger] (default task-3) Alert{id=2, level=SERIOUS, title='serious incident'}
2016-08-20 19:28:40,981 ERROR [stderr] (default task-3) I sent a serious mail!: Alert{id=2, level=SERIOUS, title='serious incident'}
```
