package com.github.rafaelfqueiroz.desafios.redditcrawller.processor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.RedditThread;
import com.github.rafaelfqueiroz.desafios.redditcrawler.processor.RedditThreadProcessor;

public class RedditThreadProcessorTest {

	@Test
	public void testThreadHasEnoughUpvotes() {
		RedditThread reddTred = new RedditThread();
		reddTred.setUpvotes(6000);
		
		RedditThread process;
		try {
			process = new RedditThreadProcessor().process(reddTred);
			assertNotNull(process);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testThreadHasNotEnoughUpvotes() {
		RedditThread reddTred = new RedditThread();
		reddTred.setUpvotes(3000);
		
		RedditThread process;
		try {
			process = new RedditThreadProcessor().process(reddTred);
			assertNull(process);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
