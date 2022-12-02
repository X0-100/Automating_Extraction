package com.artoftesting.test;

import org.openqa.selenium.WebDriver;

import com.artoftesting.pages.PG_CreateService;

public class Module_Services_4_0 {

    public static String fn_assert_create_service_button(WebDriver driver) {

	String servicebtntxt = driver.findElement(PG_CreateService.fn_createservice_button()).getText();
	return servicebtntxt;
    }

    public static void fn_click_create_service_button(WebDriver driver) {
	driver.findElement(PG_CreateService.fn_createservice_button()).click();
    }

}
