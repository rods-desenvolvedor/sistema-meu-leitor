# Projeto MeuLeitor+ (Em desenvolvimento)


Projeto pessoal inspirado no Wattpad, com foco em escrita e leitura de histórias por usuários autenticados. Desenvolvido com Java + Spring Boot e Thymeleaf.

## Funcionalidades

- Cadastro e login de usuários
- Página pública com histórias populares
- Criação de histórias com capítulos vinculados ao usuário logado
- Visualização de histórias e capítulos
- Interface simples com HTML + CSS (via Thymeleaf)

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- PostgreSQL (via Docker)
- Docker Compose

---

## Como rodar o projeto localmente

### Pré-requisitos

- Java 17+
- Maven 3.8+
- Docker e Docker Compose

---

### Subindo banco de dados com Docker

1. Abra o terminal na pasta raiz do projeto onde está o arquivo `docker-compose.yml`.
2. Execute o seguinte comando para subir o PostgreSQL:

```bash
docker-compose up -d  
```

---

### Configuração do `application.properties`

Certifique-se de que o arquivo `src/main/resources/application.properties` está com os dados corretos:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/meu_leitor
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
### Rodando o projeto

1. Compile e rode o projeto com o maven:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Ou abra a classe MeuLeitorApplication.java e clique em "Run" pela sua IDE.

### Acesso ao sistema

Após rodar o projeto, acesse:

http://localhost:8080

Página pública: /home

Login: /login

Cadastro: /cadastrar

Página autenticada: /minha-historia/minhas-historias


