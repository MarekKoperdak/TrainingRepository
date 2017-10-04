package sk.qats.distributed;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sk.qats.util.ExcelUtil;

public class ExcelDrivenTest {

	static final Logger LOG = LoggerFactory.getLogger(ExcelDrivenTest.class);

	@Test(description = "test of excel util features")
	public void testExcelFeatures() throws IOException, InterruptedException {
		String excelPath = "datadriven\\test_source.xls";

		ExcelUtil.openFile(excelPath);
		// row 0 - header
		LOG.info(ExcelUtil.getCell(0, 0));
		LOG.info(ExcelUtil.getCell(0, 1));
		// row 1
		LOG.info(ExcelUtil.getCell(1, 0));
		LOG.info(ExcelUtil.getCell(1, 1));

		// -------------------------------------

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// row 1
		ExcelUtil.setCell(1, 2, dateFormat.format(new Date()).toString());
		Thread.sleep(1000);
		// row 2
		ExcelUtil.setCell(2, 2, dateFormat.format(new Date()).toString());
	}

	@DataProvider(name = "excelDataProvider")
	public Object[][] excelDataProvider() throws IOException {
		String excelPath = "datadriven\\test_source.xls";
		return ExcelUtil.getAllData(excelPath, 4, 2);
	}

	@Test(dataProvider = "excelDataProvider", description = "test of data provide using excel")
	public void excelDrivenTest(String login, String pswd) throws IOException {
		LOG.info("Username: " + login);
		LOG.info("Pswd: " + pswd);

	}

}
