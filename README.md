# Microservices Application

## Table of Contents
+ [About](#about)
+ [Getting Started](#getting_started)
+ [Usage](#usage)
+ [Contributing](../CONTRIBUTING.md)

## About <a name = "about"></a>
This microservices project aims at a subscription model, providing users access to premium content through subscription. It includes services for authentication, subscription management, payment processing, and access control.

## Getting Started <a name = "getting_started"></a>
Basta gerar o jar com:
`./gradlew clean build`
e com o docker instalado executar o comando:
```shell
docker compose up
```

### Prerequisites

What things you need to install the software and how to install them.

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running.

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo.

## Usage <a name = "usage"></a>

Para acessar a base de dados:

```sql

```

## Comandos Docker

```shell
// remove todas imagens
docker rmi -f $(docker images -q)
```