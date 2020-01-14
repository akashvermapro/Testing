import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven {

	public static void main(String[] args) throws IOException{
		try{
			FileInputStream fi = new FileInputStream("C:\\Users\\Admin\\Desktop\\test.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFSheet sh = wb.getSheetAt(0);
			Row r = sh.getRow(0);
			Cell c = r.getCell(0);
			System.out.println(c);
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			//driver.get(c.toString());
			driver.get("https://www.flipkart.com/mobiles/mi~brand/pr?sid=tyy,4io&otracker=nmenu_sub_Electronics_0_Mi");
			String s = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div[2]/div[3]/div/div/div/a/div[2]/div[1]/div[1]")).getText();
			System.out.println(s);
			int rowCount=0;
			Row newRow = sh.createRow(rowCount+1);
			for(int j = 0;j<r.getLastCellNum();j++){
				Cell cell = newRow.createCell(j);
				cell.setCellValue(s);
			}
			fi.close();
			FileOutputStream fo = new FileOutputStream("C:\\Users\\Admin\\Desktop\\test.xlsx");
			wb.write(fo);
			fo.close();
			wb.close();
			driver.get("https://www.naukri.com/");
			driver.switchTo().alert().dismiss();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
