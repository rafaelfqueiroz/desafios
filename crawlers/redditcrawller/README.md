#Reddit Crawler

Este projeto consiste na resolução do desafio IdWall para crawler do reddit.

### Pré-requisitos

 - Java 8

### Execução do RedditCrawler
Para execução deste projeto, deve-se realizar os seguintes passos:

1. Clonar o projeto
2. Gerar o .jar.
Para isso, utilize o *gradlew* para realizar o build do projeto, através do comando `./gradlew build`. O .jar gerado estará no subdiretório `/build/libs` nomeado como *redditcrawler-0.0.1-SNAPSHOT.jar*.

3. Execute o .jar
A execução do jar pode ser feita com a execução do comando *java -jar redditcrawler-0.0.1-SNAPSHOT.jar*. É possível informar alguns parametros de configuração que definem o comportamento do crawler.

	- `--spring.profiles.active`: os profiles definem o modo de execução do crawler, podendo ser cli, ou telegram. Ex: `--spring.profiles.active=telegram,cli`
	
	- `--config.subReddits`: define os nomes dos SubReddits que serão lidos pelo crawler.
	
	- `--config.driverPath`: é necessário definir o caminho do para o driver. Por padrão o projeto já inclui o driver do chrome, o qual fica no diretório `drivers/chromedriver`. Considerando que você estará executando o *redditcrawler-0.0.1-SNAPSHOT.jar* a partir do diretorio `/build/libs`, não é necessário definir este parâmetro, pois seu valor default já referencia o driver contido no projeto.
	
	- `--telegram.command`: o comando padrão para comunicação com telegram é `/NadaPraFazer`. Caso haja necessidade de alterá-lo, defina através deste parâmetro.
	
Sendo assim, um exemplo de comando para executar o jar com os modos CLI e Telegram pode ser definido da seguinte forma:

`java -jar redditcrawler-0.0.1-SNAPSHOT.jar --spring.profiles.active=telegram,cli --config.subReddits=cats;brazil;worldnews`

###Telegram

Após iniciar o crawler com o modo *telegram` ativo, é possível enviar comandos para o bot do crawler. O username do bot é recrawbot.

O comando padrão aceito pelo bot é `/NadaPraFazer` e deve ser seguido pelos nomes dos subreddis, separados por vírgula. 

Exemplo: `/NadaPraFazer programming;dogs;brazil`

### Possíveis problemas

- No modo telegram, caso você não informe o comando `/NadaPraFazer`, o bot apresentará a mensagem *Comando inválido!*
- No modo telegram, caso você não informe o nome de nenhum subreddit, o bot apresentará a mensagem *Informe o nome de um subreddit!*