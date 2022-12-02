package ui_interactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionListeners {

    public static void listener_alpha_301_(WebElement element, WebDriver driver, WebDriverWait wait)
	    throws InterruptedException {
	String prev_window_handle = driver.getWindowHandle();
	Actions newwin = new Actions(driver);
	newwin.keyDown(Keys.SHIFT).click(element).keyUp(Keys.SHIFT).build().perform();

	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	for (String curr_window_handle : driver.getWindowHandles()) {
	    if (!prev_window_handle.contentEquals(curr_window_handle)) {
		driver.switchTo().window(curr_window_handle);
	    }
	}
	Thread.sleep(2000);
    }

}
