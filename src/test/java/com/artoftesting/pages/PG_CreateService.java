package com.artoftesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PG_CreateService {

    public static By fn_servicetab() {
	return By.xpath("//a[@aria-label = \"Clickable Services\"]");
    }

    public static By fn_createservice_button() {
	return By.xpath("//button[@class = \"primary_button\"]//span");
    }

    public static By fn_click_create_service_button(WebDriver driver) {
	return By.xpath("//button[@class = \"primary_button\"]//span");
    }

}
