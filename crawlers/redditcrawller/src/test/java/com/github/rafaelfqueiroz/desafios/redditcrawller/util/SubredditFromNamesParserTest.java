package com.github.rafaelfqueiroz.desafios.redditcrawller.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.Subreddit;
import com.github.rafaelfqueiroz.desafios.redditcrawler.util.SubredditFromNamesParser;

public class SubredditFromNamesParserTest {

	@Test
	public void testSubredditCreationFromNamesParsing() {
		String url = "http://old.reddit.com/r/";
		String[] names = {"brazil", "cats"};
		
		List<Subreddit> subs = new SubredditFromNamesParser(url, names).parse();
		
		assertTrue(subs.size() == names.length);
		
		boolean badFormatUrl = true; 
		int i = 0;
		for (Subreddit subreddit : subs) {
			if (subreddit.getUrl() == null || !subreddit.getUrl().equals(url+names[i])) {
				badFormatUrl = true;
				break;
			} else {
				badFormatUrl = false;
			}
			i++;
		}
		
		assertFalse(badFormatUrl);
		
	}
	
}
