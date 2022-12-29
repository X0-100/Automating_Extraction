package com.artoftesting.pages;

import org.openqa.selenium.By;

public class PG_CreateService {

    public static By fn_servicetab() {
	return (By.xpath("//a[@aria-label = \"Clickable Services\"]"));
    }

    public static By fn_createservice_button() {
	return (By.xpath("//button[@class = \"primary_button\"]//span"));
    }

    public static By fn_enterservicename() {
	return (By.xpath("//*[@aria-label=\"Service Name\"]"));

    }

    public static By fn_selectappservertype() {

	return (By.xpath("//select[@class=\"Languagedropdown_Style\"][1]"));
    }

    public static By fn_entersleepinterval() {
	return (By.xpath("//*[@aria-label=\"Sleep Interval\"]"));
    }

    public static By fn_selectappserver() {
	return (By.xpath("//select[@class=\"Languagedropdown_Style\"][2]"));
    }

    public static By fn_inputappserverblock() {
	return (By.xpath("//*[@aria-label=\"App server URL\"]"));
    }

    public static By fn_appserverportblock() {
	return (By.xpath("//*[@aria-label=\"App server Port\"]"));
    }

    public static By fn_cabinetnameblock() {
	return (By.xpath("//*[@aria-label=\"Cabinet Name\"]"));
    }

    public static By fn_usernameblock() {
	return (By.xpath("//*[@aria-label=\"User Name\"]"));
    }

    public static By fn_passwordblock() {
	return (By.xpath("//*[@aria-label=\"Password\"]"));
    }

    public static By fn_queue() {
	return (By.xpath("//*[@aria-label=\"Queue Name\"]"));
    }

    public static By fn_selectengine() {
	return (By.xpath("//select[@class=\"Languagedropdown_Style\"][3]"));
    }

}
