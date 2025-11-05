# 🏦 MiniBank API

**MiniBank** é uma aplicação Java **Spring Boot** que simula as operações básicas de um sistema bancário.  
Permite **criar clientes, contas e realizar transações** (depósito, saque e transferência) com histórico salvo no banco de dados.

---

## 🚀 Tecnologias utilizadas
- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Postman** (para testes manuais)

---

## 📂 Estrutura principal

| Camada | Função |
|--------|--------|
| **model** | Entidades principais (`Client`, `Account`, `Transaction`) e `TransactionType` |
| **dto** | Objetos de transferência de dados para requests/responses (`ClientDTO`, `AccountDTO`, `TransactionDTO`, etc.) |
| **repository** | Interfaces de acesso ao banco via Spring Data JPA |
| **service** | Regras de negócio (depósito, saque, transferência, criação de conta e cliente) |
| **controller** | Endpoints REST que recebem e retornam dados da aplicação |
| **exception** | Exceções personalizadas e tratamento global |
| **model/ErrorResponse** | Estrutura padrão para respostas de erro em JSON |

---

## 🧩 Endpoints principais

### 👤 Clientes
| Método | Endpoint | Descrição |
|---------|-----------|-----------|
| `POST` | `/clients/create` | Cria um novo cliente |
| `GET` | `/clients` | Lista todos os clientes |

### 💳 Contas
| Método | Endpoint | Descrição |
|---------|-----------|-----------|
| `POST` | `/accounts/create` | Cria uma nova conta |
| `GET` | `/accounts` | Lista todas as contas |

### 🔁 Transações
| Método | Endpoint | Descrição |
|---------|-----------|-----------|
| `POST` | `/transactions/deposit` | Realiza um depósito |
| `POST` | `/transactions/withdraw` | Realiza um saque |
| `POST` | `/transactions/transfer` | Realiza uma transferência entre contas |

---

## 🛠️ Exemplos de requisição

### 📥 Depósito (`/transactions/deposit`)
```json
{
  "accountId": 1,
  "amount": 200.0
}
```
### 📤 Saque (/transactions/withdraw)
```json
{
  "accountId": 1,
  "amount": 50.0
}

```
### 🔄 Transferência (/transactions/transfer)
```json
{
  "fromAccountId": 1,
  "toAccountId": 2,
  "amount": 100.0
}
```

### 💾 Como executar o projeto
1. Clone o repositório: https://github.com/leoferreira9/minibank.git
2. Configure o arquivo src/main/resources/application-example.properties com suas credenciais do MySQL:
  ```bash
  spring.datasource.url=jdbc:mysql://localhost:3306/minibank
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  ```
# 🧠 Como executar a aplicação (no IntelliJ IDEA)
### 1. Abra a classe principal:
```java
  src/main/java/com.leonardo.minibank/MinibankApplication.java
```
### 2. Execute a aplicação:
```
- Clique no botão ▶️ Run ‘MinibankApplication’
- Isso iniciará o servidor Spring Boot na porta padrão 8080.
```
### 3. Teste os endpoints no Postman ou Insomnia, usando URLs como:
```
http://localhost:8080/clients
http://localhost:8080/accounts
http://localhost:8080/transactions/deposit
```
