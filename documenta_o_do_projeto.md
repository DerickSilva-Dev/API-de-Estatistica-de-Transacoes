# API de Estatísticas de Transações

Um projeto desenvolvido em Java com Spring Boot focado na construção de uma API RESTful para recebimento de transações e cálculo de estatísticas em tempo real (contagem, soma, média, valor máximo e valor mínimo).

Este repositório foi criado para praticar e demonstrar conhecimentos fundamentais em desenvolvimento backend, estruturação de projetos e boas práticas.

## Tecnologias e Práticas Utilizadas

*   **Java 17+**
*   **Spring Boot** (Web, Validation)
*   **Lombok** (Redução de verbosidade)
*   **Maven** (Gerenciamento de dependências)
*   **Boas Práticas:**
    *   Uso de **DTOs** (Data Transfer Objects) para desacoplar a camada de visualização dos modelos de negócio.
    *   **Jakarta Validation** para garantir a integridade dos dados logo na entrada da requisição (`@Valid`, `@NotNull`, `@Min`).
    *   Estruturas **Thread-Safe** no Service para suportar requisições concorrentes com segurança.
    *   Cálculos matemáticos otimizados utilizando a **Stream API** do Java (`DoubleSummaryStatistics`).

## Como executar

1. Deve-se de ter o Java e o Maven instalados na sua máquina.
2. Clone este repositório:
   ```bash
   git clone https://github.com/SEU-USUARIO/NOME-DO-REPOSITORIO.git
   ```
3. Acesse a pasta do projeto e instale as dependências:
   ```bash
   mvn clean install
   ```
4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
   A API estará disponível em `http://localhost:8080`.

## Endpoints da API

### 1. Adicionar Transação
Recebe uma nova transação e a armazena em memória. O valor não pode ser nulo ou negativo.

*   **Rota:** `POST /api/transacao`
*   **Exemplo de Request Body (JSON):**
    ```json
    {
        "valor": 150.50
    }
    ```
*   **Respostas:**
    *   `201 Created` - Transação adicionada com sucesso.
    *   `400 Bad Request` - Se o JSON estiver mal formatado, o valor for nulo ou menor que zero.

### 2. Obter Estatísticas
Retorna os cálculos estatísticos com base em todas as transações registradas até o momento.

*   **Rota:** `GET /api/estatistica`
*   **Exemplo de Response Body (JSON):**
    ```json
    {
        "count": 10,
        "sum": 1500.0,
        "avg": 150.0,
        "max": 300.0,
        "min": 50.0
    }
    ```
*   **Respostas:**
    *   `200 OK` - Estatísticas retornadas com sucesso.