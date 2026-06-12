# Projeto AEP 2026 - 2º Bimestre

## 📖 Sobre o Projeto

Este projeto foi desenvolvido como parte da Atividade de Estudo Programada (AEP) do 2º bimestre, utilizando o ecossistema Spring Boot para criação de uma API REST.

A aplicação possui funcionalidades relacionadas ao gerenciamento de usuários e postagens, permitindo operações de cadastro, consulta e manipulação de dados por meio de endpoints REST.

---

## 🚀 Tecnologias Utilizadas

* Java 25
* Spring Boot 4
* Spring Web MVC
* Spring Data JPA
* Banco de Dados H2
* SpringDoc OpenAPI (Swagger)
* Maven

---

## 📂 Estrutura do Projeto

```text
src/
 ├── main/
 │   ├── java/
 │   │    └── com.aep2.demo/
 │   │          ├── config/
 │   │          ├── controllers/
 │   │          ├── enums/
 │   │          ├── models/
 │   │          ├── repositories/
 │   │          ├── services/
 │   │          └── DemoApplication.java
 │   └── resources/
 │        └── application.properties
 └── test/
```

---

## ⚙️ Como Executar

### Pré-requisitos

* Java 25 ou superior
* Maven instalado

### Clonar o repositório

```bash
git clone https://github.com/JoaoRicardoBSouza/Projeto-AEP-2026-2B.git
```

### Entrar na pasta

```bash
cd Projeto-AEP-2026-2B
```

### Executar o projeto

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

Ou execute diretamente pela sua IDE (IntelliJ IDEA ou Eclipse).

---

## 📌 Funcionalidades

* Cadastro de usuários
* Gerenciamento de postagens
* API REST utilizando Spring Boot
* Persistência de dados com Spring Data JPA
* Banco de dados H2 para desenvolvimento
* Documentação automática via Swagger/OpenAPI

---

## 📚 Documentação da API

Após iniciar a aplicação, a documentação poderá ser acessada pelo Swagger UI.

Exemplo:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🗄️ Banco de Dados

O projeto utiliza o banco de dados H2 para facilitar o desenvolvimento e testes.

Caso habilitado na configuração da aplicação, o console do H2 pode ser acessado em:

```
http://localhost:8080/h2-console
```

---

## 👨‍💻 Organização do Código

O projeto segue uma arquitetura em camadas:

* **Controllers:** recebem as requisições HTTP.
* **Services:** concentram as regras de negócio.
* **Repositories:** realizam o acesso aos dados utilizando JPA.
* **Models:** representam as entidades do sistema.
* **Config:** configurações da aplicação.
* **Enums:** enumerações utilizadas pelo sistema.

---

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos como atividade da disciplina (AEP), podendo ser utilizado para estudos e aprendizado.
