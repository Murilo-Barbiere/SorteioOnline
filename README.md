## 🚀 Como clonar o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

---

## 🐳 Como subir o projeto com Docker

Certifique-se de ter o **Docker** instalado.

### ▶️ Subir os containers

```bash
docker-compose up -d
```


### 🛑 Parar os containers

```bash
docker-compose down
```

---

## 🧱 Estrutura do Projeto

O projeto segue uma arquitetura em camadas, separando responsabilidades para facilitar manutenção e escalabilidade.

```
src/
│
├── config/
│   └── Configurações da aplicação (ex: Spring Security, autenticação, etc.)
│
├── controller/
│   └── Camada responsável por receber as requisições HTTP e retornar respostas
│
├── DTO/
│   ├── request/
│   │   └── Objetos usados para receber dados das requisições
│   └── response/
│       └── Objetos usados para enviar dados nas respostas
│
├── model/
│   └── Entidades do sistema (representação das tabelas do banco)
│
├── repository/
│   └── Interfaces responsáveis pelo acesso ao banco de dados
│
└── service/
    └── Regras de negócio da aplicação
```

---

## 🔄 Fluxo da aplicação

1. O **Controller** recebe a requisição
3. Chama o **Service**
4. O **Service** aplica regras de negócio
5. O **Repository** acessa o banco de dados
6. A resposta retorna passando pelo fluxo inverso
