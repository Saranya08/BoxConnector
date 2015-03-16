package com.offercast.scribe.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: 312277
 * Date: 3/16/15
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class EventGenerator {
    private static final Logger LOGGER = Logger.getLogger("logfile");

    public void eventImporter(String url) {
     LOGGER.info(url) ;
        System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com&q="+url);

    }
}
