package Com.iit.test;
 
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class Utility {
	WebDriver driver;
	
	/*public Utility(WebDriver driver) {
		this.driver=driver;
	}

	@Test
	public List<WebElement> retriveSearchList(String searchText)
	{	
		driver.findElement(By.xpath("//input[@id='header-search-input']")).sendKeys(searchText);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		List<WebElement>  Searchlist= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li/span")));
		return Searchlist;
	}

	public boolean SelectRequiredSearchPattern(String searchText, String searchPattern)
	{
		boolean result= false;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		List<WebElement>  Searchlist = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li/span")));
		for(int i=0;i<Searchlist.size();i++){
			if(Searchlist.get(i).getText().contains(searchPattern)){
				Searchlist.get(i).click();
				result = true;
				break;
			}
		}
				return result;
	}
	public boolean validateLinkText(String searchPattern, int n, String title)
	{
		boolean result = true;
		List<WebElement> hlink = driver.findElements(By.xpath("//div[@id=web]/ol/li"));
		for(int i=1;i<=n;i++)
		{
			System.out.println("****************validating links in the page ::::" + i +"*************************");
			for(int j=1;j<=hlink.size();j++)
			{
				System.out.println(hlink.get(j).getText().contains(searchPattern));
						{
							if(!(hlink.get(j).getText().contains(searchPattern)))
							{
							result = false;
							System.out.println("The link text :::"+hlink.get(j).getText()+ "Result ::: "+ result);
							
						    }
				         }
			}
			focusOnElement(driver.findElement(By.linkText((i+1)+ "")));
			waitFortitle("selenium iterview questions");
			hlink = driver.findElements(By.xpath("//div[@id=web]/ol/li"));
			}
		return result;
	}
	public void focusOnElement(WebElement ele)
	{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("argument[0].click();", ele);
	 
	}
	public void waitFortitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver , 30);
		wait.until(ExpectedConditions.titleContains(title));
	}}
*/
    public Utility(WebDriver driver) {
        this. driver = driver;
    }
 
    public List<WebElement> retrieveSearchList(String searchText)
    {
            driver.findElement(By.xpath("//input[@id='header-search-input']")).sendKeys(searchText);
            WebDriverWait wait = new WebDriverWait(driver,50);
            List<WebElement> searchList =wait.until(ExpectedConditions.
                                                    visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li/span")));
            return searchList;
    }
    public boolean selectRequiredSearchPattern(String searchText,String searchPattern)
    {
            boolean result = false;
            WebDriverWait wait = new WebDriverWait(driver,10);
            List<WebElement> searchList =wait.until(ExpectedConditions.
                                                    visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li/span")));
            for(int i=0;i<searchList.size();i++)
            {
                if(searchList.get(i).getText().contains(searchPattern))
                {
                    searchList.get(i).click();
                    result = true;
                    break;
                }
            }
            return result;
         
         
    }
    public boolean validateLinkText(String searchPattern, int n,String title )
    {
         
        //driver.navigate().
        boolean result =true; 
        List<WebElement> hLinkList=   driver.findElements(By.xpath("//ol[@class=' reg searchBottom']/li//div/a"));
        for(int i=1;i<=n;i++)
        {
            System.out.println("****************Validating the Links in the Page ::: " + i+"****************************" );
            for(int j=0;j<hLinkList.size();j++)//HyperLinks Text
            {
                    System.out.println(hLinkList.get(j).getText().contains(searchPattern));
                    if(!(hLinkList.get(j).getText().contains(searchPattern)))
                    {
                        result = false;
                        System.out.println("The Link Text:::" + hLinkList.get(j).getText() +"   result:::" + result);    
                    }
              }
            focusonElement(driver.findElement(By.linkText((i+1)+"")));
            waitforTitle(title);
            hLinkList = driver.findElements(By.xpath("//ol[@class=' reg searchBottom']/li//div/a")); 
        }
        return result;
    }
    public void focusonElement(WebElement ele)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",ele);
    }
    public void waitforTitle(String title)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.titleContains(title));
    }
}