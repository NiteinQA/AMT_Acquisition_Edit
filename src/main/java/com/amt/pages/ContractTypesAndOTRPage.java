package com.amt.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.CommonClass;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.JavaScriptExecutor;

public class ContractTypesAndOTRPage extends TestBase {

	CommonClass obj_common_class;
	
	ContractTypesAndOTRPage obj_OTR_page;
	
	JavaScriptExecutor obj_jse;
	
		
		@FindBy(xpath = "//img[@alt='Loading...']")
		private List<WebElement> loading_icon;			
		
		@FindBy(xpath = "//*[normalize-space()='Click here']")
		private WebElement refresh_link;
		
		@FindBy(xpath = "//*[@id ='acqOTRHeader']")
		private WebElement acq_contractTypes;
		
		@FindBy(xpath = "//*[@id='roadTaxFirstYear']")
		private WebElement road_tax_first_year_input;
		
		@FindBy(xpath = "//*[normalize-space()='First registration fee']//ancestor::div[1]//div[2]")
		private WebElement first_registration_fee;
			
		public ContractTypesAndOTRPage() {
			PageFactory.initElements(driver, this);			
		}
		
		
		public void verify_refresh_link_is_working(String quote_no) throws InterruptedException, IOException {
			
			obj_OTR_page = new ContractTypesAndOTRPage();
			
			boolean refresh_link_exists = obj_OTR_page.check_refresh_link_available(quote_no);
			
			if(refresh_link_exists==true) {
				
				obj_jse = new JavaScriptExecutor();
				
				String road_tax_for_first_year_before_refreshing = obj_jse.get_value_of_frozen_input_field(driver, road_tax_first_year_input);
				
				System.out.println("Road Tax For First Year Before Refreshing is "+road_tax_for_first_year_before_refreshing);
				LO.print          ("Road Tax For First Year Before Refreshing is "+road_tax_for_first_year_before_refreshing);

				ExplicitWait.visibleElement(driver, first_registration_fee, 30);
				
				String first_reg_fee_before_refreshing = first_registration_fee.getText().trim().substring(2);
			
				System.out.println("First Registration Fee Before Refreshing is "+first_reg_fee_before_refreshing);
				LO.print          ("First Registration Fee Before Refreshing is "+first_reg_fee_before_refreshing);

				
				Click.on(driver, refresh_link, 30);
				
				ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
								
				String road_tax_for_first_year_after_refreshing = obj_jse.get_value_of_frozen_input_field(driver, road_tax_first_year_input);

				System.out.println("Road Tax For First Year After Refreshing is "+road_tax_for_first_year_after_refreshing);
				LO.print          ("Road Tax For First Year After  Refreshing is "+road_tax_for_first_year_after_refreshing);
			
				
				String first_reg_fee_after_refreshing = first_registration_fee.getText().trim().substring(2);
				
				System.out.println("First Registration Fee After Refreshing is "+first_reg_fee_after_refreshing);
				LO.print          ("First Registration Fee After Refreshing is "+first_reg_fee_after_refreshing);
				
				
				
				if(first_reg_fee_before_refreshing.equals(first_reg_fee_after_refreshing)||road_tax_for_first_year_before_refreshing.equals(road_tax_for_first_year_after_refreshing))
				{
					ExplicitWait.visibleElement(driver, acq_contractTypes, 30);
					
					System.err.println("Refresh Link was not worked on "+acq_contractTypes.getText()+" page for quote no "+quote_no);
					LO.print          ("Refresh Link was not worked on "+acq_contractTypes.getText()+" page for quote no "+quote_no);
					
					obj_common_class = new CommonClass();
					
					obj_common_class.write_quote_no_and_error_message_to_excel_sheet(quote_no, 1);	
			
				}
		
			}
			
			
		}
		
		
		public boolean check_refresh_link_available(String quote_no) throws InterruptedException {
			
			obj_OTR_page = new ContractTypesAndOTRPage();
			
			obj_OTR_page.open_OTR_page();
			
			obj_common_class = new CommonClass();
			
			return obj_common_class.check_refresh_link_available(refresh_link, acq_contractTypes, quote_no);			
			
		}
		
		public void open_OTR_page() throws InterruptedException {		
			
			
			Click.on(driver, acq_contractTypes, 30);
			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);	
			
			System.out.println("");
			LO.print          ("");
			
			System.out.println("OTR page is opened");
			LO.print          ("OTR page is opened");
	
			
			
		}
		
		
	
	

}
