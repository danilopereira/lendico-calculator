# Lendico Repayment Plan generator

Repayment Plan Generator with Java 8, Maven, Spring Boot, Mockito and Docker for Lendico

## Runing it

### Instalation

Clone hte repository with the folowing command:
```sh
$ git clone https://github.com/danilopereira/lendico-calculator
```

### Running locally

To run it, you can use maven:

```sh
$ mvn clean spring-boot:run
```

### Running locally wiht Docker

First of all, let's build the jar file to be used on docker image:

```sh
mvn clean install
```

#### Building the image

```sh
$ docker build -t lendico-calculator .
```

#### Running on Docker

```sh
$ docker container run --publish 8080:8080 --detach --name lendico-calculator lendico-calculator
```

### Testing endpoin

You can test this enpoint using the following *curl* command:

```sh
$ curl -X POST \
  http://localhost:8080/generate-plan \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 7dfa3af0-f214-4d90-b77a-e5f4c8f6264c' \
  -H 'cache-control: no-cache' \
  -d '{
	"loanAmount": 5000,
	"nominalRate": 5.0,
	"duration": 24,
	"startDate": "2018-01-01T00:00:01Z"
}'
```


