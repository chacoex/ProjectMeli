# chacoex :snowboarder:

Prueba Técnica 'MercadoLibre'. API REST para identificar si un humano es mutante dado el ADN y almacenar y poner a disposición las estadísticas de verificaciones del método expuesto (humanos, mutantes y ratio).
## Herramientas Desarrollo
[Spring Boot]
 
[BD H2] Base de datos en memoria

[Java] version:11

[Gradle] version:6.8.3

[aws] Hosting API

## Instalación Local

> Instalación Local

Clone this project to a local folder:
```
$ https://github.com/chacoex/ProjectMeli
```

Compilación con comando gradle wrapper:

```java
./gradlew clean build
```

Ejecución:

```
./gradlew bootRun
```

Servicio expuesto `localhost:8080`

## Postman

Ejecucion con un cliente para hacer llamados servicios rest en este caso postman.

![postman collection](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTS0cAX6dbieEV08pmf-LxR38cccnTK0OyaTD6Lqi8VR4oADN48_-L0xFg1bsj85E7sRIE&usqp=CAU)

[Postman](https://www.getpostman.com/docs/v6/postman/collection_runs/using_environments_in_collection_runs).

## Endpoints

**`POST -> /ismutant`**
Se comprueba si un ADN pertenece a un Humano oa un Mutante

Request example:
```json
// Mutante
{ 
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

```
Response example:
```curl
HTTP/1.1 200 OK
Content-Type: application/json

"StatusCode": "200"
```
Secuencia Humano:
```json
// Humano
{ 
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

```
Response example:
```curl
HTTP/1.1 403 Forbidden
Content-Type: application/json

"StatusCode": "403"
```


**`GET -> /stats`**

Response example:
```
HTTP/1.1 200
Content-Type: application/json
```

```json
{
    "count_mutant_dna": 1,
    "count_human_dna": 0,
    "ratio": 1.0
}
```

## API cloud computing Amazon aws
Amazon Web Services  

![aws](https://acis.org.co/portal/sites/default/files/awsasd.png)

> Endpoint

**`POST -> https://fb0onzn5u2.execute-api.us-east-2.amazonaws.com/Stage/ismutant`**

Request example:
```json
// Mutante
{ 
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

```
Response example:
```curl
HTTP/1.1 200 OK
Content-Type: application/json

"StatusCode": "200"
```



## License

[MIT License]:copyright:
