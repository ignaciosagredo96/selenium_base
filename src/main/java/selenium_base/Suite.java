package selenium_base;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.MercadoLibrePage;

public class Suite {
	
	public static WebDriver driver;
	public static String fileProperties = "resources/config.properties";
	public static String URL = "";
	public static String BROWSER = "";
	public static String RESULTADO = "OK";
	
	//Page Object Mercado Libre
	public static MercadoLibrePage pageObjectMercadoLibre;
	
	/**
     * <b>Nombre:</b> startPageObjects</br></br>
     * <b>Description:</b> 	Inicializa los pageObjects del proyecto de automatización
     *
     * @return void
     * @author Ignacio Sagredo
     **/
	public static void startPageObjects() {
		pageObjectMercadoLibre = PageFactory.initElements(driver, MercadoLibrePage.class);
	}
	
	/**
     * <b>Nombre:</b> startPageObjects</br></br>
     * <b>Description:</b> 	Carga las properties contenidas en el archivo de configuración del framework
     *
     * @return void
     * @author Ignacio Sagredo
     **/
	public static void loadProperties() {
		System.out.println("Inicio prueba automatizada");
		Properties prop = new Properties();
		try {
			String file = fileProperties;
			prop.load(new FileInputStream(file));
		    URL = prop.getProperty("url");
			BROWSER = prop.getProperty("browser");
		} catch (Exception e) {
			Suite.RESULTADO = e.getMessage();
			fail("Exception: " + e.getMessage());
		}
	}
	
	/**
     * <b>Nombre:</b> goToLocation</br></br>
     * <b>Description:</b> 	Indica al driver la URL para cargar el sitio web o aplicación,. además
     * 	                    espera que la página cargue y maximiza el navegador
     *
     * @return void
     * @author Ignacio Sagredo
     **/
	public static void goToLocation()
	{
		try {
			
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		} catch (Exception e) {
			Suite.RESULTADO = e.getMessage();
			System.out.println(e.getMessage());
		}
	}
	

	
	
}
