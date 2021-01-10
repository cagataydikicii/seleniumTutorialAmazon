package methodClass;

import com.sun.deploy.cache.BaseLocalApplicationProperties;
import objectRepo.objectRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import testAutomation.test;

import java.util.List;

import static java.lang.Thread.sleep;

public class methodClass extends test {
    public WebDriverWait wait;

    public methodClass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,20);
    }






    @BeforeMethod
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ILBER ORTAYLI\\Desktop\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }


    public methodClass openPage(String value){
        driver.get(value);
        return this;
    }
//    public methodClass openPage2(){
//        driver.get("https://www.amazon.com/");
//        return this;
//    }
    public methodClass click(By cl){
        driver.findElement(cl).click();
        return this;
    }
    public methodClass clickJS(By by){

        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return this;
    }
    public methodClass info(String value) {
        System.out.println(value);
        return this;
    }
    public methodClass moveToElement(WebElement value) {

        Actions actions = new Actions(driver);
        actions.moveToElement(value);
        actions.release().perform();
        return this;
    }
    public methodClass hoverMenu(String value) {
        List<WebElement> elementList = driver.findElements(By.id("nav-link-accountList"));
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));

                break;
            }
        }
        return this;
    }
    public methodClass sendKeys(By send, String value) {
        driver.findElement(send).sendKeys(value);
        return this;
    }

    public methodClass loginPage() {
       click(objectRepo.loginPage);


        return this;
    }

    public methodClass loginP1(String email, String pass) {

        sendKeys(objectRepo.email,email);
        click(objectRepo.cont);

        sendKeys(objectRepo.password,pass);
        click(objectRepo.loginButton);
        return this;
    }

    public methodClass search(String value) throws InterruptedException {
        sendKeys(objectRepo.searchBar, value);
        click(objectRepo.searcButton);
        sleep(2000);

        return this;
    }

    public methodClass urun (String value) throws InterruptedException {

        driver.findElement(By.linkText(value)).click();
        sleep(2000);
        click(objectRepo.addCart);
        sleep(2000);
        click(objectRepo.cart);
        sleep(2000);
        click(objectRepo.delete);
        return this;
    }




    public methodClass dragAndDrop(WebElement From, int x, int y) {
        Actions act = new Actions(driver);
        act.dragAndDropBy(From, x, y).build().perform();
        return this;
    }

    public methodClass controlError(String value) {
        controlMethod(value,objectRepo.controlError);

        return this;
    }

    public methodClass lokasyon() throws InterruptedException {
        click(objectRepo.locationUsa);
        wait.until(ExpectedConditions.elementToBeClickable(objectRepo.locationCombobox));
        click(objectRepo.locationCombobox);
        comboBox("Japan");
        sleep(2000);
        clickJS(objectRepo.done);
        return this;
    }
    public methodClass comboBox(String value){
        List<WebElement> elementList = driver.findElements(objectRepo.country);
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));
                elementList.get(i).click();

                break;
            }
        }

        return this;
    }





    public methodClass switchAccount() throws InterruptedException {
        click(objectRepo.switechAccounts);
        sleep(1500);
        click(objectRepo.addAccount);
        return this;
    }
    public methodClass switchMenu(String value) {
        List<WebElement> elementList = driver.findElements(By.id("nav-link-accountList"));
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));

                break;
            }
        }
        return this;
    }


    public methodClass loginP2(String email1, String pass1) {
        sendKeys(objectRepo.email,email1);
        click(objectRepo.cont);

        sendKeys(objectRepo.password,pass1);
        click(objectRepo.loginButton);
        click(objectRepo.notNow);
        return this;
    }

    public methodClass currencySetting() {
        click(objectRepo.flag);
        wait.until(ExpectedConditions.elementToBeClickable(objectRepo.currencyBox));
        click(objectRepo.currencyBox);

        currencyBox("ARS - Argentine Peso");
        click(objectRepo.saveChanges);
        return this;
    }
    public methodClass currencyBox(String value){
        List<WebElement> elementList = driver.findElements(objectRepo.currencyList);
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));
                elementList.get(i).click();

                break;
            }
        }

        return this;
    }


    public methodClass controlLokasyon(String value) {

        controlMethod(value,objectRepo.newCountry);

        return this;
    }

    public methodClass controlMethod(String value, By elementName){
        WebElement element = driver.findElement(elementName);
        element.getText();
        Assert.assertEquals(element.getText(),value);
        info("Değet Doğru Dönmüştür" + element.getText());


        return this;
    }

    public methodClass currencyControl(String value) {
        click(objectRepo.flag);
        wait.until(ExpectedConditions.elementToBeClickable(objectRepo.currencyBox));
        controlMethod(value,objectRepo.currencyBox);

        return this;
    }
    public methodClass controlCurrency(String value, By elementName){
        WebElement element = driver.findElement(elementName);
        element.getText();
        Assert.assertEquals(element.getText(),value);
        info("Değet Doğru Dönmüştür" + element.getText());


        return this;
    }
    public methodClass comboBox2(String value){
        List<WebElement> elementList = driver.findElements(objectRepo.languageDoc);
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));
                elementList.get(i).click();

                break;
            }
        }

        return this;
    }

    public methodClass changeLanguage(String value) {
        click(objectRepo.getFlag);
        wait.until(ExpectedConditions.elementToBeClickable(objectRepo.languageSave));
        comboBox2(value);
        click(objectRepo.languageSave);
        return this;
    }
    public methodClass urunSet(String value){
        List<WebElement> elementList = driver.findElements(objectRepo.urunSet);
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));
                elementList.get(i).click();

                break;
            }
        }

        return this;
    }
    public methodClass browser(String value){
        List<WebElement> elementList = driver.findElements(objectRepo.browH);
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));
                elementList.get(i).click();

                break;
            }
        }

        return this;
    }

    public methodClass addUrun(String value) {
        urunSet(value);
        click(objectRepo.getaddCart);
        click(objectRepo.cartTo);
        click(objectRepo.delete);


        return this;
    }
    public methodClass browserH(String value) {
        List<WebElement> elementList = driver.findElements(By.id("nav-link-accountList"));
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));

                break;
            }
        }
        return this;
    }

    public methodClass browserHistry(String value) {
        click(objectRepo.logoA);
        browserH("Hello, Çağatay");
        browser(value);

        return this;
    }

    public methodClass shopList(String value) {
        urunSet(value);
        click(objectRepo.addList);
        wait.until(ExpectedConditions.elementToBeClickable(objectRepo.clickList));
        click(objectRepo.clickList);
        return this;
    }
    public methodClass box(String value){
        List<WebElement> elementList = driver.findElements(objectRepo.boxCheck);
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));
                elementList.get(i).click();

                break;
            }
        }

        return this;
    }

    public methodClass checkBox(String value) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(objectRepo.boxCheck));
        click(objectRepo.boxCheck);
        sleep(2000);
        box(value);
        return this;
    }

    public methodClass controlApple(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(objectRepo.boxCheck));
        controlMethod(value,objectRepo.setApple);

        return this;
    }

    public methodClass fiveStarList(String value) {
        urunSet(value);
        wait.until(ExpectedConditions.elementToBeClickable(objectRepo.fiveStar));
        click(objectRepo.fiveStar);
        return this;
    }
    public methodClass inch(String value){
        List<WebElement> elementList = driver.findElements(objectRepo.getGB);
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));
                elementList.get(i).click();

                break;
            }
        }

        return this;
    }

    public methodClass fourStarUp() {
        click(objectRepo.fourStarUp);

        return this;
    }
    public methodClass timeLineBarDrag(String value, int x, int y) {
        if(value=="1"){
            WebElement element = driver.findElement(objectRepo.getGB);
            moveToElement(element);
            dragAndDrop(element, x, y);
        }else {
            WebElement element = driver.findElement(objectRepo.getGB);
            moveToElement(element);
            dragAndDrop(element, x, y);
        }
        return this;
    }


    public methodClass getİnch() throws InterruptedException {
      click(objectRepo.getInch);
        sleep(2000);

        return this;
    }


}


