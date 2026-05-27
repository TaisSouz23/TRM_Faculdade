# 🎓 TRM Faculdade

### Sistema de Gestão Acadêmica Desktop em Java Swing

Aplicação desktop desenvolvida em **Java** utilizando **Swing** para gerenciamento acadêmico de alunos, cursos e matrículas.  
O projeto foi criado como atividade avaliativa da disciplina de **Programação Orientada a Objetos**, aplicando conceitos de POO, organização modular e interfaces gráficas.

---

# 📸 Funcionalidades

✔️ Splash Screen com barra de carregamento  
✔️ Sistema de login com autenticação  
✔️ Cadastro completo de alunos  
✔️ Cadastro completo de cursos  
✔️ Sistema de matrículas  
✔️ Listagem geral com estatísticas  
✔️ Interface gráfica em Java Swing  

---

# 🖥️ Demonstração do Sistema

## 🔐 Tela de Login
Sistema de autenticação para acesso à aplicação.

## 📋 Menu Principal
Central de navegação entre os módulos do sistema.

## 👨‍🎓 Cadastro de Alunos

CRUD completo de alunos:

- Cadastrar
- Pesquisar
- Editar
- Excluir

## 📚 Cadastro de Cursos

CRUD completo de cursos:

- Cadastrar
- Pesquisar
- Editar
- Excluir

## 📝 Matrículas

Vinculação entre alunos e cursos cadastrados.

## 📊 Estatísticas

Painel com:

- Total de alunos
- Total de cursos
- Quantidade de bolsistas
- Distribuição por turno

---

# 🏗️ Estrutura do Projeto

```bash
TRM_Faculdade/
│
├── core/
│   ├── Acionavel.java
│   ├── SistemaFaculdade.java
│   └── TesteSistema.java
│
├── models/
│   ├── Aluno.java
│   ├── Curso.java
│   └── Matricula.java
│
├── telas/
│   ├── TelaSplash.java
│   ├── TelaLogin.java
│   ├── TelaMenu.java
│   ├── TelaCadastroAluno.java
│   ├── TelaCadastroCurso.java
│   ├── TelaMatricula.java
│   └── TelaListagem.java
│
└── resources/
    └── logo.png
```

---

# ⚙️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|---|---|
| Java | Linguagem principal |
| Java Swing | Interface gráfica |
| ArrayList | Armazenamento em memória |
| NetBeans | IDE utilizada no desenvolvimento |

---

# 🚀 Como Executar

## Clone o repositório

```bash
git clone https://github.com/TaisSouz23/TRM_Faculdade.git
```

## Abra na IDE

Abra o projeto em uma IDE Java:

- Apache NetBeans
- IntelliJ IDEA
- Eclipse

## Execute o sistema

Inicie pela classe:

```bash
TesteSistema.java
```

---

# 🔐 Credenciais de Acesso

```txt
Usuário: admin
Senha: 1234
```

---

# 🧠 Conceitos Aplicados

O projeto utiliza conceitos fundamentais de Programação Orientada a Objetos:

- Encapsulamento
- Abstração
- Modularização
- Interfaces
- Reutilização de código
- Manipulação de eventos
- Interface gráfica com Swing

---

# 📌 Observações

> Os dados são armazenados apenas em memória utilizando `ArrayList`.

- Não há persistência em banco de dados
- Os dados são perdidos ao fechar a aplicação
- O sistema utiliza a interface `Acionavel` para padronização das telas através do método `executar()`

---

# 👨‍💻 Equipe

- [Tais Souza](https://github.com/TaisSouz23)
- [Marcos Vinicius](https://github.com/mrvinicius25)
- [Raymond Lima](https://github.com/RaymondLima)

---

# 👨‍🏫 Disciplina

Projeto desenvolvido como trabalho avaliativo da disciplina de **Programação Orientada a Objetos (POO)**.

---

# 📄 Licença

Projeto desenvolvido para fins educacionais e acadêmicos.
