package com.github.rafaelfqueiroz.desafios.mailplugin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.rafaelfqueiroz.desafios.mailplugin.domain.Line;

public class LineTest {
	

	@Test
	public void testAppendWordInEmptyLine() {
		Line line = new Line(40);
		boolean appended = line.append("In the beginning");
		
		assertTrue(appended);
	}
	
	@Test
	public void testAppendWordInFullLine() {
		Line line = new Line(40);
		line.append("In the beginning God created the heavens");
		boolean appended = line.append("and");
		assertFalse(appended);
	}
	
	@Test
	public void testAppendWordExcedsLineLength() {
		Line line = new Line(40);
		line.append("and the earth. Now the earth was");
		boolean appended = line.append("formless");
		
		assertFalse(appended);
	}
}
