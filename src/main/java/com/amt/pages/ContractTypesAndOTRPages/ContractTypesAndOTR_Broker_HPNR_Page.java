package com.amt.pages.ContractTypesAndOTRPages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.Difference;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.ReadExcelCalculation;
import com.amt.testUtil.RemoveComma;

public class ContractTypesAndOTR_Broker_HPNR_Page extends TestBase {
	
	ReadExcelCalculation obj_read_excel_calculation_page;
	
	@FindBy(xpath = "//*[@id ='acqOTRHeader']")
	private WebElement acq_contractTypes;
	
	@FindBy(xpath = "//p[contains(text(),'Broker')]")
	private WebElement acq_contractTypes_option_broker;
	
	@FindBy(xpath = "//body/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-aquisition-otr[1]/div[7]/div[1]/div[1]/div[3]/div[1]/button[1]")
	private WebElement quote_alert;	
	
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-aquisition-otr[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/app-acquisition-common-otr-calculations[1]/form[1]/div[1]/div[1]/div[2]")
	private WebElement acq_contractTypes_calculation_table_basic_price;

	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-aquisition-otr[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/app-acquisition-common-otr-calculations[1]/form[1]/div[1]/div[1]/div[3]")
	private WebElement acq_contractTypes_calculation_table_discount;

	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-aquisition-otr[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/app-acquisition-common-otr-calculations[1]/form[1]/div[1]/div[1]/div[4]")
	private WebElement acq_contractTypes_calculation_table_additional_discount;
	
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-aquisition-otr[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/app-acquisition-common-otr-calculations[1]/form[1]/div[2]/div[1]/div[1]/div[2]")
	private WebElement acq_contractTypes_subtotal_after_discounts;
	
	@FindBy(xpath = "//*[@id='otrBlock']/div[6]/div/p")
	private WebElement acq_contractTypes_road_tax_first_year;
	
	@FindBy(xpath = "//*[@id='roadTaxFirstYear']")
	private WebElement acq_contractTypes_road_tax_first_year_input;

	@FindBy(xpath = "//*[@id=\"collapseTwo\"]/app-acquisition-common-otr-calculations/form/div[2]/div/div[2]/div[2]")
	private WebElement acq_contractTypes_manufacturer_delivery_charges;

	@FindBy(xpath = "//*[@id=\"collapseTwo\"]/app-acquisition-common-otr-calculations/form/div[2]/div/div[5]/div[2]")
	private WebElement acq_contractTypes_first_registration_fee;

	@FindBy(xpath = "//*[@id=\"collapseTwo\"]/app-acquisition-common-otr-calculations/form/div[2]/div/div[7]/div/div[2]")
	private WebElement acq_contractTypes_rebate;
	
	@FindBy(xpath = "(//*[contains(text(),' Hire Purchase Non-Regulated')])[2]")
	private WebElement acq_contractTypes_customer_contract_HPNR;
   
	@FindBy(xpath = "//p[@class='text-left text-muted pr-1']")
	private WebElement acq_contractTypes_OTR_price;
	  
	@FindBy(xpath = "//*[@id=\"ListingPriceNew\"]")
	private WebElement acq_contractTypes_table_calculation_basic_vehicle_price;
	
	@FindBy(xpath = "//*[@id=\"collapseTwo\"]/app-acquisition-common-otr-calculations/form/div[1]/div/div[2]/div[3]")
	private WebElement acq_contractTypes_table_calculation_basic_paint_price;
	
	@FindBy(xpath = "//*[@id=\"collapseTwo\"]/app-acquisition-common-otr-calculations/form/div[1]/div/div[2]/div[4]")
	private WebElement acq_contractTypes_table_calculation_basic_options_price;
	
		
	
	public ContractTypesAndOTR_Broker_HPNR_Page() {
		PageFactory.initElements(driver, this);
	}

	
	
	
	public boolean contractTypes_and_OTR_selection_broker_hpnr(String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		Click.on(driver, acq_contractTypes, 40);
		
		Thread.sleep(2000);

	   Click.on(driver, acq_contractTypes_option_broker, 50);
	   
	   Thread.sleep(5000);
	   
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).build().perform();
	    
	    Click.on(driver, acq_contractTypes_customer_contract_HPNR , 50);
	   
	   LO.print("Contract type option has been selected");
	   
	   ExplicitWait.visibleElement(driver, acq_contractTypes_table_calculation_basic_vehicle_price, 30);
	   acq_contractTypes_table_calculation_basic_vehicle_price.click();
       
	   acq_contractTypes_table_calculation_basic_vehicle_price.sendKeys(Keys.chord(Keys.CONTROL, "a", "c"));

       Clipboard clipboard =Toolkit.getDefaultToolkit().getSystemClipboard();
       String vehicle_price_copied =(String) clipboard.getData(DataFlavor.stringFlavor);      
           
       
	   obj_read_excel_calculation_page =new ReadExcelCalculation();
	   
	   double subtotal_after_discount_excel= obj_read_excel_calculation_page.verify_table_calculations_contract_types_page(driver, vehicle_price_copied, acq_contractTypes_table_calculation_basic_paint_price,acq_contractTypes_table_calculation_basic_options_price, acq_contractTypes_calculation_table_discount, acq_contractTypes_calculation_table_additional_discount, sheet_name);   String subtotal_after_discount_actual = acq_contractTypes_subtotal_after_discounts.getText();
		
		LO.print("Subtotal after discount actual value from screen ="+subtotal_after_discount_actual);		 
		System.out.println("Subtotal after discount actual value from screen ="+subtotal_after_discount_actual);
		
		 
		String str = subtotal_after_discount_actual.substring(2);
		 
		String subtotal_after_discount_actual_converted=RemoveComma.of(str);
       
		
		double subtotal_after_discount_actual_from_screen=Double.parseDouble(subtotal_after_discount_actual_converted);
		boolean flag=false;
		double diff=Difference.of_two_Double_Values(subtotal_after_discount_excel, subtotal_after_discount_actual_from_screen);
		if(diff<0.2)
         {
	       flag =true;
         }

		return flag;
		
	}
	
	public boolean verify_after_discount_calculations_contract_types_page(String sheet_name) throws IOException {
		
		obj_read_excel_calculation_page =new ReadExcelCalculation();		
		return obj_read_excel_calculation_page.verify_after_discount_calculations_contract_types_page(driver, 
				acq_contractTypes_calculation_table_basic_price, 
				acq_contractTypes_calculation_table_discount,
				acq_contractTypes_calculation_table_additional_discount, 
				acq_contractTypes_manufacturer_delivery_charges, 
				acq_contractTypes_road_tax_first_year,
				acq_contractTypes_first_registration_fee,
				acq_contractTypes_rebate, acq_contractTypes_OTR_price, 
				sheet_name);		
	}
	

}