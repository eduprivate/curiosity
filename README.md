#Solução

Para a aplicação foi escolhido o springboot para desenvolver os serviços. Boa documentação, fácil utilização e fácil 
transporte (pacote jar).

O desenvolvimento baseado em TDD, ou seja, primeiro os testes depois a implementação. 

Baseado em REST. A Aplicação recebe os dados do terreno e das sondas (Rovers aqui!), configura a missão com os dados do terreno
e das sondas. Cada Sonda interpreta suas instruções e as executa no terreno conforme as regras. No final é retornado a lista 
das sondas em formato JSON com suas novas posições.

As classes Mission e Rover estão desnecessariamente com getters e setters. Estou usando o RestTemplate nos testes e durante
os testes de integração ele não consegue converter o JSON para meu objeto. Não ocorre com a aplicação rodando 
em modo normal. Vou investigar isso. Primeiro vez que me deparo com o problema. 

Checagem de colisão: o ponto final de uma sonda é marcada e se a proxima sonda estiver para colidir o movimento é 
cancelado (sai do fluxo) até a próxima instrução válida. 

# Requisitos Mínimos
JRE - Java 8
- Usada: Java(TM) SE Runtime Environment (build 1.8.0_45)

# Build:
$ mvn clean package

$ java -jar target/curiosity.jar 

# Entry-points  

POST - http://localhost:8080/mission

Raw Data Post example: 
{
	"xPosition": "10",
	"yPosition": "10",
	"rovers": [{
		"xPosition": "1",
		"yPosition": "2",
		"direction": "N",
		"instructions": "LMLMLMLMM"
	}, {
		"xPosition": "3",
		"yPosition": "3",
		"direction": "E",
		"instructions": "MMRMMRMRRM"
	}]
}