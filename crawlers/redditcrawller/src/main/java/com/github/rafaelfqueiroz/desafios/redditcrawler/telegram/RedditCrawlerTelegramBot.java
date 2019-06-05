package com.github.rafaelfqueiroz.desafios.redditcrawler.telegram;

import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.RedditThread;
import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.Subreddit;
import com.github.rafaelfqueiroz.desafios.redditcrawler.properties.CrawlerProperties;
import com.github.rafaelfqueiroz.desafios.redditcrawler.properties.TelegramProperties;
import com.github.rafaelfqueiroz.desafios.redditcrawler.service.SubRedditCrawlerService;
import com.github.rafaelfqueiroz.desafios.redditcrawler.telegram.exception.InvalidTelegramCommandException;
import com.github.rafaelfqueiroz.desafios.redditcrawler.telegram.exception.TelegramCrawlerException;
import com.github.rafaelfqueiroz.desafios.redditcrawler.util.RedditNameRetriever;
import com.github.rafaelfqueiroz.desafios.redditcrawler.util.SubredditFromNamesParser;
import com.github.rafaelfqueiroz.desafios.redditcrawler.writer.TelegramSubredditWriter;

public class RedditCrawlerTelegramBot extends TelegramLongPollingBot {
	
	private SubRedditCrawlerService service;
	private CrawlerProperties config;
	private TelegramProperties props;
	
	public RedditCrawlerTelegramBot(SubRedditCrawlerService service, CrawlerProperties config, TelegramProperties props) {
		this.service = service;
		this.config = config;
		this.props = props;
	}

	@Override
	public void onUpdateReceived(Update update) {
		try {
			isCommandValid(update);
			String text = update.getMessage().getText();
			
			String[] subRedditNames = new RedditNameRetriever().retrieve(text.replace(props.getCommand(), ""), config.getSplitter());
			List<Subreddit> subReddits = new SubredditFromNamesParser(config.getBaseUrl(), subRedditNames).parse();
			
			service.executeSteps(subReddits, new TelegramSubredditWriter((s) -> sendMessage(update, s)));
			
		} catch (TelegramCrawlerException e) {
			sendMessage(update, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void sendMessage(Update update, Subreddit sub) {
		sendMessage(update, sub.getUrl());
		for (RedditThread rt : sub.getRedditThreads()) {
			sendMessage(update, rt.toString());
		}
	}
	
	private void sendMessage(Update update, String text) {
		SendMessage message = new SendMessage() 
				 .setChatId(update.getMessage().getChatId())
				 .setText(text).enableHtml(true);
		
		try {
			execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private boolean isCommandValid(Update update) {
		if (update.hasMessage() && 
			update.getMessage().hasText() && 
			update.getMessage().isCommand() && 
			update.getMessage().getText().contains(props.getCommand())) {
			return true;
		}
		throw new InvalidTelegramCommandException();
	}

	@Override
	public String getBotUsername() {
		return props.getUsername();
	}

	@Override
	public String getBotToken() {
		return props.getToken();
	}

}
