package selenium_base;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class DriverManagement {
	
	
	/**
     * <b>Nombre:</b> getDriver</br></br>
     * <b>Description:</b> Proporciona el driver del navegador seleccionado en las properties
     *
     * @return WebDriver
     * @author Ignacio Sagredo
     **/
	@SuppressWarnings("finally")
	public static WebDriver getDriver(){
		
		WebDriver driver = null;
		try {
			
		switch (Suite.BROWSER) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", String.valueOf(new File("").getAbsolutePath())+"\\drivers\\chromedriver.exe");
			disableSeleniumLogs();
			driver = new ChromeDriver();
			break;
		default:
			throw new Exception("No se ha seleccionado un navegador");
		}
		
		} catch (Exception e) {
			Suite.RESULTADO = e.getMessage();
			System.out.println(e.getMessage());
		} finally{
			return driver;
		}
		
		
	}
	
	/**
     * <b>Nombre:</b> disableSeleniumLogs</br></br>
     * <b>Description:</b> Deshabilita los logs de selenium
     *
     * @return void
     * @author Ignacio Sagredo
     **/
	public static void disableSeleniumLogs() {    
	    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	    Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
	}
	

}
