package com.github.rafaelfqueiroz.desafios.mailplugin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.rafaelfqueiroz.desafios.mailplugin.config.MailPluginProperties;
import com.github.rafaelfqueiroz.desafios.mailplugin.formatters.IdwallFormatter;
import com.github.rafaelfqueiroz.desafios.mailplugin.formatters.StringFormatter;

@Component
public class CLiPluginExecution implements CommandLineRunner {
	
	private static final String DEFAULT_INPUT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
	
	@Autowired
	private MailPluginProperties properties;
	
	@Override
	public void run(String... args) throws Exception {
		
		String text = properties.getInputText();
		
		if (text == null || text.isEmpty()) {
			text = DEFAULT_INPUT_TEXT;
		}
		
		// Print input data
        System.out.println("Inputs: ");
        System.out.println("Text: " + text);
        System.out.println("Limit: " + properties.getLineLength());
        System.out.println("Should justify: " + properties.isJustified());
        System.out.println("=========================");

        // Run IdwallFormatter
        final StringFormatter sf = new IdwallFormatter(properties.getLineLength(), properties.isJustified());
        String outputText = sf.format(text);

        // Print output text
        System.out.println("Output: ");
        System.out.println(outputText);
		
	}
	
}
