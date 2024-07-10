package rahulshettyAcademy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class basicElementsPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("#radio-btn-example fieldset label input")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("SeleniumPractise");
		WebElement dropdown = driver.findElement(By.cssSelector("select[name='dropdown-class-example']"));
		Select s = new Select(dropdown);
		s.selectByIndex(0);
		s.selectByVisibleText("Option2");
		s.selectByValue("option3");
		WebElement ele = s.getFirstSelectedOption();
		System.out.println(ele.getText());
		List<WebElement> checkbox = driver.findElements(By.cssSelector("#checkbox-example fieldset label input"));
		checkbox.stream().forEach(c -> c.click());
		driver.findElement(By.id("openwindow")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		if (it.hasNext()) {
			System.out.println(driver.switchTo().window(it.next()).getTitle());
			System.out.println(driver.findElement(By.cssSelector(".cont span")).getText());
		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("name")).sendKeys("Raga");
		WebElement alert = driver.findElement(By.id("alertbtn"));
		alert.click();
		// Alert a = (alert);
		System.out.println(driver.switchTo().alert().getText().split(",")[0].split(" ")[1].equalsIgnoreCase("raga"));

	}

}
