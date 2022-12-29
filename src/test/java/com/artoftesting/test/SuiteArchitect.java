package com.artoftesting.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.artoftesting.pages.PG_CreateDefinition;
import com.artoftesting.pages.PG_CreateService;
import com.artoftesting.pages.PG_Login;
import com.artoftesting.util.DefinitionStorage;
import com.artoftesting.util.ReadData;
import com.artoftesting.util.ServiceStorage;
import com.artoftesting.webdriverwait.Hibernate;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuiteArchitect {

    public static WebDriver driver;

    @BeforeClass
    public static void instantiate() {
	WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public static void fn_initializechrome() throws Exception {

	driver = new ChromeDriver();
	System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
	driver.manage().window().maximize();

	DefinitionStorage.fn_createheader();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9000));

	int dfcount = 3;
	DefinitionStorage.fn_write(dfcount);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9000));

	ServiceStorage.fn_createheader();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9000));

	int servicecount = 2;
	ServiceStorage.fn_write(servicecount, "Windows service", "1", "JBossEAP",
		"http://192.168.152.190:8080/oxejbintegrator/rest/api/execute", "8080", "saurabh_12may", "ipsfrs",
		"system123#", "iPS_Registration", "Kadmos");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

    }

    @DataProvider(name = "login-test-data")
    public static Object[][] fn_TestDataFeed() {

	ReadData.fn_initialize("./src/test/resources/LoginTestData/DataProvider.xlsx");

	int rows = ReadData.fn_getrowcount(0);
	int cells = ReadData.fn_getcellcount(0);

	String[][] credentials = new String[rows - 2][cells];

	for (int i = 0; i < rows - 2; i++) {
	    for (int j = 0; j < cells; j++) {
		credentials[i][j] = ReadData.fn_getdata(0, i + 2, j);
	    }
	}
	return credentials;
    }

    @Test(priority = 0)
    public static void fn_Login() throws Exception {

	driver.get("http://192.168.156.212:9102/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12000));
	driver.findElement(PG_Login.fn_idusername()).sendKeys("supervisor");
	driver.findElement(PG_Login.fn_idpassword()).sendKeys("supervisor351");
	Hibernate.fn_setwait("elementToBeClickable", 3000, driver, PG_Login.fn_xpathloginbutton());

	Hibernate.fn_setwait("elementToBeClickable", 5000, driver, PG_CreateDefinition.fn_definitiontab());
	Hibernate.fn_setwait("visibilityOfElementLocated", 5000, driver,
		PG_CreateDefinition.fn_xpathcreatedefinitionbutton());

    }

    @DataProvider(name = "definition_names")
    public static Object[][] fn_TestDefinitionFeed() {
	ReadData.fn_initialize(DefinitionStorage.def_path);

	int rows = ReadData.fn_getrowcount(0);
	int cells = ReadData.fn_getcellcount(0);

	System.out.println("DEFINITION ROWS COUNT  :" + rows);
	System.out.println("DEFINITION CELL COUNT  :" + cells);

	String[][] credentials = new String[rows - 1][cells];

	for (int i = 0; i < rows - 1; i++) {
	    for (int j = 0; j < cells; j++) {
		credentials[i][j] = ReadData.fn_getdata(0, i + 1, j);
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

	String ppoupDefinition = Module_Definition_4_0.fn_module_definition_title_assert(driver);
	Assert.assertTrue(ppoupDefinition.compareTo("OmniXtract - Definition") == 0);

	Module_Definition_4_0.fn_click_show_list(driver);
	Hibernate.fn_setwait("visibilityOfElementLocated", 12000, driver, PG_CreateDefinition.fn_clickShowList());

	Module_Definition_4_0.fn_select_table_data(driver);
	Hibernate.fn_setwait("visibilityOfElementLocated", 12000, driver,
		PG_CreateDefinition.fn_selectDefinitionList());

	Module_Definition_4_0.fn_enter_definition_name_action(driver, defname);
	Hibernate.fn_setwait("visibilityOfElementLocated", 12000, driver,
		PG_CreateDefinition.fn_xpathdefinitionnametxtbox());

	Module_Definition_4_0.fn_select_domain_name_action(driver, domainname);
	Hibernate.fn_setwait("visibilityOfElementLocated", 12000, driver,
		PG_CreateDefinition.fn_xpathdomainnameDropdown());

	Module_Definition_4_0.fn_select_country_name_action(driver, countryname);
	Hibernate.fn_setwait("visibilityOfElementLocated", 12000, driver,
		PG_CreateDefinition.fn_xpathcountrynameDropdown());

	Module_Definition_4_0.fn_enter_description_action(driver, description);
	Hibernate.fn_setwait("visibilityOfElementLocated", 12000, driver, PG_CreateDefinition.fn_clickcreateButton());

	Module_Definition_4_0.fn_clickcreate(driver);

    }

    @DataProvider(name = "service_creation_data")
    public static Object[][] fn_testServiceFeed() {
	ReadData.fn_initialize(ServiceStorage.servicefilewrite);

	int rows = ReadData.fn_getrowcount(0);
	int cells = ReadData.fn_getcellcount(0);

	System.out.println("SERVICE ROWS COUNT  : " + rows);
	System.out.println("SERVICE CELL COUNT  : " + cells);

	String[][] servicefetcher = new String[rows - 1][cells];

	for (int i = 0; i < rows - 1; i++) {
	    for (int j = 0; j < cells; j++) {
		servicefetcher[i][j] = ReadData.fn_getdata(0, i + 1, j);
	    }
	}
	return servicefetcher;

    }

    @Test(priority = 2, dataProvider = "service_creation_data")
    public static void fn_createService(String servicename, String servicetype, int sleep, String appservertype,
	    String appserverurl, String appserverport, String cabinetname, String username, String password,
	    String queuename, String engine) throws Exception {

	Hibernate.fn_setwait("visibilityOfElementLocated", 12000, driver, PG_CreateService.fn_servicetab());
	Hibernate.fn_setwait("elementToBeClickable", 12000, driver, PG_CreateService.fn_servicetab());

	String servicebtn_name = Module_Services_4_0.fn_assert_create_service_button(driver);
	Assert.assertEquals(servicebtn_name, "Create Service");

	Module_Services_4_0.fn_click_create_service_button(driver);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_enterservicename());

	Module_Services_4_0.fn_enter_service_name(driver, servicename);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_selectappservertype());

	Module_Services_4_0.fn_select_service_type(driver, servicetype);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_entersleepinterval());

	Module_Services_4_0.fn_enter_sleep_interval(driver, sleep);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_selectappserver());

	Module_Services_4_0.fn_select_app_server_type(driver, appservertype);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_inputappserverblock());

	Module_Services_4_0.fn_appserverurl(driver, appserverurl);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_appserverportblock());

	Module_Services_4_0.fn_appserverport(driver, appserverport);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_cabinetnameblock());

	Module_Services_4_0.fn_cabinetname(driver, cabinetname);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_usernameblock());

	Module_Services_4_0.fn_username(driver, username);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_passwordblock());

	Module_Services_4_0.fn_password(driver, password);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_queue());

	Module_Services_4_0.fn_queuename(driver, queuename);
	Hibernate.fn_setwait("visibilityOfElementLocated", 2000, driver, PG_CreateService.fn_selectengine());

	Module_Services_4_0.fn_enginename(driver, engine);
    }

//    @AfterTest
//    public static void fn_quitBrowser() throws Exception {
//	driver.quit();
//    }

}
