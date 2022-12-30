package com.amt.test.OP;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amt.CustomerQuotePackage.CustomerQuotePage_OP_OP_Page;
import com.amt.QuoteSummaryPages.QuoteSummaryOutrightCPPage;
import com.amt.pages.AcquisitionListingPage;
import com.amt.pages.LoginPage;
import com.amt.pages.OptionsAccessoriesPage;
import com.amt.pages.VehicleSelectionPage;
import com.amt.pages.ContractTypesAndOTRPages.ContractTypesAndOTR_OP_OP_Page;
import com.amt.testBase.TestBase;
import com.amt.testUtil.ReadExcelData;

@Listeners(com.amt.testUtil.ScreenshotListener.class)
public class Acquisition_Quotes_OP_OP_Test extends TestBase {



	LoginPage obj_Login_Page;
	AcquisitionListingPage obj_acq_listing_page;
	VehicleSelectionPage obj_vehicle_selection_page;
	OptionsAccessoriesPage obj_options_accessories;
	ContractTypesAndOTR_OP_OP_Page obj_contract_types_and_OTR_page;	 
	CustomerQuotePage_OP_OP_Page obj_customer_quote_page;
	QuoteSummaryOutrightCPPage obj_quote_summary_page;


	@Test(priority = 1, dataProvider = "testData")
	public void aquisition_quotes_OP_OP_OTR_calculation_test(String manufacturer, String model, 
			String Vehicle_Basic_price, String  road_tax_for_first_year, String percentage_cap_residual_value, String percentage_cap_maint_value,
			String residual_value_used, String maint_cost_used, String target_rental, String additional_terms, String additional_mileage,
			String vehicle_profit ,String  maintenance_status,String matrix_credit_type, String security_deposit, 
			String balloon_payment_status, String part_exchange_actual, String part_exchange_given, String less_finance_settlement,
			String  order_deposit, String finance_deposit, String document_fee, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		obj_acq_listing_page = new AcquisitionListingPage();
		obj_vehicle_selection_page = new VehicleSelectionPage();
		obj_options_accessories = new OptionsAccessoriesPage();
		obj_contract_types_and_OTR_page = new ContractTypesAndOTR_OP_OP_Page();
		

		obj_acq_listing_page.aquisition_Listingpage_AddnewQuote();
		obj_vehicle_selection_page.select_vehicle(manufacturer, model);
		obj_options_accessories.options_And_Accessories_selection();
		boolean subtotal_after_discount = obj_contract_types_and_OTR_page
				.contractTypes_and_OTR_selection_OP_OP_Ownbook_calculation(sheet_name);
		Assert.assertTrue(subtotal_after_discount);

	}
	
	@Test(priority=2, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_OP_OP_OTR_calculation_test" })

	public void aquisition_quotes_OP_OP_after_discount_calculations_test(String manufacturer, String model, 
			String Vehicle_Basic_price, String  road_tax_for_first_year, String percentage_cap_residual_value, String percentage_cap_maint_value,
			String residual_value_used, String maint_cost_used, String target_rental, String additional_terms, String additional_mileage,
			String vehicle_profit ,String  maintenance_status,String matrix_credit_type, String security_deposit, 
			String balloon_payment_status, String part_exchange_actual, String part_exchange_given, String less_finance_settlement,
			String  order_deposit, String finance_deposit, String document_fee, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		obj_contract_types_and_OTR_page = new ContractTypesAndOTR_OP_OP_Page();

		boolean otr_price_check = obj_contract_types_and_OTR_page
				.verify_after_discount_calculations_contract_types_page(sheet_name);
		Assert.assertTrue(otr_price_check);


	}
	
	
	
	@Test(priority=5, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_OP_OP_after_discount_calculations_test" })

	public void aquisition_quotes_OP_OP_customer_quote_vehicle_profit_edit_check_with_maintenance_test(String manufacturer, String model, 
			String Vehicle_Basic_price, String  road_tax_for_first_year, String percentage_cap_residual_value, String percentage_cap_maint_value,
			String residual_value_used, String maint_cost_used, String target_rental, String additional_terms, String additional_mileage,
			String vehicle_profit ,String  maintenance_status,String matrix_credit_type, String security_deposit, 
			String balloon_payment_status, String part_exchange_actual, String part_exchange_given, String less_finance_settlement,
			String  order_deposit, String finance_deposit, String document_fee, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {


		obj_customer_quote_page = new CustomerQuotePage_OP_OP_Page();
		
		boolean monthly_total_payment_after_editing_vehicle_profit =obj_customer_quote_page.edit_vehicle_profit_and_check_monthly_total_payment(vehicle_profit, sheet_name);
		Assert.assertTrue(monthly_total_payment_after_editing_vehicle_profit);

	}
	
	@Test(priority=6, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_OP_OP_customer_quote_vehicle_profit_edit_check_with_maintenance_test" })

	public void aquisition_quotes_OP_OP_customer_quote_part_exchange_value_edit_check_with_maintenance_test(String manufacturer, String model, 
			String Vehicle_Basic_price, String  road_tax_for_first_year, String percentage_cap_residual_value, String percentage_cap_maint_value,
			String residual_value_used, String maint_cost_used, String target_rental, String additional_terms, String additional_mileage,
			String vehicle_profit ,String  maintenance_status,String matrix_credit_type, String security_deposit, 
			String balloon_payment_status, String part_exchange_actual, String part_exchange_given, String less_finance_settlement,
			String  order_deposit, String finance_deposit, String document_fee, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {


		obj_customer_quote_page = new CustomerQuotePage_OP_OP_Page();
		
		
		boolean monthlyTotalandBalanceToFinanceCheck = obj_customer_quote_page.put_part_exchange_values_and_check_monthly_total_payment(part_exchange_actual, part_exchange_given, less_finance_settlement, order_deposit, finance_deposit, sheet_name);
	Assert.assertTrue(monthlyTotalandBalanceToFinanceCheck);

	}
	
	
//	@Test(priority=7, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_OP_OP_customer_quote_part_exchange_value_edit_check_with_maintenance_test" })
//
//	public void aquisition_quotes_OP_OP_quote_summary_values_verification_with_maintenance_test(String manufacturer, String model, 
//			String Vehicle_Basic_price, String  road_tax_for_first_year, String percentage_cap_residual_value, String percentage_cap_maint_value,
//			String residual_value_used, String maint_cost_used, String target_rental, String additional_terms, String additional_mileage,
//			String vehicle_profit ,String  maintenance_status,String matrix_credit_type, String security_deposit, 
//			String balloon_payment_status, String part_exchange_actual, String part_exchange_given, String less_finance_settlement,
//			String  order_deposit, String finance_deposit, String document_fee, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {
//
//
//		obj_quote_summary_page = new QuoteSummaryOutrightCPPage();
//		
//		boolean quote_summary_value_check =obj_quote_summary_page.quote_summary_OP_OP_with_maintenance(sheet_name);		
//        
//		Assert.assertTrue(quote_summary_value_check);       
//	}
	
	

	@DataProvider(name = "testData")
	public Object[][] getTestData() throws IOException {
		Object[][] data = ReadExcelData.getTestData("OutrightCPwithMaintenance");
		return data;
	}

}
