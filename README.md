# 🎓 Sistema de Alunos e Cursos com JPA

Um sistema de cadastro de alunos, seus respectivos documentos e cursos, desenvolvido com **Spring Boot**, **JPA (Hibernate)** e **MySQL**. O projeto demonstra o uso de relacionamentos entre entidades (`@OneToOne`, `@ManyToOne`, `@OneToMany`) e expõe endpoints RESTful.

---

## 📦 Estrutura do Projeto

```
br.com.jonnatan.AlunosCursos
├── Alunos          # Entidade, controller e service do Aluno
├── Cursos          # Entidade e repository do Curso
├── Documento       # Entidade de Documento (OneToOne com Aluno)
```

---

## 🧩 Entidades e Relacionamentos

### 🧑 Aluno
- `@OneToOne` com `Documento` (cada aluno tem um documento único)
- `@ManyToOne` com `Curso` (vários alunos podem estar no mesmo curso)

### 📘 Curso
- `@OneToMany` com `Aluno` (um curso possui vários alunos)

### 📄 Documento
- Usado apenas como exemplo de relacionamento `@OneToOne`

---

## 🔗 Endpoints

### Alunos

| Método | URL           | Descrição                            |
|--------|----------------|----------------------------------------|
| GET    | `/alunos`      | Lista todos os alunos                  |
| GET    | `/alunos/{id}` | Retorna um aluno pelo ID               |
| POST   | `/alunos`      | Cria um aluno (com documento e curso) |
| DELETE | `/alunos/{id}` | Deleta um aluno pelo ID                |

---

## 📥 Exemplo de Requisição `POST /alunos`

```json
{
  "nome": "Maria Clara",
  "documento": {
    "numero": "123.456.789-00"
  },
  "curso": {
    "id": 1
  }
}
```

> 🔔 Importante: o `curso.id` deve ser de um curso existente previamente cadastrado no banco.

---

## ⚙️ Tecnologias Utilizadas

- ✅ **Spring Boot** – Framework principal
- ✅ **Spring Data JPA** – Integração ORM com Hibernate
- ✅ **MySQL** – Banco de dados relacional
- ✅ **Lombok** – Redução de boilerplate com anotações (@Data, @NoArgsConstructor, etc.)
- ✅ **Jakarta Persistence** – Anotações JPA (ex: `@Entity`, `@ManyToOne`)

---

## 🛠️ Configuração

### 1. Banco de Dados (MySQL)

Crie um banco chamado `alunos_cursos` e configure no `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/alunos_cursos
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 2. Build com Maven

```bash
mvn clean install
```

### 3. Rodar a aplicação

```bash
mvn spring-boot:run
```

A API ficará disponível em:  
📍 `http://localhost:8080/alunos` <br>
📍 `http://localhost:8080/cursos`
---

## 👨‍💻 Autores

**Jonnatan Silva de Farias**  
Estudante de Análise e Desenvolvimento de Sistemas

**Klisman Mateus Pereira Santos**  
Estudante de Análise e Desenvolvimento de Sistemas


