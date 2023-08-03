package newCar.HPNR;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amt.CustomerQuotePackage.CustomerQuotePage_HPNR_BCHPage;
import com.amt.HoldingCostPages.HoldingCost_HPNR_BCHPage;
import com.amt.QuoteSummaryPages.QuoteSummary_HPNR_BCHPage;
import com.amt.pages.AcquisitionListingPage;
import com.amt.pages.LoginPage;
import com.amt.pages.OptionsAccessoriesPage;
import com.amt.pages.VehicleSelectionPage;
import com.amt.pages.ContractTypesAndOTRPages.ContractTypesAndOTR_HPNR_BCH_Page;
import com.amt.testBase.TestBase;
import com.amt.testUtil.ReadExcelData;

@Listeners(com.amt.testUtil.ScreenshotListener.class)
public class Acquisition_Quotes_HPNR_BCH_edit_flow_with_maintenance_Test extends TestBase {

	LoginPage obj_Login_Page;
	AcquisitionListingPage obj_acq_listing_page;
	VehicleSelectionPage obj_vehicle_selection_page;
	OptionsAccessoriesPage obj_options_accessories;
	ContractTypesAndOTR_HPNR_BCH_Page obj_contract_types_and_OTR_page;
	HoldingCost_HPNR_BCHPage obj_holding_cost_page;
	CustomerQuotePage_HPNR_BCHPage obj_customer_quote_page;
	QuoteSummary_HPNR_BCHPage obj_quote_summary_page;

	@Test(priority = 1, dataProvider = "testDataWithoutFunder")
	public void open_saved_quote_and_edit_road_tax_for_first_year(String vehicle_basic_price,
			String road_tax_for_first_year, String other_support_value, String percentage_cap_residual_value_used,
			String percentage_cap_maintenance_cost_used, String residual_value_used, String main_cost_used,
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String security_deposit, String matrix_upsell, String referrer_upsell, String add_terms, String add_mileage,
			String maintenance_required, String maintenance_margin, String payment_profile_required, String initial_payment,
			 String part_exchange_status, String target_rental,
			String quote_no_excel_sheet_name, String calculation_excel_sheet_name)
			throws InterruptedException, IOException, UnsupportedFlavorException {
		System.out.println("");
		System.out.println("");
		System.out.println("Test case 1 : Edit Road Tax");
		LO.print          ("Test case 1 : Edit Road Tax");

		obj_acq_listing_page = new AcquisitionListingPage();
		obj_contract_types_and_OTR_page = new ContractTypesAndOTR_HPNR_BCH_Page();

		obj_acq_listing_page.open_saved_quote_to_edit(quote_no_excel_sheet_name);

		System.out.println("");
		System.out.println("");

		obj_contract_types_and_OTR_page.edit_road_tax_for_first_year_on_otr_page(road_tax_for_first_year,
				calculation_excel_sheet_name);

		System.out.println("");
		System.out.println("");

	}

	@Test(priority = 2, dataProvider = "testDataWithoutFunder", dependsOnMethods = {
			"open_saved_quote_and_edit_road_tax_for_first_year" })

	public void open_quote_summary_and_verify_values_after_editing_road_tax_for_first_year(String vehicle_basic_price,
			String road_tax_for_first_year, String other_support_value, String percentage_cap_residual_value_used,
			String percentage_cap_maintenance_cost_used, String residual_value_used, String main_cost_used,
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String security_deposit, String matrix_upsell, String referrer_upsell, String add_terms, String add_mileage,
			String maintenance_required, String maintenance_margin, String payment_profile_required, String initial_payment,
			 String part_exchange_status, String target_rental,
			String quote_no_excel_sheet_name, String calculation_excel_sheet_name)
			throws InterruptedException, IOException, UnsupportedFlavorException, ClassNotFoundException {
		
		System.out.println("");
		System.out.println("");
		System.out.println("Test case 2 : Verify all values after Editing Road Tax");
		LO.print          ("Test case 2 : Verify all values after Editing Road Tax");

		obj_quote_summary_page = new QuoteSummary_HPNR_BCHPage();

		System.out.println("");
		System.out.println("");

		boolean quote_summary_OTR_calculation = obj_quote_summary_page
				.quote_summary_OTR_calculation(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_OTR_calculation);

		System.out.println("");
		System.out.println("");

		boolean quote_summary_holding_cost_calculation = obj_quote_summary_page
				.quote_summary_holding_cost_calculation_with_maintenance(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_holding_cost_calculation);

		System.out.println("");
		System.out.println("");

		boolean balance_due = obj_quote_summary_page.verify_balance_due_value(calculation_excel_sheet_name);
		Assert.assertTrue(balance_due);

		System.out.println("");
		System.out.println("");

		boolean quote_summary_customer_quote_calculation = obj_quote_summary_page
				.quote_summary_customer_quote_summary_value_verification_with_maintenance(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_customer_quote_calculation);

		System.out.println("");
		System.out.println("");

		boolean quote_summary_configuration_value_check = obj_quote_summary_page
				.quote_summary_configuration_value_verification_with_maintenance(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_configuration_value_check);

		System.out.println("");
		System.out.println("");

	}

