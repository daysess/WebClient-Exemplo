# WebClient-Exemplo

## Exemplo de implementação WebClient 

### Link de referência para estudo: 
Canal: AlgaWorks - Consumindo REST API com Spring WebClient
[https://www.youtube.com/watch?v=Q1BjCuAQRrQ]

A diferença entre o WebClient e RestTemplate é que o WebClient não é bloqueante. Após execução de requisição ele continuará a lágica mesmo sem a resposta. 

### Exemplos separados pelos commites:
- Utilizando o block: A utilização do block permite que a requisição seja bloquante como é usado no RestTemplate, ou seja, ele aguarda a resposta antes de passar para o proximo passo. 

- Utilizando o Mono.zip: A utilização do Mono.zip faz com que as requisições sejam em paralelo fazendo com que seja mais rápido. 
