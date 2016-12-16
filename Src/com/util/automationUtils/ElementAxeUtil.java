package com.util.automationUtils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Jomon Thanuvelil Johny
 *
 */
public class ElementAxeUtil {

    public WebElement getParent(WebElement element) {
	return element.findElement(By.xpath(".."));
    }

    // lets you select any ancestors [e.g., Parent and Grandparent] of wrt
    // current node.
    public List<? extends WebElement> getAncestors(WebElement element) {
	return element.findElements(By.xpath("ancestor::*"));
    }

    // Ancestor-or-self lets you select any ancestors[ Parent and Grandparent]
    // of the current node including the current node.
    public List<? extends WebElement> getAncestorsOrSelf(WebElement element) {
	return element.findElements(By.xpath("ancestor-or-self::*"));
    }

    // Preceding returns all in the document before the current node.
    public List<? extends WebElement> getPrecedingElementsInDocument(WebElement element) {
	return element.findElements(By.xpath("preceding::*"));
    }

    // Preceding-sibling is a reverse of Following-sibling;  Preceding-sibling
    // returns all the sibling before the current node.
    public List<? extends WebElement> getPrecedingSiblings(WebElement element) {
	return element.findElements(By.xpath("preceding-sibling::*"));
    }

    // Child returns all the children in the current node.
    public List<? extends WebElement> getChildren(WebElement element) {
	return element.findElements(By.xpath("child::*"));
    }

    // Gets the first sibling element that precedes the current element
    public WebElement getPrecedingSibling(WebElement element) {
	return element.findElement(By.xpath("preceding-sibling::*[1]"));
    }

    // Descendant lets you select all descendants [e.g., Children and
    // Grandchildren] of the current node.
    public List<? extends WebElement> getDescendants(WebElement element) {
	return element.findElements(By.xpath("descendant::*"));
    }

    // Descendant-or-self lets you select all descendants [e.g., Children and
    // Grandchildren] of the current node including the current node.
    public List<? extends WebElement> getDescendantsOrSelf(WebElement element) {
	return element.findElements(By.xpath("descendant-or-self::*"));
    }

    // Following returns all in the document after the closing tag of the
    // current node.
    public List<? extends WebElement> getFollowingElementsInDocument(WebElement element) {
	return element.findElements(By.xpath("following::*"));
    }

    // Following-sibling returns all the sibling after the closing tag of the
    // current node.
    public List<? extends WebElement> getFollowingSiblings(WebElement element) {
	return element.findElements(By.xpath("following-sibling::*"));
    }

}
