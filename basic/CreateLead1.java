package testcase.basic;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

//extends the baseclass in child class(CreateLead)
public class CreateLead1 extends BaseClassBasic1 {
	
	//It donetes it is test case to run
	@Test
	public void createLead() {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TVS");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vino");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("B");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("86");
		driver.findElement(By.name("submitButton")).click();

	}

}
 
