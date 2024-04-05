# Desafio API de Sistema de Pagamento (Java 🚀 com Spring Boot 🍃)

Este é um projeto Java Spring boot, que consiste em uma API para autorização de transações, peguei do desafio do PicPay.

## Configuração

1. Clone o repositório para sua máquina local:

    ```bash
    git clone https://github.com/Thullyoo/sistema-de-pagamento-simplificado
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd sistema-de-pagamento-simplificado
    ```

3. Instale as dependências com o maven


4. Execute a aplicação:

A aplicação estará rodando em `http://localhost:8080`.

## Uso

Você também pode acessar o Swagger UI que utilizei para documentar a API pelo seguinte link: `http://localhost:8080/swagger-ui/index.html`

### Endpoints

- `GET /users`: Retorna todos os usuários.
- `GET /transactions`: Retorna todas as transações.
- `GET /users/{id}`: Retorna um usuário de acordo com o ID.
- `POST /users`: Cria um usuário.
- `POST /transactions`: Cria uma nova transação.


### Formato dos dados

As requisições e respostas são no formato JSON. Exemplo de como se deve passar o JSON no POST:

```json
{
  "balance": 10,
  "name": "joao",
  "document": "1231452a136136",
  "email": "joao@gmail.com",
  "password": "senha",
  "type": "COMMON"
}
{
  "balance": 30,
  "name": "maria",
  "document": "12531452a136136",
  "email": "maria@gmail.com",
  "password": "senha",
  "type": "MERCHANT"
}
{
  "payeeID": 1,
  "payerID": 2,
  "amount": 10
}
