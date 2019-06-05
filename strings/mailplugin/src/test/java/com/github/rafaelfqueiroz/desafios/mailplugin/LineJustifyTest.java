package com.github.rafaelfqueiroz.desafios.mailplugin;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.rafaelfqueiroz.desafios.mailplugin.decorators.LineJustify;
import com.github.rafaelfqueiroz.desafios.mailplugin.domain.Line;

public class LineJustifyTest {

	@Test
	public void testJustifyLineLessThanLimit() {
		int limit = 40;
		Line line = new Line(limit);
		line.append("Lorem ipsum dolor sit amet");
		
		assertTrue(line.getLineLength() < limit);
		
		LineJustify justify = new LineJustify();
		
		String justifyLine = justify.format(line);
		
		assertTrue(justifyLine.length() == limit);
	}
	
	@Test
	public void testJustifyLineWithLimit() {
		int limit = 40;
		Line line = new Line(limit);
		line.append("Lorem ipsum dolor sit ammet, consectetur");
		
		assertTrue(line.getLineLength() == limit);
		
		LineJustify justify = new LineJustify();
		
		String justifyLine = justify.format(line);
		
		assertTrue(justifyLine.length() == limit);
	}
	
	@Test
	public void testJustifyLineEndsWithWhitespace() {
		int limit = 40;
		Line line = new Line(limit);
		line.append("Lorem ipsum dolor sit amet, consectetur ");
		
		LineJustify justify = new LineJustify();
		
		String justifyLine = justify.format(line);
		
		assertTrue(justifyLine.length() == limit);
	}
	
	
}
