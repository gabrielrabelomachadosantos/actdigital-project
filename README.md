# Projeto Act Digital

## Requisitos

Para rodar o projeto é necessário ter o **Java 21**, **Docker**, e **docker-compose** instalados.

## Rodando o Banco de Dados

Para criar o banco de dados, basta executar o seguinte comando na raiz do projeto:

```bash
docker-compose up -d
```

## Testando a aplicação

```bash
curl --location 'http://localhost:3000/calculate_features' \
--header 'Content-Type: application/json' \
--data '{ 
    "total_amount": 87.99, 
    "cpf":"91554035066", 
    "cc": { 
        "bin":"548110", 
        "last4":"2104" 
    }
}'
```

Outro cpf para testes: 48747070099