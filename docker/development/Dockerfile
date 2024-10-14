# Usar a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Definir diretório de trabalho dentro do container
WORKDIR /usr/app

# Copiar o arquivo de JAR do build para o container
COPY target/*.jar app.jar

# Expor a porta do Spring Boot (8080 por padrão)
EXPOSE 8080

# Comando para rodar a aplicação com suporte a DevTools para hot-reload
CMD ["java", "-jar", "-Dspring.devtools.restart.enabled=true", "app.jar"]
