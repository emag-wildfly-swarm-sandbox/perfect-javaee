# chapter13

``` sh
$ mvn wildfly-swarm:run
```

## Add message
 
``` sh
$ curl 'http://localhost:8080/hello-jpa/app/message/add?message=hello'
{"id":1,"message":"hello"}
```

## Get all messages

``` sh
$ curl http://localhost:8080/hello-jpa/app/message/ | jq .
[
  {
    "id": 1,
    "message": "hello"
  },
  {
    "id": 2,
    "message": "JPA"
  }
]
```