package com.artoftesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PG_Login {

    public static WebElement username;

    public static By fn_xpathloginbutton() {
	return By.xpath("//*[@type=\"button\"]");

    }

    public static By fn_idusername() {
	return By.id("username");

    }

    public static By fn_idpassword() {
	return By.id("password");

    }

}
