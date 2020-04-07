import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAcessoComTDD {
	public WebDriver driver; 
	
	@Test
	public void EntrarTelaLoginComSucesso() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		driver.get("http://187.35.155.198:5722/Login.aspx");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.id("MainContent_txt_usu_email"));
		username.sendKeys("veron.oliveira@auditeste.com.br");
		
		WebElement password = driver.findElement(By.id("MainContent_txt_sen_descricao"));
		password.sendKeys("auditeste");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("MainContent_BtnEntrar")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement validacao = driver.findElement(By.id("MainContent_p_titulo_secao"));
		String esperado = " Seus Projetos";
		Assert.assertEquals(esperado, validacao.getText());
		driver.quit();
		
		
	}

	String user = "joao@hotmail.com";
	String pass = "1234567890";
	
	@Test
	public void EntrarTelaLoginComDadosInvalidos() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		driver.get("http://187.35.155.198:5722/Login.aspx");
		
		
		WebElement username = driver.findElement(By.id("MainContent_txt_usu_email"));
		username.sendKeys(user);
		
		WebElement password = driver.findElement(By.id("MainContent_txt_sen_descricao"));
		password.sendKeys(pass);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.id("MainContent_BtnEntrar")).click();
		WebElement validacao = driver.findElement(By.id("MainContent_lbl_Msg"));
		String esperado = "E-mail não Localizado";
		Assert.assertEquals(esperado, validacao.getText());
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	

		driver.quit();
	}
}
