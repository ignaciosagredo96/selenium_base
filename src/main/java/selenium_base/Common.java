package selenium_base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Common {

	/**
     * <b>Nombre:</b> countWebElements</br></br>
     * <b>Description:</b> Cuenta la cantidad de webElements dado un xpath
     *
     * @return int
     * @author Ignacio Sagredo
     **/
	public static int countWebElements(String xpathElement){
		return Suite.driver.findElements(By.xpath(xpathElement)).size();
	}
	
	/**
     * <b>Nombre:</b> getWebElementByPosition</br></br>
     * <b>Description:</b> Devuelve un WebElement de acuerdo a un posición y Xpath dado
     *
     * @return int
     * @author Ignacio Sagredo
     **/
	public static WebElement getWebElementByPosition(String xpathElement, int position){
		return Suite.driver.findElement(By.xpath("("+xpathElement+")["+position+"]"));
	}
	
	/**
     * <b>Nombre:</b> createTxtFile</br></br>
     * <b>Description:</b> Crea un archivo de texto en la carpeta output del proyecto
     *                     de acuerdo a un contenido y título entregados
     * @return int
     * @author Ignacio Sagredo
     **/
	public static void createTxtFile(String content, String title) {
		try {
			String ruta = new File("").getAbsolutePath() + "\\output\\" + title + ".txt";
			File file = new File(ruta);
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fw);
			bufferedWriter.write(content);
			bufferedWriter.close();
			if(file.exists())
			{
				System.out.println("Archivo texto " + title +" generado con éxito en la ruta\n" + ruta);
			}
			else
			{
				throw new Exception("Archivo de texto no creado");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
