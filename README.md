# 🍯 Pensioenpot API
Deze repository bevat een demo implementatie van een REST Api om de verwachte waarde van een 
pensioenpot te berekenen op de geplande pensioendatum. 

## ⚙️ Requirements
Om deze applicatie lokaal te draaien, heb je nodig:
- Java 25 (OpenJDK)
- Maven 3.8+
- Docker Runtime
- Optioneel: IDE (IntelliJ IDEA)

## 🖥️ HTTP Requests
See [http-requests.http](http-requests.http) voor aanroepen naar de API.

## 🚀 Run

### Clone the Repository

```shell
   git clone https://github.com/hakktastic/pensioenpot-api.git
   cd pensioenpot-api
   git checkout master
```

### Build the Project

```shell
   mvn clean install
```

## Start Application

```shell      
  # start the application
  mvn spring-boot:run
```

## Stop Application

```shell  
  # stop the application
  mvn spring-boot:stop
```