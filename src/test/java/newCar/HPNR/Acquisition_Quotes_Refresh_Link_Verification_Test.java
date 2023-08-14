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
import com.amt.pages.ContractTypesAndOTRPage;
import com.amt.pages.LoginPage;
import com.amt.pages.OptionsAccessoriesPage;
import com.amt.pages.VehicleSelectionPage;
import com.amt.pages.ContractTypesAndOTRPages.ContractTypesAndOTR_HPNR_BCH_Page;
import com.amt.testBase.TestBase;
import com.amt.testUtil.ReadExcelData;

@Listeners(com.amt.testUtil.ScreenshotListener.class)
public class Acquisition_Quotes_Refresh_Link_Verification_Test extends TestBase {

	 
	AcquisitionListingPage obj_acq_listing_page;
	
	ContractTypesAndOTRPage obj_OTR_page;

	ContractTypesAndOTR_HPNR_BCH_Page obj_contract_types_and_OTR_page;


	@Test(priority = 1, dataProvider = "testData")
	public void verify_refresh_link_on_OTR_page(String Quote_Ref_no)
			throws InterruptedException, IOException, UnsupportedFlavorException {
		obj_acq_listing_page = new AcquisitionListingPage();
		obj_acq_listing_page.open_saved_quote_to_verify_refresh_link(Quote_Ref_no);
		
		obj_OTR_page = new ContractTypesAndOTRPage();
		
		obj_OTR_page.verify_refresh_link_is_working(Quote_Ref_no);
		
	}
	
	


	@DataProvider(name = "testData")
	public Object[][] gettestDataWithoutFunder() throws IOException {
		Object[][] data = ReadExcelData.getTestData("RefreshLinkQuotes");
		return data;
	}

}
