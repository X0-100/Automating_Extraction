package com.artoftesting.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.artoftesting.pages.PG_CreateDefinition;
import com.artoftesting.pages.PG_CreateService;
import com.artoftesting.pages.PG_Login;
import com.artoftesting.util.DefinitionStorage;
import com.artoftesting.util.LoginReadData;

public class SuiteArchitect {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Duration d;

    public static WebDriverWait fn_setwait(long seconds) {
	d = Duration.ofSeconds(seconds);
	wait = new WebDriverWait(driver, d);
	return wait;
    }

    @BeforeTest
    public static void fn_initializechrome() throws Exception {

	driver = new ChromeDriver();
	System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
	driver.manage().window().maximize();

	DefinitionStorage.fn_createheader();
	Thread.sleep(3000);
	int dfcount = 3;
	DefinitionStorage.fn_write(dfcount);
	Thread.sleep(5000);

    }

    @DataProvider(name = "login-test-data")
    public static Object[][] fn_TestDataFeed() {

	LoginReadData.fn_initialize("./src/test/resources/LoginTestData/DataProvider.xlsx");

	int rows = LoginReadData.fn_getrowcount(0);
	int cells = LoginReadData.fn_getcellcount(0);

	String[][] credentials = new String[rows - 2][cells];

	for (int i = 0; i < rows - 2; i++) {
	    for (int j = 0; j < cells; j++) {
		credentials[i][j] = LoginReadData.fn_getdata(0, i + 2, j);
	    }
	}
	return credentials;
    }

    /* dataProvider = "login-test-data", */
    /* String username, String password */
    @Test(priority = 0)
    public static void fn_Login() throws Exception {

	driver.get("http://192.168.21.132:9102/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12000));
	driver.findElement(PG_Login.fn_idusername()).sendKeys("supervisor");
	driver.findElement(PG_Login.fn_idpassword()).sendKeys("supervisor351");
	driver.findElement(PG_Login.fn_xpathloginbutton()).click();

	fn_setwait(12000).until(
		ExpectedConditions.elementToBeClickable(driver.findElement(PG_CreateDefinition.fn_definitiontab())))
		.click();
	fn_setwait(12000).until(
		ExpectedConditions.visibilityOfElementLocated(PG_CreateDefinition.fn_xpathcreatedefinitionbutton()));

    }

    @DataProvider(name = "definition_names")
    public static Object[][] fn_TestDefinitionFeed() {
	LoginReadData.fn_initialize("./src/test/resources/DefinitionData/DefinitionStorage.xlsx");

	int rows = LoginReadData.fn_getrowcount(0);
	int cells = LoginReadData.fn_getcellcount(0);

	String[][] credentials = new String[rows - 1][cells];

	for (int i = 0; i < rows - 1; i++) {
	    for (int j = 0; j < cells; j++) {
		credentials[i][j] = LoginReadData.fn_getdata(0, i + 1, j);
	    }
	}
	return credentials;
    }

    @Test(dataProvider = "definition_names", priority = 1)
    public static void fn_DefinitionCreate(String defname, String domainname, String countryname, String description)
	    throws Exception {

	/*
	 * driver click link open in new window and closing the previous one
	 * https://www.selenium.dev/documentation/webdriver/interactions/windows/
	 *
	 */

	Module_Definition_4_0.fn_create_definition_button_action(driver);

	fn_setwait(12000).until(
		ExpectedConditions.visibilityOfElementLocated(PG_CreateDefinition.fn_xpathdefinitionnametxtbox()));

	String ppoupDefinition = Module_Definition_4_0.fn_module_definition_title_assert(driver);
	Assert.assertTrue(ppoupDefinition.compareTo("OmniXtract - Definition") == 0);

	Module_Definition_4_0.fn_click_show_list(driver);
	fn_setwait(12000).until(
		ExpectedConditions.visibilityOfElementLocated(PG_CreateDefinition.fn_xpathdefinitionnametxtbox()));

	Module_Definition_4_0.fn_select_table_data(driver);
	fn_setwait(12000).until(
		ExpectedConditions.visibilityOfElementLocated(PG_CreateDefinition.fn_xpathdefinitionnametxtbox()));

	Module_Definition_4_0.fn_enter_definition_name_action(driver, defname);
	fn_setwait(12000).until(
		ExpectedConditions.visibilityOfElementLocated(PG_CreateDefinition.fn_xpathdefinitionnametxtbox()));

	Module_Definition_4_0.fn_select_domain_name_action(driver, domainname);
	fn_setwait(12000).until(
		ExpectedConditions.visibilityOfElementLocated(PG_CreateDefinition.fn_xpathdefinitionnametxtbox()));

	Module_Definition_4_0.fn_select_country_name_action(driver, countryname);
	fn_setwait(12000).until(
		ExpectedConditions.visibilityOfElementLocated(PG_CreateDefinition.fn_xpathdefinitionnametxtbox()));

	Module_Definition_4_0.fn_enter_description_action(driver, description);
	fn_setwait(12000).until(
		ExpectedConditions.visibilityOfElementLocated(PG_CreateDefinition.fn_xpathdefinitionnametxtbox()));
	Module_Definition_4_0.fn_clickcreate(driver);

    }

    @Test(priority = 2)
    public static void fn_createService() {
	fn_setwait(12000).until(ExpectedConditions.visibilityOfElementLocated((PG_CreateService.fn_servicetab())));
	fn_setwait(12000).until(ExpectedConditions.elementToBeClickable(PG_CreateService.fn_servicetab())).click();

	String servicebtn_name = Module_Services_4_0.fn_assert_create_service_button(driver);
	Assert.assertEquals(servicebtn_name, "Create Service");

	Module_Services_4_0.fn_click_create_service_button(driver);

	fn_setwait(12000).until(ExpectedConditions
		.visibilityOfElementLocated((PG_CreateService.fn_click_create_service_button(driver))));

    }

    @AfterTest
    public static void fn_quitBrowser() throws Exception {
	driver.quit();
    }

}
