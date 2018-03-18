

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTests {
	@Parameters("browser")
	@Test
	public void TestLaunch(String browser) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc=new DesiredCapabilities() ;
		if(browser.equals("chrome")) {
			System.out.println("chrome");
		dc.setBrowserName("chrome");
			dc.setPlatform(Platform.ANY);
		}
		
		else if(browser.equals("firefox")){
			System.out.println("Firefox");
			dc.setBrowserName("firefox");
			dc.setPlatform(Platform.ANY);
		}
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"),dc);
		driver.get("https://www.google.com");
		
		
		Thread.sleep(10000);
		driver.quit();
	}
}