package com.github.rafaelfqueiroz.desafios.redditcrawler.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory implements WebDriverFactory {
	
	public ChromeDriverFactory(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
	}

	@Override
	public WebDriver createDriver() {
		return new ChromeDriver();
	}

}
