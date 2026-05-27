🎓 TRM Faculdade — Sistema de Gestão Acadêmica
Sistema desktop desenvolvido em Java com Swing para gerenciamento de alunos, cursos e matrículas de uma faculdade, criado como trabalho acadêmico para a disciplina de Programação Orientada a Objetos.

📋 Sobre o Projeto
O TRM Faculdade é uma aplicação desktop que centraliza o cadastro e controle de informações acadêmicas. Conta com tela de login, menu principal e módulos para gerenciar alunos, cursos e matrículas, além de uma tela de listagem com estatísticas.

🚀 Funcionalidades

Tela Splash com barra de progresso animada ao iniciar o sistema
Login com autenticação por usuário e senha
Cadastro de Alunos — incluir, pesquisar, alterar e excluir alunos
Cadastro de Cursos — incluir, pesquisar, alterar e excluir cursos
Matrícula — vincular alunos a cursos
Listagem Geral — tabelas de alunos e cursos, além de painel de estatísticas (total de alunos, cursos, alunos por turno e bolsistas)


🗂️ Estrutura do Projeto
sistemafaculdade/
├── Acionavel.java          # Interface com método executar()
├── Aluno.java              # Modelo de dados do aluno
├── Curso.java              # Modelo de dados do curso
├── Matricula.java          # Modelo de dados da matrícula
├── SistemaFaculdade.java   # Lógica de negócio e listas em memória
├── TelaLogin.java          # Tela de autenticação
├── TelaMenu.java           # Menu principal
├── TelaSplash.java         # Tela de carregamento inicial
├── TelaCadastroAluno.java  # CRUD de alunos
├── TelaCadastroCurso.java  # CRUD de cursos
├── TelaMatricula.java      # Vinculação aluno-curso
├── TelaListagem.java       # Listagem e estatísticas
└── TesteSistema.java       # Classe main — ponto de entrada

⚙️ Pré-requisitos

Java JDK 8 ou superior
IDE com suporte a projetos Java (NetBeans, IntelliJ IDEA, Eclipse, etc.)


▶️ Como Executar

Clone o repositório:

bash   git clone https://github.com/TaisSouz23/TRM_Faculdade.git

Abra o projeto na sua IDE.
Certifique-se de que os recursos de imagem (logo.png) estão dentro da pasta sistemafaculdade/.
Execute a classe TesteSistema.java.


🔐 Credenciais de Acesso (padrão)
UsuárioSenhaadmin1234

🖥️ Tecnologias Utilizadas
TecnologiaUsoJavaLinguagem principalJava SwingInterface gráfica (GUI)ArrayListArmazenamento em memória

📌 Observações

Os dados são armazenados em memória durante a execução. Não há persistência em banco de dados — ao fechar o sistema, os dados são perdidos.
O projeto utiliza o padrão de interface Acionavel para padronizar a abertura das telas via método executar().

👥 Colaboradores
Trabalho desenvolvido em trio para a disciplina de Programação Orientada a Objetos.

@TaisSouz23
@mrvinicius25
@RaymondLima

👨‍🏫 Professor
Projeto desenvolvido como trabalho avaliativo para a disciplina de Programação Orientada a Objetos.
