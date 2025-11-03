

# PokeAPI Consumer 🐉

Aplicación Spring Boot que consume la **[PokeAPI](https://pokeapi.co/)** utilizando **WebClient** de Spring WebFlux.
Permite consultar la información básica de cualquier Pokémon por su nombre, mostrando datos como ID, peso, altura y habilidades.
## 🚀 Características
* Desarrollado con **Java 17** y **Spring Boot 3**
* Consumo de API REST externa con **WebClient (reactivo)**
* Mapeo de respuesta JSON en clases modelo
* Estructura de proyecto modular (Controller, Service, Models, Config)
* Límite de memoria aumentado para manejar JSON grandes (2 MB)
* Manejo de errores básico ante Pokémon inexistente
## 🧩 Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

* [Java JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
* [Maven 3+](https://maven.apache.org/)
* [Spring Tool Suite / Eclipse IDE](https://spring.io/tools)
* Conexión a Internet (la PokeAPI es una API pública)

### `ConfigWebClient.java`

Configura el **WebClient** con un límite de memoria aumentado a 2 MB para evitar el error `DataBufferLimitException`:

```java
@Bean
public WebClient webClient() {
    ExchangeStrategies strategies = ExchangeStrategies.builder()
            .codecs(configurer -> configurer
                    .defaultCodecs()
                    .maxInMemorySize(2 * 1024 * 1024))
            .build();

    return WebClient.builder()
            .baseUrl("https://pokeapi.co/api/v2")
            .exchangeStrategies(strategies)
            .build();
}
```

---

## 🧠 Uso de la API

### Endpoint principal

**GET** `/api/pokemon/{name}`

#### Ejemplo:

```
GET (http://localhost:8080/api/pokemon/pikachu)
```

#### Respuesta:

```json
{
    "id": 25,
    "name": "pikachu",
    "height": 4,
    "weight": 60,
    "abilities": [
        {
            "ability": {
                "name": "static"
            }
        },
        {
            "ability": {
                "name": "lightning-rod"
            }
        }
    ]
}
```

---

## 🧪 Ejecución

1. Clona el repositorio o abre el proyecto en Eclipse.
2. Asegúrate de que el archivo `pom.xml` descargue todas las dependencias:

   ```bash
   mvn clean install
   ```
3. Ejecuta la aplicación:

   ```bash
   mvn spring-boot:run
   ```

   o desde Eclipse → *Run As → Spring Boot App*
4. Prueba los endpoints desde tu navegador o Postman.

---

## 🧱 Dependencias principales

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webflux</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## 🧰 Tecnologías utilizadas

* **Spring Boot 3**
* **Java 17**
* **Maven**
* **Spring WebFlux / WebClient**
* **PokeAPI (API pública REST)**

---

## 📜 Licencia

Este proyecto fue desarrollado con fines académicos para el **Taller 2 – Consumo de API (ACM GiWeb)**.
Eres libre de modificarlo y reutilizarlo con fines educativos.
