#Plugin de Strings

Este projeto consiste na resolução do desafio IdWall para plugin de strings.

### Pré-requisitos

 - Java 8
 
### Execução do Plugin de Strings
Para execução deste projeto, deve-se realizar os seguintes passos:

1. Clonar o projeto
2. Gerar o .jar.
Para isso, utilize o *gradlew* para realizar o build do projeto, através do comando `./gradlew build`. O .jar gerado estará no subdiretório `/build/libs` nomeado como *mailplugin-0.0.1-SNAPSHOT.jar*.

3. Execute o .jar
A execução do jar pode ser feita com a execução do comando *java -jar mailplugin-0.0.1-SNAPSHOT.jar*. É possível informar alguns parametros de configuração que definem o comportamento do plugin.

	- `--config.lineLength`: define o limite de caracteres de cada linha. Default 40.
	- `--config.justified`: define se o texto deve ser impresso em formato justificado (*true*) ou padrão (*false*). Default *false*.
	- `--config.inputText`: parâmetro utilizado para informar algum texto alternativo ao padrão para ser formatado pelo plugin. O texto infromado deve estar *obrigatoriamente* entre aspas duplas(`""`). Default apresentado na descrição do desafio.
	
Sendo assim, um exemplo de comando para executar o jar pode ser definido da seguinte forma:

`java -jar mailplugin-0.0.1-SNAPSHOT.jar --config.lineLength=30 --config.justified=true --config.inputText="TEXTO A SER FORMATADO PELO PLUGIN E IMPRESSO COMO RESULTADO"`

### Possíveis problemas

- Caso o texto informado no parâmetro `--config.inputText` não esteja entre aspas duplas (`""`), será considerado o texto padrão.