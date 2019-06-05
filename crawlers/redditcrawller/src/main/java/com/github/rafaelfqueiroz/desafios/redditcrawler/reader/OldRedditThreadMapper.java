package com.github.rafaelfqueiroz.desafios.redditcrawler.reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.RedditThread;

public class OldRedditThreadMapper implements CrawlerReaderMapper<WebElement, RedditThread>{

	@Override
	public RedditThread mapItems(WebElement tElement) {
		
		String upvote = tElement.findElement(By.cssSelector("div.score.unvoted")).getAttribute("title");
		String title = tElement.findElement(By.cssSelector("a.title.may-blank")).getText();
		String link = tElement.findElement(By.cssSelector("a.title.may-blank")).getAttribute("href");
		String linkComments = tElement.findElement(By.cssSelector("a.title.may-blank")).getAttribute("href");
		
		RedditThread thread = new RedditThread();
		
		thread.setUpvotes(upvote.isEmpty() ? 0 : Integer.parseInt(upvote));
		thread.setTitle(title);
		thread.setLink(link);
		thread.setLinkComments(linkComments);
		
		return thread;
	}

}
