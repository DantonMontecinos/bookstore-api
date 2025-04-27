# Usa una imagen con Java 21
FROM eclipse-temurin:21-jdk-jammy

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el JAR generado por Maven (ajusta el nombre según tu pom.xml)
COPY target/bookstore-api-0.0.1-SNAPSHOT.jar app.jar

# Puerto que expone la app (debe coincidir con server.port en application.properties)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]