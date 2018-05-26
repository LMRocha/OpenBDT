package br.com.openbdt.leiloes.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.springframework.stereotype.Component;

import net.serenitybdd.core.pages.PageObject;

@Component
public class HomePage extends PageObject{

	@FindBy(css = "p")
	private WebElement lbBoasVindas;
	
	@FindBy(tagName = "a")
	private List<WebElement> btLinks;
	
	public WebElement getLbBoasVindas()
	{
		return this.lbBoasVindas;
	}
	
	public List<WebElement> getBtLinks(){
		return this.btLinks;
	}
	
}
