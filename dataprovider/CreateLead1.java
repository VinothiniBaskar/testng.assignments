package testcase.dataprovider;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead1 extends BaseClass1 {
	
	@DataProvider(name="create")
	public String[][] fetchDataForcreate() {
		String[][] data=new String[2][4];
		
		data[0][0]="Elpis";
		data[0][1]="Vino";
		data[0][2]="baskar";
		data[0][3]="86";
		
		data[1][0]="TCS";
		data[1][1]="vasu";
		data[1][2]="A";
		data[1][3]="87";
		
		
		
		return data;

	}

	@Test(dataProvider="create")
	public void createLead(String companyName,String firstName,String lastName,String phoneNumber) {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
		driver.findElement(By.name("submitButton")).click();

	}

}
 
