# Relatório Detalhado do Funcionamento do Projeto

## Escolha das Versões

### Java 21
O Java 21 baseia-se em seu status como uma versão LTS (Long-Term Support), que garante suporte estendido e atualizações de segurança. A versão 21 do Java traz várias melhorias de desempenho, novos recursos e refinamentos na linguagem que ajudam a construir uma aplicação mais robusta e eficiente.

### Spring Boot 3.3.0
A versão 3.3.0 do Spring Boot foi escolhida por ser uma versão recente, estável e compatível com o Java 21. Esta versão inclui atualizações e melhorias em relação a versões anteriores, proporcionando uma melhor integração com bibliotecas modernas e suporte a novas funcionalidades, garantindo assim um desenvolvimento mais eficiente e seguro.

## Dependências Escolhidas

- **Spring Web**: Necessária para criar aplicações web, incluindo RESTful services.
  - **Justificativa**: Fornece suporte essencial para construção de endpoints REST.
- **Spring Data JPA**: Fornece abstração para operações com banco de dados usando JPA.
  - **Justificativa**: Facilita a interação com o banco de dados de maneira mais simplificada e eficiente.
- **H2 Database**: Banco de dados em memória utilizado para desenvolvimento e testes.
  - **Justificativa**: Permite testes rápidos e fácil setup sem a necessidade de um banco de dados externo.
- **Validation**: Utilizado para validação de dados recebidos nas requisições.
  - **Justificativa**: Assegura que os dados recebidos estejam no formato correto e sigam as regras definidas.
- **HATEOAS**: Facilita a implementação de hipermídia nos endpoints REST.
  - **Justificativa**: Ajuda a adicionar links de navegação nos recursos retornados, seguindo os princípios RESTful.

## Códigos de Status HTTP Utilizados

- **201 CREATED**: Utilizado ao criar um novo produto.
  - **Justificativa**: Indica que a requisição foi bem-sucedida e um novo recurso foi criado.
- **200 OK**: Utilizado para operações de leitura e atualização.
  - **Justificativa**: Indica sucesso nas operações de leitura e atualização.
- **404 NOT FOUND**: Utilizado quando um produto não é encontrado.
  - **Justificativa**: Indica que o recurso solicitado não existe.
- **400 BAD REQUEST**: Utilizado para dados inválidos recebidos na requisição.
  - **Justificativa**: Indica que a requisição não pode ser processada devido a erros de validação.
- **204 NO CONTENT**: Utilizado para operações de exclusão.
  - **Justificativa**: Indica que a operação de exclusão foi bem-sucedida sem conteúdo adicional para retornar.

## Conclusão
O projeto demonstrou proficiência na utilização do Spring Boot para construção de serviços RESTful, com uma abordagem organizada e documentada. A escolha de tecnologias e padrões garantiu uma aplicação robusta e de fácil manutenção.
