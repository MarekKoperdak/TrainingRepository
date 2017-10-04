package sk.qats.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {
	// test_source.xlsx
	private static HSSFWorkbook workbook;
	private static HSSFSheet sheet;
	private static HSSFRow row;
	private static HSSFCell cell;
	private static String pathToExcelFile;

	public static void openFile(String pathToFile) throws IOException {
		pathToExcelFile = pathToFile;
		FileInputStream inputStream = new FileInputStream(pathToFile);
		workbook = new HSSFWorkbook(inputStream);
		sheet = workbook.getSheetAt(0);
	}

	public static String getCell(int rowIndex, int cellnum) {
		return sheet.getRow(rowIndex).getCell(cellnum).getStringCellValue();
	}

	public static void setCell(int rowIndex, int cellnum, String value) {
		FileOutputStream fileOutput;

		try {
			// open file to output
			fileOutput = new FileOutputStream(pathToExcelFile);
			
			row = sheet.getRow(rowIndex);
			if (row.getCell(cellnum) == null) {
				cell = row.createCell(cellnum);
			}
			row.getCell(cellnum).setCellValue(value);
			workbook.write(fileOutput);
		
			fileOutput.flush();
			fileOutput.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Object[][] getAllData(String pathToFile, int numberOfRows, int numberOfColumns) throws IOException {
		String[][] array = null;

		// try {
		// pathToExcelFile = pathToFile;
		// FileInputStream inputStream = new FileInputStream(pathToFile);
		// workbook = new HSSFWorkbook(inputStream);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// sheet = workbook.getSheetAt(0);

		openFile(pathToFile);

		array = new String[numberOfRows][numberOfColumns];

		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				array[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
				System.out.println(array[i][j]);
			}
		}

		return array;
	}
}
