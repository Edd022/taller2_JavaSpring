# Consumo de API OpenWeather 5 days forecast
Este proyecto de es una aplicación de Java Spring Boot que consume la API de pronóstico del clima OpenWeatherMap 5 days forecast, la cual nos da el pronóstico del clima de dada una longitud y latitud o, como es el caso, dado el nombre de una ciudad. La aplicación permite obtener un pronóstico de las próximas 24 horas, y los próximos 3 días, entregando datos como:
* Fecha. 
* Temperatura promedio.
* Descripción general. 
* Temperatura mínima.
* Temperatura máxima. 

Adicional a esto, la 
aplicación está documentada con __Swagger__, esto para más comodidad.

## Tecnologías
* Java Spring Boot

## Dependencias utilizadas
* Lombok
* SpringBoot Web
* Swagger/OpenAPI
* Maven

## Documentación API
La documentación completa de la API está disponible en Swagger:
http://localhost:8080/swagger-ui.html

## Prerrequisitos
* Java 17 o superior
* Maven (opcional, incluido wrapper)
* API key de OpenWeather