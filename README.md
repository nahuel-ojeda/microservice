<h1 align="center"> Microservicio </h1> <br>

<p align="center">
  Microservicio de una empresa de logistica aun en desarollo.
</p>

## Tabla de Contenido

- [Introduccion](#introduccion)
- [Características](#características)
- [Requerimientos](#requerimientos)
- [Inicio Rapido](#inicio-rapido)

## Introduccion
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://docs.spring.io/spring-boot/docs/1.4.1.RELEASE/maven-plugin/license.html)

Arquitectura definida se establece que se utilizaran las siguientes tecnologías:
-BD: Mysql con un esquema de datos para Microservicio.
-Cada microservicio cuenta con el patrón MVC (controller, service y repository), especificación swagger, Logs y manejo de excepciones. JPA. Todo desarrollado con spring boot y protocolo API Rest.
-Comunicación: La comunicación entre microservicios es mediante feign.

## Características

* Arquitectura java
* Maven Parent POM
* Librerias de maven

## Requerimientos
la app requiere un entorno MySQL y un entorno de desalloro en java.

## Local
* [Spring Tool Service](https://spring.io/tools)
* [Java 11 SDK](https://www.oracle.com/java/technologies/downloads/#java11)
* [Maven](https://maven.apache.org/download.cgi)
* [MySQL](https://www.mysql.com/products/workbench/)

## Inicio Rapido
Verificar que este corriendo el workbench

### Puertos de cara Microsevicio
El valor por default en  __application.properties__ del microservicio de empleados es el puerto `8081`.
El valor por default en  __application.properties__ del microservicio de empresas es el puerto `8082`.
El valor por default en  __application.properties__ del microservicio de transportes es el puerto `8083`.
El valor por default en  __application.properties__ del microservicio de logistica es el puerto `8084`.

