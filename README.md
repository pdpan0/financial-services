# Financial Services Application

## Sobre <a name = "about"></a>
Este projeto visa simular operações financeiras, tem como principio 2 microsserviços que simulam uma interação de usuários e transfêrencias.

## Como executar <a name = "getting_started"></a>
Basta gerar o jar com:
`./gradlew clean build`
e com o docker instalado executar o comando:
```shell
docker compose up -d
```

Isto irá inicializar os contêiners do banco de dados e os microsserviços correspondentes.

Para rodar local é necessário subir um banco de dados local e substituir a váriavel:
**DB_DOMAIN_LOCAL** em ambos os applications.yaml

### Pré Requisitos

Este projeto é feito em kotlin e é necessário utilização do docker para rodar o banco de dados em postgresql.

### Documentação <a name = "usage"></a>

Este projeto possui uma documentação, basta adicionar o domínio ao seguinte endpoint:

```
http://DOMAIN:PORT/swagger-ui/index.html
```