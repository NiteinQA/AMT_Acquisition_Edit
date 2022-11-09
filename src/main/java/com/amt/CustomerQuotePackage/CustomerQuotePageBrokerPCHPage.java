package com.amt.CustomerQuotePackage;

import java.sql.Date;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.Dropdown;
import com.amt.testUtil.ExplicitWait;

public class CustomerQuotePageBrokerPCHPage extends TestBase {

	@FindBy(xpath = "//p[normalize-space()='Customer Quote']")
	private WebElement customer_quote;

	@FindBy(xpath = "//*[@class='ng-select-container']//*[@class='ng-arrow-wrapper']")
	private WebElement customer_quote_funder;

	@FindBy(xpath = "//input[@id='quoteReferenceNo']")
	private WebElement quote_reference;

	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	private WebElement expiry_date;

	@FindBy(xpath = "//select[@name='acquisitionPaymentProfileId']")
	private WebElement payment_profile_dropdown;

	@FindBy(xpath = "//input[@id='duration']")
	private WebElement term_period;

	@FindBy(xpath = "//input[@id='funderItemMileage']")
	private WebElement miles_per_annum;

	@FindBy(xpath = "//input[@id='contractMileage']")
	private WebElement contract_miles;
	
	@FindBy(xpath = "//*[@name='initialFinanceRental']")
	private WebElement initial_finance_rental;
	
	@FindBy(xpath = "//input[@id='initialMaintenanceRental']")
	private WebElement initial_maintenance_rental;
	
	@FindBy(xpath = "//input[@id='monthlyFinanceRental']")
	private WebElement monthly_finance_rental;
	
	@FindBy(xpath = "//input[@id='monthlyMaintenanceRental']")
	private WebElement monthly_maintenance_rental;

	@FindBy(xpath = "//input[@id='pencePerExcessMileageFinance']")
	private WebElement pence_Per_ExcessMileage_Finance;

	@FindBy(xpath = "//input[@id='pencePerExcessMileageMaintenance']")
	private WebElement pence_Per_ExcessMileage_maintenance;
	
	
	@FindBy(xpath = "//input[@id='commission']")
	private WebElement commission;

	@FindBy(xpath = "//i[@class='btn-icon-addAddress-white']")
	private WebElement add;
	
	@FindBy(xpath = "//i[@class='btn-icon-reset-black']")
	private WebElement reset;
	

	@FindBy(xpath = "//div[@class='row acquisition-menu']//div[3]//button[1]")
	private WebElement save_button;
	
	@FindBy(xpath = "//span[@class='slider round']")
	private WebElement maintenance_toggle_button;
	 



	public CustomerQuotePageBrokerPCHPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean customer_Quote_broker_pch_with_maintenance( String quoteRef, String quoteExpiryDate, String term, String milesperannum, 
			String initialFinanceRental,String initialMaintenanceRental, String monthlyFinanceRental,String monthlyMaintenanceRental,
			String pensePerExcessMileFinance,String pensePerExcessMileMaintenance, String commission2)
			throws InterruptedException {

		Click.on(driver, customer_quote, 25);

		Thread.sleep(8000);
		
		Select sl = new Select(payment_profile_dropdown);
		
		List<WebElement> list =sl.getOptions();
		
		int dropdown_lenth=list.size();
		
		System.out.println("dropdown_lenth"+dropdown_lenth);
		
		int count=0;
		
		for(int i=1; i<=dropdown_lenth-1; i++) {
			
//		if(maintenance_toggle_button.isSelected()) {}
//		else {Click.on(driver, maintenance_toggle_button, 20);}
		
		System.out.println(i+" "+list.get(i).getText());	
			
	    Click.on(driver, maintenance_toggle_button, 20);

		Click.on(driver, customer_quote_funder, 60);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();

		//LO.print("Customer quote option has been selected");
		
		Click.sendKeys(driver, quote_reference, quoteRef, 60);

		Click.sendKeys(driver, expiry_date, quoteExpiryDate, 60);

		Dropdown.select(driver, payment_profile_dropdown, i , 60);
				
		int term_converted=Integer.parseInt(term);

		Click.sendKeysint(driver, term_period, (term_converted+i), 60);

		Click.sendKeys(driver, miles_per_annum, milesperannum, 60);

		Click.on(driver, contract_miles, 60);
		
		if(i==2) {Click.sendKeys(driver, initial_finance_rental , initialFinanceRental , 60);
		          Click.sendKeys(driver, initial_maintenance_rental , initialMaintenanceRental , 60);
                 }

		Click.sendKeys(driver, monthly_finance_rental, monthlyFinanceRental, 60);
 
		Click.sendKeys(driver, monthly_maintenance_rental, monthlyMaintenanceRental, 60);
		
		Click.sendKeys(driver, pence_Per_ExcessMileage_Finance, pensePerExcessMileFinance, 60);

		Click.sendKeys(driver, pence_Per_ExcessMileage_maintenance, pensePerExcessMileMaintenance , 60);
		
		Click.sendKeys(driver, commission, commission2, 60);

		Click.on(driver, add, 60);
		
		Thread.sleep(5000);
		
		count++;
		}
		
		System.out.println("Funder quote added successfully");
		LO.print("Funder quote added successfully");
	 
		boolean flag=false;
		if(count==(dropdown_lenth-1) && save_button.isEnabled() )
		{
			flag=true;	
		}
		return flag;
	}
	
	
	
	public boolean customer_Quote_broker_pch_without_maintenance( String quoteRef, String quoteExpiryDate, String term, String milesperannum, 
			String initialFinanceRental, String monthlyFinanceRental,
			String pensePerExcessMileFinance,String commission2)
			throws InterruptedException {

		Click.on(driver, customer_quote, 25);

		Thread.sleep(8000);
		
		Select sl = new Select(payment_profile_dropdown);
		
		List<WebElement> list =sl.getOptions();
		
		int dropdown_lenth=list.size();
		
		int count=0;
		
		for(int i=1; i<=dropdown_lenth-1; i++) {
			
		String dropdown_option=list.get(i).getText();	

		Click.on(driver, customer_quote_funder, 60);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();

		//LO.print("Customer quote option has been selected");
		
		Click.sendKeys(driver, quote_reference, quoteRef, 60);

		Click.sendKeys(driver, expiry_date, quoteExpiryDate, 60);

		Dropdown.select(driver, payment_profile_dropdown, i , 60);
				
		int term_converted=Integer.parseInt(term);

		Click.sendKeysint(driver, term_period, (term_converted+i), 60);

		Click.sendKeys(driver, miles_per_annum, milesperannum, 60);

		Click.on(driver, contract_miles, 60);
		
		if(i==2) {Click.sendKeys(driver, initial_finance_rental , initialFinanceRental , 60);}

		Click.sendKeys(driver, monthly_finance_rental, monthlyFinanceRental, 60);

		Click.sendKeys(driver, pence_Per_ExcessMileage_Finance, pensePerExcessMileFinance, 60);

		Click.sendKeys(driver, commission, commission2, 60);

		Click.on(driver, add, 60);
		
		Thread.sleep(3000);
		count++;
		}
		
		System.out.println("Funder quote added successfully");
		LO.print("Funder quote added successfully");
	 
		boolean flag=false;
		if(count==(dropdown_lenth-1) && save_button.isEnabled() )
		{
			flag=true;	
		}
		return flag;
	}

}
		