	@Test(priority = 3, dataProvider = "testDataWithoutFunder", dependsOnMethods = {
			"open_quote_summary_and_verify_values_after_editing_road_tax_for_first_year" })
	public void open_saved_quote_and_edit_holding_cost_editable_values(String vehicle_basic_price,
			String road_tax_for_first_year, String other_support_value, String percentage_cap_residual_value_used,
			String percentage_cap_maintenance_cost_used, String residual_value_used, String main_cost_used,
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String security_deposit, String matrix_upsell, String referrer_upsell, String add_terms, String add_mileage,
			String maintenance_required, String maintenance_margin, String payment_profile_required, String initial_payment,
			 String part_exchange_status, String target_rental,
			String quote_no_excel_sheet_name, String calculation_excel_sheet_name)
			throws InterruptedException, IOException, UnsupportedFlavorException, ClassNotFoundException {
		
		System.out.println("");
		System.out.println("");
		System.out.println("Test case 3 : Edit Holding Cost Editable fileds");
		LO.print          ("Test case 3 : Edit Holding Cost Editable fileds");

		obj_holding_cost_page = new HoldingCost_HPNR_BCHPage();

		obj_holding_cost_page.open_holding_cost_page();

		boolean holding_cost_after_editing_percentage_values = obj_holding_cost_page
				.edit_percentage_residual_and_maint_cost_then_verify_holding_cost_with_maintenance(
						percentage_cap_maintenance_cost_used, residual_value_used, main_cost_used,
						percentage_cap_residual_value_used, maintenance_required, target_rental,
						calculation_excel_sheet_name);
		Assert.assertTrue(holding_cost_after_editing_percentage_values);

		boolean holding_cost_after_editing_residual_and_maint_cost = obj_holding_cost_page
				.edit_residual_value_and_maint_cost_then_verify_holding_cost_with_maintenance(
						percentage_cap_maintenance_cost_used, residual_value_used, main_cost_used,
						percentage_cap_residual_value_used, maintenance_required, target_rental,
						calculation_excel_sheet_name);
		Assert.assertTrue(holding_cost_after_editing_residual_and_maint_cost);

//		boolean holding_cost_after_editing_additional_terms_and_mileage = obj_holding_cost_page
//				.edit_additional_term_and_mileage_then_verify_holding_cost_with_maintenance(add_terms, add_mileage,
//						maintenance_required, target_rental, calculation_excel_sheet_name);
//		Assert.assertTrue(holding_cost_after_editing_additional_terms_and_mileage);
	}

	@Test(priority = 4, dataProvider = "testDataWithoutFunder", dependsOnMethods = {
			"open_saved_quote_and_edit_holding_cost_editable_values" })

	public void open_quote_summary_and_verify_values_after_editing_holding_cost_values(String vehicle_basic_price,
			String road_tax_for_first_year, String other_support_value, String percentage_cap_residual_value_used,
			String percentage_cap_maintenance_cost_used, String residual_value_used, String main_cost_used,
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String security_deposit, String matrix_upsell, String referrer_upsell, String add_terms, String add_mileage,
			String maintenance_required, String maintenance_margin, String payment_profile_required, String initial_payment,
			 String part_exchange_status, String target_rental,
			String quote_no_excel_sheet_name, String calculation_excel_sheet_name)
			throws InterruptedException, IOException, UnsupportedFlavorException, ClassNotFoundException {

		System.out.println("");
		System.out.println("");
		System.out.println("Test case 4 : Verify all values after Editing Holding Cost Editable fileds");
		LO.print          ("Test case 4 : Verify all values after Editing Holding Cost Editable fileds");
		
		obj_quote_summary_page = new QuoteSummary_HPNR_BCHPage();

		System.out.println("");
		System.out.println("");

		boolean quote_summary_OTR_calculation = obj_quote_summary_page
				.quote_summary_OTR_calculation(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_OTR_calculation);

		System.out.println("");
		System.out.println("");

		boolean quote_summary_holding_cost_calculation = obj_quote_summary_page
				.quote_summary_holding_cost_calculation_with_maintenance(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_holding_cost_calculation);

		System.out.println("");
		System.out.println("");

		boolean balance_due = obj_quote_summary_page.verify_balance_due_value(calculation_excel_sheet_name);
		Assert.assertTrue(balance_due);

		System.out.println("");
		System.out.println("");

		boolean quote_summary_customer_quote_calculation = obj_quote_summary_page
				.quote_summary_customer_quote_summary_value_verification_with_maintenance(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_customer_quote_calculation);

		System.out.println("");
		System.out.println("");

		boolean quote_summary_configuration_value_check = obj_quote_summary_page
				.quote_summary_configuration_value_verification_with_maintenance(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_configuration_value_check);

		System.out.println("");
		System.out.println("");

	}

	@Test(priority = 5, dataProvider = "testDataWithoutFunder", dependsOnMethods = {
			"open_quote_summary_and_verify_values_after_editing_holding_cost_values" })

