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

    public static void fn_select_app_server_type(WebDriver driver, String appserverselect) {
	WebElement appservertype = driver.findElement(PG_CreateService.fn_selectappserver());
	Select select = new Select(appservertype);
	select.selectByValue(appserverselect);

    }

    public static void fn_appserverurl(WebDriver driver, String appserverurl) {
	driver.findElement(PG_CreateService.fn_inputappserverblock()).click();
	driver.findElement(PG_CreateService.fn_inputappserverblock()).sendKeys(appserverurl);
    }

    public static void fn_appserverport(WebDriver driver, String appserverport) {
	driver.findElement(PG_CreateService.fn_appserverportblock()).click();
	driver.findElement(PG_CreateService.fn_appserverportblock()).sendKeys(appserverport);
	;
    }

    public static void fn_cabinetname(WebDriver driver, String cabinetname) {
	driver.findElement(PG_CreateService.fn_cabinetnameblock()).click();
	driver.findElement(PG_CreateService.fn_cabinetnameblock()).sendKeys(cabinetname);
    }

    public static void fn_username(WebDriver driver, String username) {
	driver.findElement(PG_CreateService.fn_usernameblock()).click();
	driver.findElement(PG_CreateService.fn_usernameblock()).sendKeys(username);
    }

    public static void fn_password(WebDriver driver, String password) {
	driver.findElement(PG_CreateService.fn_passwordblock()).click();
	driver.findElement(PG_CreateService.fn_passwordblock()).sendKeys(password);
    }

    public static void fn_queuename(WebDriver driver, String queuename) {
	driver.findElement(PG_CreateService.fn_queue()).click();
	driver.findElement(PG_CreateService.fn_queue()).sendKeys(queuename);

    }

    public static void fn_enginename(WebDriver driver, String engine) {
	WebElement enginenameselect = driver.findElement(PG_CreateService.fn_selectengine());
	Select select = new Select(enginenameselect);
	select.selectByValue(engine);

    }

}
