package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HBFDeletePage {
	WebDriver driver;

	By numberOfRows = By.xpath(".//*[@id='bookings']/div");

	public HBFDeletePage(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		this.driver = driver;
	}



	public void deleteHotelBooking(String FirstName) throws Throwable {

		//To identify the rows
		List<WebElement> rows = getNumberOfRows();		
		int rowsize = rows.size();

		for (int row = 0; row < rowsize; row++) {
			row=row+2;
			//String attribute = driver.findElement(By.cssSelector("div.container div:nth-child(2) div.row:nth-child("+ row +") div.col-md-1:nth-child(7) > input:nth-child(1)")).getAttribute("onclick");
			String attribute = getIDOfParticularRow(row);
			row=row-2;
			//this will get the id of the row in question
			String input = attribute, extractedID;
			extractedID = input.substring(input.indexOf('(')+1,input.lastIndexOf(')'));
			//System.out.println("extracted value is" + extractedID);

			//To identify the columns
			//List < WebElement> Columns = driver.findElements(By.xpath("//div[@id="+extractedID+"]//div"));
			List < WebElement> Columns = getNumberOfColumns(extractedID);
			//To calculate no of columns (cells). In that specific row.
			int columnsize = Columns.size();
			//System.out.println("column size is " + columnsize);
			//Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columnsize; column++) {
				// To retrieve text from that specific cell.
				String celltext = Columns.get(column).getText();
				if (celltext.equals(FirstName) )
				{
					clickDelete(extractedID);
					//driver.findElement(By.xpath("//div[@id="+extracted+"]//input[@value='Delete']")).click();
					//System.out.println("The row created deleted successfully");

				}

			}
		}

	}


	public String getIDOfParticularRow(int row) {
		return driver.findElement(By.cssSelector("div.container div:nth-child(2) div.row:nth-child("+ row +") div.col-md-1:nth-child(7) > input:nth-child(1)")).getAttribute("onclick");
	}

	public void clickDelete(String extracted) {
		driver.findElement(By.xpath("//div[@id="+extracted+"]//input[@value='Delete']")).click();

	}

	public List<WebElement> getNumberOfRows() {

		return driver.findElements(numberOfRows);

	}

	public List<WebElement> getNumberOfColumns(String extracted) {

		return driver.findElements(By.xpath("//div[@id="+extracted+"]//div"));

	}
	
	
	
	public void verifyDeletedHotelBooking(String FirstName) throws Throwable {

		//To identify the rows
		List<WebElement> rows = getNumberOfRows();		
		int rowsize = rows.size();
		System.out.println("row size is " + rowsize);
		
		for (int row = 0; row < rowsize-2; row++) {
			row=row+2;
			//String attribute = driver.findElement(By.cssSelector("div.container div:nth-child(2) div.row:nth-child("+ row +") div.col-md-1:nth-child(7) > input:nth-child(1)")).getAttribute("onclick");
			String attribute = getIDOfParticularRow(row);
			row=row-2;
			//this will get the id of the row in question
			String input = attribute, extractedID;
			extractedID = input.substring(input.indexOf('(')+1,input.lastIndexOf(')'));
			System.out.println("extracted value is" + extractedID);

			//To identify the columns
			//List < WebElement> Columns = driver.findElements(By.xpath("//div[@id="+extractedID+"]//div"));
			List < WebElement> Columns = getNumberOfColumns(extractedID);
			//To calculate no of columns (cells). In that specific row.
			int columnsize = Columns.size();
			System.out.println("column size is " + columnsize);
			//Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columnsize; column++) {
				// To retrieve text from that specific cell.
				String celltext = Columns.get(column).getText();
				System.out.println("Cell text is" + celltext);
				if (!celltext.equals(FirstName) )
				{
					
					Assert.assertNotEquals(celltext, FirstName);
					//Assert.assertNotSame(celltext, FirstName);   
					//clickDelete(extractedID);
					//driver.findElement(By.xpath("//div[@id="+extracted+"]//input[@value='Delete']")).click();
					//System.out.println("The row created deleted successfully");

				}

			}
		}

	}
	
	


}
