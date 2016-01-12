#Solução

Para a aplicação foi escolhido o springboot para desenvolver os serviços. Boa documentação, fácil utilização e fácil 
transporte (pacote jar).

O desenvolvimento baseado em TDD, ou seja, primeiro os testes depois a implementação. 

Baseado em REST. A Aplicação recebe os dados do terreno e das sondas (Rovers aqui!), configura a missão com os dados do terreno e das sondas. Cada Sonda interpreta suas instruções e as executa no terreno conforme as regras. 
No final é retornado a lista das sondas em formato JSON com suas novas posições.

As missões agora estão sendo persistidas em memória (com.h2database). Um problema legal que tive foi o relacionamento 
@OneToMany e @ManyToOne entre Mission e os Rovers estava gerando um loop infinito (e consequentemente StackOverflowError) durante o parsing json do request. Para evitar isso estou usando as anotaçoes @JsonManagedReference e @JsonBackReference. 




# Requisitos Mínimos
JRE - Java 8
- Usada: Java(TM) SE Runtime Environment (build 1.8.0_45)

# Build:
$ mvn clean package

$ java -jar target/curiosity.jar 

# Entry-points  

POST - http://localhost:8080/mission
Retorna lista dos rovers com informação das posições atuais
Raw Data Post example: 
{
	"ground": {
		"topRightPosition": {
			"xPosition": "5",
			"yPosition": "5"
		},
		"bottomLeftPosition": {
			"xPosition": "0",
			"yPosition": "0"
		}
	},
	"rovers": [{
		"position": {
			"xPosition": "1",
			"yPosition": "2"
		},
		"direction": "N",
		"instructions": "LMLMLMLMM"
	}, {
		"position": {
			"xPosition": "1",
			"yPosition": "2"
		},
		"direction": "N",
		"instructions": "LMLMLMLMM"
	}]
}

GET - http://localhost:8080/mission/{missionId}
Retorna informação da missão.