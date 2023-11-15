# Sistema de Gerenciamento de Estoque de Componentes de T.I com Spring

Este é um projeto Java que utiliza o framework Spring para criar um banco de dados para armazenar informações sobre estoques de componentes de Tecnologia da Informação (T.I). O sistema oferece funcionalidades básicas para adicionar, atualizar, listar e excluir componentes de T.I no estoque

## Executando o Aplicativo
Clone o repositório para sua máquina local:
git clone https://github.com/seu-usuario/nome-do-repositorio.git

## Navegue até o diretório do projeto:
cd nome-do-repositorio

## Compile e execute o aplicativo usando o Maven:
mvn spring-boot:run
O aplicativo será iniciado em http://localhost:8080.

## Endpoints da API
GET /componentes: Lista todos os componentes de T.I no estoque.
GET /componentes/{id}: Obtém detalhes de um componente específico por ID.
POST /componentes: Adiciona um novo componente ao estoque.
PUT /componentes/{id}: Atualiza as informações de um componente existente.
DELETE /componentes/{id}: Exclui um componente do estoque.
Certifique-se de verificar a documentação da API para obter detalhes sobre como usar cada endpoint.

## Contribuição
Sinta-se à vontade para contribuir para o desenvolvimento deste projeto. Abra uma issue para relatar problemas ou envie pull requests com melhorias.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Spring Boot](https://spring.io/projects/spring-boot)
- Um banco de dados, como MySQL, PostgreSQL, ou H2 (configurável no arquivo `application.properties`)

## Configuração do Banco de Dados

O sistema utiliza o Spring Data JPA para interagir com o banco de dados. As configurações de conexão podem ser ajustadas no arquivo `src/main/resources/application.properties`. Certifique-se de fornecer as credenciais e detalhes do banco de dados conforme necessário.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
