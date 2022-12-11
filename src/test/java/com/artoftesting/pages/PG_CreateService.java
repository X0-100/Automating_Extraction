package com.artoftesting.pages;

import org.openqa.selenium.By;

public class PG_CreateService {

    public static By fn_servicetab() {
	return By.xpath("//a[@aria-label = \"Clickable Services\"]");
    }

    public static By fn_createservice_button() {
	return By.xpath("//button[@class = \"primary_button\"]//span");
    }

    public static By fn_enterservicename() {
	return By.xpath("//*[@aria-label=\"Service Name\"]");

    }

    public static By fn_selectappservertype() {

	return (By.xpath("//select[@class=\"Languagedropdown_Style\"][1]"));
    }

    public static By fn_entersleepinterval() {
	return By.xpath("//*[@aria-label=\"Sleep Interval\"]");
    }

}
