/**
 * 
 */
package com.util.automationUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.util.stringOperations.StringUtil;

/**
 * @author Jomon Thanuvelil Johny
 *
 */
public class WebElementUtil {
    private static String DEFAULT_HIGHLIGHT_STYLE = "color: red; border: 2px dashed #32CD32;background-color:#6EFF70";

    public static void setAttribute(WebDriver driver, WebElement element, String attributeName, String attributeValue) {
	((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '"
		+ attributeValue + "')", element);
    }

    public static Select getSelectForWebElement(WebElement element) {
	return new Select(element);
    }

    public static void scrollTo(WebDriver driver, WebElement element) {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void highlight(WebDriver driver, WebElement element, String cssVal) {
	String tempCSSProp = StringUtil.isEmptyString(cssVal) ? DEFAULT_HIGHLIGHT_STYLE : cssVal;
	for (int i = 0; i < 2; i++) {
	    setAttribute(driver, element, "style", tempCSSProp);
	    setAttribute(driver, element, "style", "");
	}
    }

    public static int getX(WebElement element) {
	return element.getLocation().getX();
    }

    public static int getY(WebElement element) {
	return element.getLocation().getY();
    }

    /*
     * TEXT OPERATIONS
     */
    public static void setValueUsingJsExecutor(WebDriver driver, WebElement element, String text) {
	((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + text + "')", element);
    }

    public static String getInnerHtml(WebDriver driver, WebElement element) {
	return ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML", element).toString();
    }

    public static void setInnerHtml(WebDriver driver, WebElement element, String innerHtml) {
	((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '" + innerHtml + "'", element);
    }

    public static String getWebElementText(WebDriver driver, WebElement element) {
	String text = null;
	String tagName = element.getTagName();
	if (tagName.equalsIgnoreCase("input")) {
	    text = element.getAttribute("value");
	} else if (tagName.equalsIgnoreCase("select")) {
	    text = getInnerHtml(driver, getSelectForWebElement(element).getFirstSelectedOption());
	} else if (tagName.equalsIgnoreCase("span")) {
	    text = getInnerHtml(driver, element);
	} else {
	    text = getInnerHtml(driver, element);
	}
	return text;
    }

    /*
     * CLICK OPERATIONS
     */
    public static void clickElementByAction(WebDriver driver, WebElement element) {
	Actions actionObject = new Actions(driver);
	actionObject.moveToElement(element).click().build().perform();
    }

    public static void clickUsingJs(WebDriver driver, By by) {
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(by));

    }

    public void clickElementUsingBot(WebElement element) {
	int width = element.getSize().getWidth();
	int height = element.getSize().getHeight();
	int x = element.getLocation().getX() + width / 2;
	int y = element.getLocation().getY() + height / 2;
	Robot bot = null;
	try {
	    bot = new Robot();
	} catch (AWTException e) {
	    System.err.println(e.getMessage());
	}
	bot.mouseMove(x, y);
	bot.mousePress(InputEvent.BUTTON1_MASK);
	bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
