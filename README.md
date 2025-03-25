# Mercado Bitcoin - Teste Técnico

Este projeto consiste em um aplicativo Android desenvolvido para listar exchanges e exibir seus detalhes. O objetivo do teste é demonstrar habilidades com as tecnologias Android modernas, arquitetura MVVM e boas práticas de desenvolvimento.

## Tecnologias Utilizadas
- **Kotlin** - Linguagem principal do projeto
- **Jetpack Compose** - Para a construção da interface de usuário declarativa
- **MVVM (Model-View-ViewModel)** - Arquitetura utilizada para separação de responsabilidades
- **Coroutines + Flow** - Para operações assíncronas e gerenciamento de estado
- **Koin** - Injeção de dependências
- **Retrofit** - Para comunicação com APIs
- **JUnit + Mockk** - Para testes unitários

## Funcionalidades
- Listagem de exchanges
- Exibição de detalhes de cada exchange
- Testes unitários garantindo a confiabilidade do código

## Como Rodar o Projeto
1. Clone o repositório:
   ```bash
   git clone [https://github.com/seu-usuario/mercado-bitcoin-test.git](https://github.com/xrogix/mercado_bitcoin.git
   ```
2. Abra o projeto no Android Studio (recomendado: Giraffe ou superior)
3. Construa e execute o app em um emulador ou dispositivo físico

## Estrutura do Projeto
```
app/
|-- data/              # Camada de dados (API, models)
|-- domain/            # Regras de negócio
|-- presentation/      # Camada de apresentação (ViewModel, telas e componentes Compose)
|-- di/                # Módulos de injeção de dependência
|-- extensions/        # Classes utilitárias e helpers
|-- navigation/        # Files para configuração de navegação do app
|-- MainApplication.kt # Aplicação do app
```

---
Este repositório faz parte de um teste técnico para a empresa **Mercado Bitcoin**.

