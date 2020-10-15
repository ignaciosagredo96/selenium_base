package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import selenium_base.Common;
import selenium_base.DriverManagement;
import selenium_base.Suite;


public class T1_BuscarProductos {

	 /**
     * <b>Nombre:</b> setUpDriverAndSuiteTest</br></br>
     * <b>Description:</b> Instala el entorno de ejecuci�n de las pruebas automatizadas
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
			
		
		//Se ingresa texto para buscar art�culos en Mercado Libre
		Suite.pageObjectMercadoLibre.getInputBuscadorProductos().sendKeys("autos");
		
		//Se hace click para buscar art�culos relacionados al texto ingresado
		Suite.pageObjectMercadoLibre.getButtonBuscar().click();
		
		//Se obtiene cantidad de articulos encontrados
		int cantidadArticulosEncontrados = Common.countWebElements(	Suite.pageObjectMercadoLibre.getArticuloEncontrado());
		
		if(cantidadArticulosEncontrados != 0){
			
			String contenidoArchivo = "Nombre   -   URL\n";
			
			//Se recorre cada art�culo encontrado y se extrae la informaci�n
			for (int posicionArticulo = 1; posicionArticulo <= cantidadArticulosEncontrados; posicionArticulo++) {
				String nombreArticulo = Common.getWebElementByPosition(Suite.pageObjectMercadoLibre.getArticuloEncontrado(), posicionArticulo).getText();
				String linkArticulo = Common.getWebElementByPosition(Suite.pageObjectMercadoLibre.getUrlarticuloEncontrado(), posicionArticulo).getAttribute("href");
				contenidoArchivo = contenidoArchivo + nombreArticulo + "   -   " + linkArticulo + "\n";
			}
			
			Common.createTxtFile(contenidoArchivo, "autosMercadoLibre");
			
		}
		else
		{
			Suite.RESULTADO = "NOK";
			throw new Exception("No se encontraron art�culos");
		}
		} catch (Exception e) {
			Suite.RESULTADO = e.getMessage();
			System.out.println(e.getMessage());
		}
		
	}
	
	 /**
     * <b>Nombre:</b> endTest</br></br>
     * <b>Description:</b> Finaliza el test y cierra el entorno de ejecuci�n de las pruebas automatizadas
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
