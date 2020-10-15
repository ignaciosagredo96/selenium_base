package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercadoLibrePage {
	
	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Buscar productos')]")
	private WebElement inputBuscadorProductos;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement buttonBuscar;
	
	private String xpathArticuloEncontrado = "//h2[contains(@class,'item__title')]//span";
	
	private String xpathUrlarticuloEncontrado = "//a[contains(@class,'item__info-link')]";

	public WebElement getInputBuscadorProductos() {
		return inputBuscadorProductos;
	}
	
	public void setInputBuscadorProductos(String textoABuscar) {
		inputBuscadorProductos.sendKeys(textoABuscar);;
	}

	public WebElement getButtonBuscar() {
		return buttonBuscar;
	}
	
	public void clickButtonBuscar() {
		buttonBuscar.click();
	}
	
	public String getArticuloEncontrado() {
		return xpathArticuloEncontrado;
	}
	
	public String getUrlarticuloEncontrado() {
		return xpathUrlarticuloEncontrado;
	}
	
	
	
	
}
