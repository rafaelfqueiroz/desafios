package com.github.rafaelfqueiroz.desafios.redditcrawller.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.rafaelfqueiroz.desafios.redditcrawler.util.RedditNameRetriever;

public class RedditNameRetrieverTest {

	@Test
	public void testRetrievingFromProps() {
		String nameCats = "cats";
		String nameNews = "news";
		String nameBrazil = "brazil";
		String splitter = ";";
		
		String[] retrieve = new RedditNameRetriever().retrieve(new StringBuilder()
												.append(nameCats)
												.append(splitter)
												.append(nameNews)
												.append(splitter)
												.append(nameBrazil)
												.toString(), splitter);
		
		assertTrue(nameCats.equals(retrieve[0]));
		assertTrue(nameNews.equals(retrieve[1]));
		assertTrue(nameBrazil.equals(retrieve[2]));
	}
	
	@Test
	public void testRetrievingFromTelegramCommand() {
		String command = "/NadaPraFazer";
		String nameCats = "cats";
		String nameNews = "news";
		String nameBrazil = "brazil";
		String splitter = ";";
		
		String[] retrieve = new RedditNameRetriever().retrieve(new StringBuilder("/NadaPraFazer ")
												.append(nameCats)
												.append(splitter)
												.append(nameNews)
												.append(splitter)
												.append(nameBrazil)
												.toString().replace(command, "").trim(), splitter);
		
		assertTrue(nameCats.equals(retrieve[0]));
		assertTrue(nameNews.equals(retrieve[1]));
		assertTrue(nameBrazil.equals(retrieve[2]));
	}
	
}
