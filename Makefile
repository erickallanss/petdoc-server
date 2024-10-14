# Caminho para o Docker Compose
DOCKER_COMPOSE = docker-compose -f docker/development/docker-compose.yml --env-file development.env

# Caminho para o Maven Wrapper (ou use mvn se você tiver o Maven instalado globalmente)
MVN = mvn

# Alvo para construir o projeto com Maven, pulando os testes
build:
	$(MVN) clean package -DskipTests

# Alvo para rodar o Docker Compose
up:
	$(DOCKER_COMPOSE) up

up -build:
	$(DOCKER_COMPOSE) up

# Alvo para parar os containers do Docker Compose
stop:
	$(DOCKER_COMPOSE) down
