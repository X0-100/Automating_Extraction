package com.artoftesting.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.artoftesting.pages.PG_CreateService;

public class Module_Services_4_0 {

    public static String fn_assert_create_service_button(WebDriver driver) {

	String servicebtntxt = driver.findElement(PG_CreateService.fn_createservice_button()).getText();
	return servicebtntxt;
    }

    public static void fn_click_create_service_button(WebDriver driver) {
	driver.findElement(PG_CreateService.fn_createservice_button()).click();
    }

    public static void fn_enter_service_name(WebDriver driver, String servicename) throws Exception {

	driver.findElement(PG_CreateService.fn_enterservicename()).click();
	driver.findElement(PG_CreateService.fn_enterservicename()).sendKeys(servicename);

    }

    public static void fn_select_service_type(WebDriver driver, String servicetype) {
	WebElement servicetypeselect = driver.findElement(PG_CreateService.fn_selectappservertype());
	Select select = new Select(servicetypeselect);
	select.selectByValue(servicetype);

    }

    public static void fn_enter_sleep_interval(WebDriver driver, int sleep) {
	driver.findElement(PG_CreateService.fn_entersleepinterval()).sendKeys(String.valueOf(sleep));

    }

    public static void fn_select_app_server_type(WebDriver driver, String appserver) {
	// TODO Auto-generated metho

    }

}
