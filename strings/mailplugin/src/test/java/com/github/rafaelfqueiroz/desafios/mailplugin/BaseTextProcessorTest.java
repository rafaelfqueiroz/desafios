package com.github.rafaelfqueiroz.desafios.mailplugin;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.github.rafaelfqueiroz.desafios.mailplugin.domain.BaseText;
import com.github.rafaelfqueiroz.desafios.mailplugin.domain.Line;
import com.github.rafaelfqueiroz.desafios.mailplugin.formatters.BaseTextProcessor;

public class BaseTextProcessorTest {
	
	private static final String TEST_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor "
			+ "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris "
			+ "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum "
			+ "dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia "
			+ "deserunt mollit anim id est laborum.";

	@Test
	public void testProcessedTextLinesAreInLimit() {
		int lineLimit = 40;
		BaseText base = new BaseTextProcessor().process(TEST_TEXT, lineLimit);
		
		boolean lineGreaterThanLimit=true;
		for (Line line : base.getLines()) {
			if (line.getLineLength() <= lineLimit) {
				lineGreaterThanLimit = false;
			} else {
				lineGreaterThanLimit=true;
				break;
			}
		}
		
		assertFalse(lineGreaterThanLimit);
		
	}
}
