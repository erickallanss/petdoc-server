# Usar a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Definir diretório de trabalho dentro do container
WORKDIR /usr/app

# Copiar o arquivo JAR gerado pelo Maven para o container
COPY target/*.jar app.jar

# Expor a porta padrão da aplicação Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