	public void open_saved_quote_and_edit_customer_quote_editable_values(String vehicle_basic_price,
			String road_tax_for_first_year, String other_support_value, String percentage_cap_residual_value_used,
			String percentage_cap_maintenance_cost_used, String residual_value_used, String main_cost_used,
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String security_deposit, String matrix_upsell, String referrer_upsell, String add_terms, String add_mileage,
			String maintenance_required, String maintenance_margin, String payment_profile_required, String initial_payment,
			 String part_exchange_status, String target_rental,
			String quote_no_excel_sheet_name, String calculation_excel_sheet_name) throws InterruptedException,
			IOException, UnsupportedFlavorException, NumberFormatException, ClassNotFoundException {

		obj_customer_quote_page = new CustomerQuotePage_HPNR_BCHPage();

		System.out.println("");
		System.out.println("");
		
		System.out.println("Test case 5 : Edit Customer Quote Editable fileds");
		LO.print          ("Test case 5 : Edit Customer Quote Editable fileds");

		boolean cust_quote_for_one_payment_boolean_status = obj_customer_quote_page
				.change_payment_profile_option_with_maintenance_calculation(actual_part_exchange_value_from_excel,
						given_part_exchange_value_from_excel, less_finance_settlement_from_excel,
						order_deposit_from_excel, document_fee_from_excel, matrix_upsell, maintenance_required,
						maintenance_margin, payment_profile_required, initial_payment, part_exchange_status,
						target_rental, calculation_excel_sheet_name);

		Assert.assertTrue(cust_quote_for_one_payment_boolean_status);

		System.out.println("");
		System.out.println("");

		boolean cust_quote_for_upsell_values_boolean_status = obj_customer_quote_page
				.check_monthly_payments_on_adding_upsell_values_with_maintenance(security_deposit, matrix_upsell,
						referrer_upsell, add_terms, add_mileage, calculation_excel_sheet_name);

		Assert.assertTrue(cust_quote_for_upsell_values_boolean_status);

		System.out.println("");
		System.out.println("");

		boolean monthlyFinanceAndMaintenanceWithPartExchange = obj_customer_quote_page
				.check_monthly_finance_rental_with_part_exchange_with_maintenance(actual_part_exchange_value_from_excel,
						given_part_exchange_value_from_excel, less_finance_settlement_from_excel,
						order_deposit_from_excel, document_fee_from_excel, calculation_excel_sheet_name);

		Assert.assertTrue(monthlyFinanceAndMaintenanceWithPartExchange);

	}

	@Test(priority = 6, dataProvider = "testDataWithoutFunder", dependsOnMethods = {
			"open_saved_quote_and_edit_customer_quote_editable_values" })

	public void open_quote_summary_and_verify_values_after_editing_customer_quote_values(String vehicle_basic_price,
			String road_tax_for_first_year, String other_support_value, String percentage_cap_residual_value_used,
			String percentage_cap_maintenance_cost_used, String residual_value_used, String main_cost_used,
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String security_deposit, String matrix_upsell, String referrer_upsell, String add_terms, String add_mileage,
			String maintenance_required, String maintenance_margin, String payment_profile_required, String initial_payment,
			 String part_exchange_status, String target_rental,
			String quote_no_excel_sheet_name, String calculation_excel_sheet_name)
			throws InterruptedException, IOException, UnsupportedFlavorException, ClassNotFoundException {

		obj_quote_summary_page = new QuoteSummary_HPNR_BCHPage();

		System.out.println("");
		System.out.println("");
		
		System.out.println("Test case 6 : Verify all values after Editing Customer Quote Editable fileds");
		LO.print          ("Test case 6 : Verify all values after Editing Customer Quote Editable fileds");

		boolean quote_summary_OTR_calculation = obj_quote_summary_page
				.quote_summary_OTR_calculation(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_OTR_calculation);

		System.out.println("");
		System.out.println("");

		boolean quote_summary_holding_cost_calculation = obj_quote_summary_page
				.quote_summary_holding_cost_calculation_with_maintenance(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_holding_cost_calculation);

		System.out.println("");
		System.out.println("");

		boolean balance_due = obj_quote_summary_page.verify_balance_due_value(calculation_excel_sheet_name);
		Assert.assertTrue(balance_due);

		System.out.println("");
		System.out.println("");

		boolean quote_summary_customer_quote_calculation = obj_quote_summary_page
				.quote_summary_customer_quote_summary_value_verification_with_maintenance(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_customer_quote_calculation);

		System.out.println("");
		System.out.println("");

		boolean quote_summary_configuration_value_check = obj_quote_summary_page
				.quote_summary_configuration_value_verification_with_maintenance(calculation_excel_sheet_name);
		Assert.assertTrue(quote_summary_configuration_value_check);

		System.out.println("");
		System.out.println("");

	}

	@DataProvider(name = "testDataWithoutFunder")
	public Object[][] gettestDataWithoutFunder() throws IOException {
		Object[][] data = ReadExcelData.getTestData("HPNR_BCH_withMaint_Edit");
		return data;
	}

}
