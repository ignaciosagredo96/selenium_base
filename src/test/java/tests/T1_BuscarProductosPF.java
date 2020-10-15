package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.MercadoLibrePage;
import selenium_base.Common;
import selenium_base.DriverManagement;
import selenium_base.Suite;


public class T1_BuscarProductosPF {

	 /**
     * <b>Nombre:</b> setUpDriverAndSuiteTest</br></br>
     * <b>Description:</b> Instala el entorno de ejecución de las pruebas automatizadas
     *
     * @return void
     * @author Ignacio Sagredo
     * @throws Throwable 
     **/
	@BeforeClass
    public static void setUpDriverAndSuiteTest() throws Throwable {
		Suite.loadProperties();
		Suite.driver = DriverManagement.getDriver();
		Suite.goToLocation();
		Suite.startPageObjects();
    }
	
	@Test
	public void BuscarArticulos() throws Exception {
		try {
			
		MercadoLibrePage mercadoLibrePage = PageFactory.initElements(Suite.driver, MercadoLibrePage.class);
		//Se ingresa texto para buscar artículos en Mercado Libre
		mercadoLibrePage.setInputBuscadorProductos("autos");
		
		//Se hace click para buscar artículos relacionados al texto ingresado
		mercadoLibrePage.clickButtonBuscar();
		Thread.sleep(2000);
		//Se obtiene cantidad de articulos encontrados
		int cantidadArticulosEncontrados = Common.countWebElements(	mercadoLibrePage.getArticuloEncontrado());
		
		if(cantidadArticulosEncontrados != 0){
			
			String contenidoArchivo = "Nombre   -   URL\n";
			
			//Se recorre cada artículo encontrado y se extrae la información
			for (int posicionArticulo = 1; posicionArticulo <= cantidadArticulosEncontrados; posicionArticulo++) {
				String nombreArticulo = Common.getWebElementByPosition(mercadoLibrePage.getArticuloEncontrado(), posicionArticulo).getText();
				String linkArticulo = Common.getWebElementByPosition(mercadoLibrePage.getUrlarticuloEncontrado(), posicionArticulo).getAttribute("href");
				contenidoArchivo = contenidoArchivo + nombreArticulo + "   -   " + linkArticulo + "\n";
			}
			
			Common.createTxtFile(contenidoArchivo, "autosMercadoLibre");
			
		}
		else
		{
			Suite.RESULTADO = "NOK";
			throw new Exception("No se encontraron artículos");
		}
		} catch (Exception e) {
			Suite.RESULTADO = e.getMessage();
			System.out.println(e.getMessage());
		}
		
	}
	
	 /**
     * <b>Nombre:</b> endTest</br></br>
     * <b>Description:</b> Finaliza el test y cierra el entorno de ejecución de las pruebas automatizadas
     *
     * @return void
     * @author Ignacio Sagredo
     **/
	@AfterClass
	public static void endTest() {
		
		System.out.println("Fin prueba automatizada, resultado: " + Suite.RESULTADO);
		Suite.driver.quit();
		
	}

}
