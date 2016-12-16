/**
 * 
 */
package com.util.automationUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Jomon Thanuvelil Johny
 *
 */
public class WebDriverWaitUtil {

    public static boolean waitUntilAlertIsPresent(long waitingTimeInSeconds, WebDriver driver) {
	try {
	    Wait<WebDriver> wait = new WebDriverWait(driver, waitingTimeInSeconds);
	    return wait.until(ExpectedConditions.alertIsPresent()) != null;
	} catch (TimeoutException e) {
	    System.err.println("No alert was detected.");
	}
	return false;
    }

    public static void waitUntilElementIsLocated(WebDriver driver, int time, By elementLocator) {
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }
    
    public static void sleep(int seconds) {
	try {
	    Thread.sleep(seconds * 1000);
	} catch (InterruptedException e) {

	}
    }

}
