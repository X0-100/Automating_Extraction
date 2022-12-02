package com.artoftesting.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.artoftesting.pages.PG_CreateDefinition;

public class Module_Definition_4_0 {

    public static String fn_module_definition_title_assert(WebDriver driver) {
	return driver.getTitle();
    };

    public static void fn_create_definition_button_action(WebDriver driver) throws InterruptedException {
	driver.findElement(PG_CreateDefinition.fn_xpathcreatedefinitionbutton()).click();
	Thread.sleep(9000);
    };

    public static void fn_enter_definition_name_action(WebDriver driver, String defname) {
	driver.findElement(PG_CreateDefinition.fn_xpathdefinitionnametxtbox()).click();
	driver.findElement(PG_CreateDefinition.fn_xpathdefinitionnametxtbox()).sendKeys(defname);
    };

    public static void fn_select_domain_name_action(WebDriver driver, String domainname) {
	List<WebElement> elementDomain = driver.findElements(PG_CreateDefinition.fn_xpathdomainnameDropdown());
	for (int i = 0; i < elementDomain.size(); i++) {
	    elementDomain.get(0);
	    Select selectdomain = new Select(elementDomain.get(0));
	    selectdomain.selectByVisibleText(domainname);

	}
    };

    public static void fn_select_country_name_action(WebDriver driver, String countryname) {
	List<WebElement> elementCountry = driver.findElements(PG_CreateDefinition.fn_xpathcountrynameDropdown());
	for (int i = 0; i < elementCountry.size(); i++) {
	    elementCountry.get(1);
	    Select selectCountry = new Select(elementCountry.get(1));
	    selectCountry.selectByVisibleText(countryname);
	}
    };

    public static void fn_enter_description_action(WebDriver driver, String description) {
	driver.findElement(PG_CreateDefinition.fn_iddescriptionTextBox()).click();
	driver.findElement(PG_CreateDefinition.fn_iddescriptionTextBox()).sendKeys(description);
    };

    public static void fn_definition_tab_action(WebDriver driver, WebDriverWait wait) throws InterruptedException {

	// ActionListeners.listener_alpha_301_(driver.findElement(PG_CreateDefinition.fn_definitiontab()),
	// driver, wait);

	// driver.findElement(PG_CreateDefinition.fn_definitiontab()).click();

	// wait.until(ExpectedConditions.alertIsPresent());

	// driver.switchTo().alert().accept();

    }

    public static void fn_clickcreate(WebDriver driver) {
	driver.findElement(PG_CreateDefinition.fn_clickcreateButton()).click();
    }

    public static void fn_click_show_list(WebDriver driver) {
	/*
	 * JavascriptExecutor jse = (JavascriptExecutor) driver;
	 * jse.executeScript("arguments[0].click()",
	 * driver.findElement(PG_CreateDefinition.fn_clickShowList()));
	 */
	/*
	 * System.out.println(driver.findElement(PG_CreateDefinition.fn_clickShowList())
	 * .getAttribute("href"));
	 */
	driver.findElement(PG_CreateDefinition.fn_clickShowList()).click();
    }

    public static void fn_select_table_data(WebDriver driver) {
	List<WebElement> def_elements = driver.findElements(PG_CreateDefinition.fn_selectDefinitionList());
	System.out.println(def_elements.get(1).getText());
	/* //td[text()="Invoice~T1"] */
	if (def_elements.get(1).getText().contains("Invoice~T1")) {
	    driver.findElement(By.xpath("//td[text()=\"Invoice~T1\"]")).click();
	}
    }

}
