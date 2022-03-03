package pages;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasePage {
	public WebDriverWait wait;
    public WebDriver driver;
    public Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, 60);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }

    /**
     * Metodo de acesso a url
     *
     * @param url
     */
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    /**
     * Metodo de preenchimento dos inputs
     *
     * @param campo
     * @param value
     */
    public void fillsField(WebElement campo, String value) {
        wait.until(ExpectedConditions.visibilityOf(campo));
        campo.clear();
        campo.sendKeys(value);
        printFill(value);
    }
    
    /**
     * Metodo de limpar campo input com click
     *
     * @param campo
     * @param value
     */
    public void clearFieldWithClick(WebElement campo) {
        wait.until(ExpectedConditions.visibilityOf(campo));
        campo.click();
        campo.clear();
    }
    
    /**
     * Metodo de limpar campo input sem click
     *
     * @param campo
     * @param value
     */
    public void clearField(WebElement campo) {
        wait.until(ExpectedConditions.visibilityOf(campo));
        campo.clear();
    }
    
    /**
     * Metodo para send keys slowly
     * @param element
     * @param value
     */
    public void typeInField(WebElement element, String value){
        String val = value; 
        element.clear();

        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
        printFill(value);
    }
    
    /**
     * Metodo para send keys da forma humana
     * @param element
     * @param text
     */
    public static void typingHumanKeys(WebElement element, String value) {
        Random r = new Random();
        for(int i = 0; i < value.length(); i++) {
            try {
                Thread.sleep((int)(r.nextGaussian() * 15 + 100));
            } catch(InterruptedException e) {}
            String s = new StringBuilder().append(value.charAt(i)).toString();
            element.sendKeys(s);
        }
        printFill(value);
    }
    
    /**
     * Metodo para selecionar tela de trabalho
     * 
     * @param element1 WebElement referente ao campo input
     * @param element2 WebElement referente ao elemento html <td> da tela
     * @param screenName
     */
    public void selectScreenWork(WebElement element, String screenName) throws Exception {
    	wait.until(ExpectedConditions.visibilityOf(element));
    	element.clear();
    	element.sendKeys(screenName);
    	implicitWait(2000);
    	element.sendKeys(Keys.ENTER);
    	printFill(screenName);
    }
    
    /**
     * Metodo de preenchimento dos inputs
     *
     * @param campo
     * @param value
     */
    public void fillsFieldWithClick(WebElement campo, String value) {
        wait.until(ExpectedConditions.visibilityOf(campo));
        campo.click();
        campo.clear();
        campo.sendKeys(value);
        printFill(value);
    }
    
    /**
     * Metodo de preenchimento dos inputs
     *
     * @param campo
     * @param value
     */
    public void fillsFieldWithClickNotClear(WebElement campo, String value) {
        wait.until(ExpectedConditions.visibilityOf(campo));
        campo.click();
        campo.sendKeys(value);
        printFill(value);
    }

    /**
     * Metodo de click no WebElement
     *
     * @param element
     */
    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    
    /**
     * Metodo de double click no WebElement
     *
     * @param element
     */
    public void doubleClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.doubleClick(element);
    }
    
    /**
     * Metodo de click no WebElement
     *
     * @param element
     */
    public void clickAndPaste(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.sendKeys(Keys.CONTROL + "v");
    }
    
    /**
     * Metodo de click no WebElement
     *
     * @param element
     */
    public void clickAndMoveArrow(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.sendKeys(Keys.DOWN);
        element.sendKeys(Keys.ENTER);
    }
    
    /**
     * Metodo de seleção do combo box
     *
     * @param campo
     * @param value
     * @throws Exception
     */
    public void selectComboBox(WebElement campo, String value) throws Exception {
        Select combo = new Select(campo);
        combo.selectByVisibleText(value);
        printFillComboBox(value);
    }

    /**
     * Metodo de espera explicita
     *
     * @param tempoEmMilissegundos
     * @throws InterruptedException
     */
    public static void implicitWait(int tempoEmMilissegundos) throws InterruptedException {
        System.out.println("Espera Implicita de " + tempoEmMilissegundos + "Milisegundos");
        Thread.sleep(tempoEmMilissegundos);
    }
    
    /**
     * Metodo de espera implicita
     *
     * @param tempoEmMilissegundos
     * @throws InterruptedException
     */
    public void implicitlyWait(WebElement campo, int tempoEmMilissegundos) throws InterruptedException {
        System.out.println("Espera Implicita de " + tempoEmMilissegundos + "Milisegundos");
        //driver.manage().timeouts().implicitlyWait(tempoEmMilissegundos, TimeUnit.MILLISECONDS);
    }

    /**
     * Metodo de criação de log para input
     *
     * @param value
     */
    public static void printFill(String value) {
        System.out.println("Preencho o campo com valor [ " + value + " ]");
    }

    /**
     * Metodo de criação de log para combo box
     *
     * @param value
     */
    public static void printFillComboBox(String value) {
        System.out.println("Seleciono no comboBox o valor [ " + value + " ]");
    }

    /**
     * Metodo de criação de log para checkbox
     *
     * @param value
     */
    public static void printFillCheckBox(String value) {
        System.out.println("Seleciono a opção do CheckBox  [ " + value + " ] ");
    }

    /**
     * Metodo de criação de log para ação de click
     *
     * @param click
     */
    public static void printClick(String click) {
        System.out.println("Clico em [ " + click + " ]");
    }

    /**
     * Metodo de criação de log para ação de click printando WebElement
     *
     * @param element
     */
    public static void printClick2(WebElement element) {
        System.out.println("Clico em [ " + element + " ]");
    }

    /**
     * Metodo de criação de log para radioButton
     *
     * @param value
     */
    public static void printFillRadioButton(String value) {
        System.out.println("Seleciono a opção [ " + value + " ]");
    }
    
    public String gerarCpf() {
    	RestAssured.baseURI = "https://www.4devs.com.br/ferramentas_online.php";
    	String acao = "gerar_cpf";
    	String body = String.format("acao=%s", acao);
		Response response = given().with().
    			header("Content-Type", "application/x-www-form-urlencoded").
    			body(body).
    			post(baseURI);
    	
    	return response.getBody().asString();    	
    }
    
    public void makeScreenshot(String namePicture) throws Exception {
    	File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(screenShot, new File("target/"+namePicture+".PNG"));
    }
}
