package com.artoftesting.pages;

import org.openqa.selenium.By;

public class PG_CreateDefinition {

    public static By fn_xpathcreatedefinitionbutton() {
	return By.xpath("//button[@class=\"Primary-button-1\"]");
    }

    public static By fn_definitiontab() {
	return By.xpath("//a[@aria-label = \"Clickable Definition\"]");
    }

    public static By fn_xpathdefinitionnametxtbox() {
	return By.xpath("//input[@id=\"definition\"]");
    }

    public static By fn_xpathdomainnameDropdown() {
	return By.xpath("//select[@class='Createdefinitiondropdown']");
    }

    public static By fn_xpathcountrynameDropdown() {
	return By.xpath("//select[@class='Createdefinitiondropdown']");
    }

    public static By fn_iddescriptionTextBox() {
	return By.id("createdefinition_description");
    }

    public static By fn_clickcreateButton() {
	return By.id("b2");
    }

    public static By fn_clickShowList() {
	return By.xpath("//a[@href= \"#/showlist\"]");

    }

    public static By fn_selectDefinitionList() {
	return By.xpath("//table[@class=\"MuiTable-root MuiTable-stickyHeader\"]");
    }

}
