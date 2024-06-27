# API REST SpringBoot com JDBC

## Objetivos
- Criar as classes para representar as tabelas
- Criar as classes de repositório para acessar os dados de uma tabela
- CRUD via API (Create, Retrieve, Update e Delete) 

MVC - Model, View, Controller

API REST
API - Application Programming Interface
REST - Representational State

Estrutura da aplicação
- Controllers - Entrada da aplicação
- Models - As classes que representam como um objeto Java um registro no banco
- Services - A camada de lógica e regras de negócio
- Repositories - Responsaveis pelas operações com o banco de dados

Controlador > Objeto de um Modelo > Serviço > Repositorio 
Controller > Objeto do Model > Service > Repository


## Requisitos Funcionais
RF0 - Implementar a rotina de saque
  - Criar uma tabela de saques?
  - Criar apenas as rotas para saque e usar os serviços para poder fazer o processo?
    1. Ir até um caixa eletrônico
    2. Inserir o cartão
    3. Inserir a senha
    4. Validar a senha
    5. Informar o valor do saque
    6. Validar se o caixa possui saldo
    7. Validar se a conta possui saldo
    8. Liberar o dinheiro para o cliente
    9. Registrar a transação
    10. Encerrar a operação
  - 
RF1 - Um usuário pode obter o saldo atual da sua conta.
RF2 - Um usuário pode obter um extrato de um determinado período
RF3 - Um usuário só pode acessar dados da sua conta
RF4 - O usuário tem a possibilidade de pagar um boleto
RF5 - Fazer transferencias entre contas do mesmo banco
