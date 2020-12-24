package TestNG_POM_DDF;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility 
{
static Sheet sh;
	
	public static String getTestData(int rowIndx, int colIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream(	"E:\\Velo\\Sept20.xlsx");
		 sh = WorkbookFactory.create(file).getSheet("DDF");
		String value = sh.getRow(rowIndx).getCell(colIndex).getStringCellValue();
		 return value;
	}

}
