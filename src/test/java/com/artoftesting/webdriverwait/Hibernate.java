package com.artoftesting.webdriverwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hibernate {

    public static WebDriver driver;

    public static Duration d;

    public static void fn_setwait(String expected_conditions, long seconds, WebDriver driver, By w_e_locator) {
	d = Duration.ofSeconds(seconds);

	if (expected_conditions.compareTo("visibilityOfElementLocated") == 0) {
	    new WebDriverWait(driver, d).until(ExpectedConditions.visibilityOfElementLocated(w_e_locator));

	}
	if (expected_conditions.compareTo("elementToBeClickable") == 0) {
	    new WebDriverWait(driver, d).until(ExpectedConditions.elementToBeClickable(w_e_locator)).click();

	}

    }

}
