# GERENCIAMENTO DE PESSOAS

> Este projeto tem como objetivo desenvolver uma API para gerenciamento de pessoas.
> Esse sistema não deve ser usado em uma aplicação real.

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://opensource.org/licenses/MIT)
[![Version](https://badge.fury.io/gh/tterb%2FHyde.svg)](https://github.com/wennersgc/api-gerenciamento-pessoas)

## O que fizemos
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de pessoas de um sistema).
* Relação de cada uma das operações acima com o padrão arquitetural REST
* Desenvolvimento de testes unitários para validação das funcionalidades

## Requisitos

* Java 11 ou versões superiores
* Maven 3.6.3 ou versões superiores.
* Banco de dados em memória: h2

Para instalar o projeto deve ter o [maven](https://maven.apache.org/) instalado e configurado na máquina

Windows, OS X & Linux
```sh
mvn install
```

Encontrar o arquivo **.jar** na pastar target e executar
```sh
java -jar nome_do_projeto
```

Basta acessar o projeto em 

http://localhost:8080
