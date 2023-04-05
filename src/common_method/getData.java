package common_method;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import java .util.ArrayList;
public class getData {
	public static ArrayList<String> getDataExcel(String testSheetName,String testCaseName) throws IOException
	{
		ArrayList<String> arrayData=new ArrayList<String>();
		//step 1: Locate excel data file by creating the object of FileInputStream 
		FileInputStream fis = new FileInputStream("D:\\Restassured\\test_data.xlsx");
		
		//step 2:create the object of XSSFWorkbook to open the  excel file
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		//step 3:Go to the designated sheet or Access the desired sheet ..
		//step 3.1:Fetch   the count of sheet available in the  excel file
		
		int countOfSheet = workbook.getNumberOfSheets();
		
		//step 3.2 :Fetch the name of sheet and compare against desired sheet name
		for(int i =0;i< countOfSheet;i++)
		{
			String sheetname = workbook.getSheetName(i);
			//System.out.println(sheetname);
			if (sheetname.equalsIgnoreCase(testSheetName))
			{
				//System.out.println(testSheetName);
				//step 4: Access the sheet and iterate through rows to fetch the common in which testcasename
				XSSFSheet sheet= workbook.getSheetAt(i);
				//sheet is a variable of XSSFSheet  type
				//Step 4.1: create iterator for rows
				Iterator<Row> Rows=sheet.iterator();
				Row firstRow=Rows.next();
				
			    //step 4.2 create iterator for cells
				Iterator<Cell> Cells=firstRow.cellIterator();
				
				//to read every single value of cells
				int j=0;
				int tc_column=0;
				
				//step14.3   read the cell values of row number1 to compare against the test case name
				
				while(Cells.hasNext())
				{
					  Cell CellValue=Cells.next();
					  if (CellValue.getStringCellValue().equalsIgnoreCase("tc_name"))
					  {
						  tc_column=j;
						  
					  }
					  j++;
					  
				}
				//step5: fetch the data for deginated testcase
				
				while (Rows.hasNext())
				{
					Row DataRow=Rows.next();
					if (DataRow.getCell(tc_column).getStringCellValue().equalsIgnoreCase(testCaseName))
					{
						Iterator<Cell> DataCellValue=DataRow.cellIterator();
						while (DataCellValue.hasNext())
						{
							Cell dataOfCell=DataCellValue.next();
							//method 1....to extract cell value by using try and catch;
							try
							{
								String testData=dataOfCell.getStringCellValue();
								arrayData.add(testData);
							}
							catch(IllegalStateException e)
							{
								int inttestdata=(int) dataOfCell.getNumericCellValue();
								String stringtestdata=Integer.toString(inttestdata);
								arrayData.add(stringtestdata);
							}
							//method-2 to extract the cell value by using if and else
							/*CellType datatype=dataOfCell.getCellType();
							if (datatype.toString()=="NUMERIC")
							{
								int inttestData=(int) dataOfCell.getErrorCellValue();
								String stringtestData=Integer.toString(inttestData);
								arrayData.add(stringtestData;)
							}
							else if (datatype.toString()=="String")
							{
								String testData=dataOfCell.getStringCellValue();
								arrayData.add(testData);
							}*/
							//method 3 Extract  the data by converting it into String
							/*String testData=dataCellValue.next().toString().replaceAll("\\.\\d+$","");
							 System.out.println(testdata);
							*/
							//method 4 extract data from by using dataformatter
							/*DataFormatter format=new DataFormatter();
							String testData=format.formatCellValue(dataOfCell);
							System.out.println(testData);*/
							
							
							
						}
					}
					
				}
				
			}
			
		}
		return arrayData;
		
		
				
	}

}
