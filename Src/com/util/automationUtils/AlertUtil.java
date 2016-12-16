package com.util.automationUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

/**
 * @author Jomon Thanuvelil Johny
 *
 */
public class AlertUtil {

    public static void acceptAlert(WebDriver driver) {
	Alert alert = driver.switchTo().alert();
	alert.accept();
    }

    public static String acceptAlertIfDetected(int time, WebDriver driver) {
	String messageText = "";
	if (WebDriverWaitUtil.waitUntilAlertIsPresent(time, driver)) {
	    messageText = driver.switchTo().alert().getText();
	    driver.switchTo().alert().accept();
	}
	return messageText;
    }

}
