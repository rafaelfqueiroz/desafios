package com.github.rafaelfqueiroz.desafios.redditcrawler.properties;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.RedditThread;
import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.Subreddit;
import com.github.rafaelfqueiroz.desafios.redditcrawler.drivers.ChromeDriverFactory;
import com.github.rafaelfqueiroz.desafios.redditcrawler.drivers.WebDriverFactory;
import com.github.rafaelfqueiroz.desafios.redditcrawler.processor.CrawlerProcessor;
import com.github.rafaelfqueiroz.desafios.redditcrawler.processor.RedditThreadProcessor;
import com.github.rafaelfqueiroz.desafios.redditcrawler.reader.CrawlerReader;
import com.github.rafaelfqueiroz.desafios.redditcrawler.reader.CrawlerReaderMapper;
import com.github.rafaelfqueiroz.desafios.redditcrawler.reader.OldRedditThreadMapper;
import com.github.rafaelfqueiroz.desafios.redditcrawler.reader.RedditReader;
import com.github.rafaelfqueiroz.desafios.redditcrawler.writer.CrawlerWriter;
import com.github.rafaelfqueiroz.desafios.redditcrawler.writer.SubredditConsoleWriter;

@Configuration
@Profile({"cli","telegram"})
public class RedditCrawlerConfiguration {

	@Bean
	public CrawlerReaderMapper<WebElement, RedditThread> crawlerReaderMapper() {
		return new OldRedditThreadMapper();
	}
	
	@Bean
	public CrawlerProcessor<RedditThread, RedditThread> crawlerProcessor() {
		return new RedditThreadProcessor();
	}
	
	@Bean
	public CrawlerReader<RedditThread> crawlerReader(CrawlerReaderMapper<WebElement, RedditThread> mapper, WebDriverFactory webDriverFactory) {
		return new RedditReader(mapper, webDriverFactory);
	}
	
	@Bean
	public CrawlerWriter<Subreddit> crawlerWriter() {
		return new SubredditConsoleWriter();
	}
	
	@Bean
	public WebDriverFactory webDriverFactory(@Value("${config.driverPath}") String driverPath ) {
		return new ChromeDriverFactory(driverPath);
	}
	
}
