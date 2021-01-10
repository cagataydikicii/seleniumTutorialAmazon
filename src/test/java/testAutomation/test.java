package testAutomation;

import methodClass.methodClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {


    public WebDriver driver;
    public static String url = "https://www.amazon.com.tr";
    public static String url1 = "https://www.amazon.com";
    @BeforeMethod
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ILBER ORTAYLI\\Desktop\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();


    }


    @Test(description = "Sepete Ürün Ekleme ve Çıkarma")
    public void test1() throws InterruptedException {
        methodClass methodClass = new methodClass(driver);
        String xiaomi = "Xiaomi Mi True Wireless Earbuds Basic 2 Bluetooth Kulaklık";
        String email = "x";
        String pass = "x";
        methodClass
                .openPage(url)
                .hoverMenu("Giriş yap")
                .loginPage()
                .loginP1(email, pass)
                .search(xiaomi)
                .urun(xiaomi);

    }

    @Test(description = "Kullanıcı şifresi yanlış hesapla giriş yapılırken uyarı verdiğini kontrol edilmesi")
    public void test2() {
        methodClass methodClass = new methodClass(driver);
        String email = "x";
        String pass = "x";
        methodClass
                .openPage(url)
                .hoverMenu("Giriş yap")
                .loginPage()
                .loginP1(email, pass)
                .controlError("Şifreniz yanlış");
    }

    @Test(description = "Lokasyon değiştirme")
    public  void test3() throws InterruptedException {
        methodClass methodClass = new methodClass(driver);
        String email = "x";
        String pass = "x";
        methodClass
                .openPage(url1)
                .hoverMenu("Sign in")
                .loginPage()
                .loginP1(email, pass)
                .lokasyon()
                .controlLokasyon("Japan")
        ;
    }

    @Test(description = "Kullanıcı değiştir")
    public void test4() throws InterruptedException {
        methodClass methodClass = new methodClass(driver);
        String email = "x";
        String email1 = "x";
        String pass = "x";
        String pass1 = "x;
        String switchAcc = "x";
        methodClass
                .openPage(url1)
                .hoverMenu("Sign in")
                .loginPage()
                .loginP1(email, pass)
                .switchMenu(switchAcc)
                .switchAccount()
                .loginP2(email1, pass1)
        ;
    }
    @Test(description = "Para birimi değiştirme")
    public void test5(){
        methodClass methodClass = new methodClass(driver);
        String email = "x";
        String pass = "x";
        methodClass
                .openPage(url1)
                .hoverMenu("Sign in")
                .loginPage()
                .loginP1(email, pass)
                .currencySetting()
                .currencyControl("ARS - Argentine Peso")
        ;
    }
   @Test(description = "Dil değişikliği yapılarak dilin değiştiğinin kontrolü ")
    public void test6(){
        methodClass methodClass = new methodClass(driver);
       String email = "x";
       String pass = "x";
        methodClass
                .openPage(url1)
                .hoverMenu("Sign in")
                .loginPage()
                .loginP1(email, pass)
                .changeLanguage("Deutsch - DE - Übersetzung")
        ;
   }
  @Test(description = "Sepetten çıkarılan ürünün browsing historyde gözükmesi ")
    public void test7() throws InterruptedException {
      methodClass methodClass = new methodClass(driver);
      String xiaomi = "Xiaomi Mi True Wireless Earbuds Basic 2 Bluetooth";
      String email = "x";
      String pass = "x";
      methodClass
              .openPage(url1)
              .hoverMenu("Sign in")
              .loginPage()
              .loginP1(email, pass)
              .search(xiaomi)
              .addUrun("Xiaomi")
              .browserHistry("Browsing History")
      ;
  }
  @Test(description = "Shopping List kontrolü ")
    public void test8() throws InterruptedException {
      methodClass methodClass = new methodClass(driver);
      String xiaomi = "Xiaomi Mi True Wireless Earbuds Basic 2 Bluetooth";
      String email = "x";
      String pass = "x";
      methodClass
              .openPage(url1)
              .hoverMenu("Sign in")
              .loginPage()
              .loginP1(email, pass)
              .search(xiaomi)
              .shopList("Xiaomi Mi True")
        ;
  }
  @Test(description = "Apple ürünlerine basarak apple ürünlerinin geldiğini sadece kontrol et")
  public void test9() throws InterruptedException {
      methodClass methodClass = new methodClass(driver);
      String email = "x";
      String pass = "x";
      methodClass
              .openPage(url1)
              .hoverMenu("Sign in")
              .loginPage()
              .loginP1(email, pass)
              .search("apple watch")
              .checkBox("Apple")
              .controlApple("Apple")
      ;
  }
  @Test(description = " Yorumlarda sadece 5 yıldız yaptığında yalnızca 5 yıldız olanların gelmesi gerekiyor")
  public void test10() throws InterruptedException {
      methodClass methodClass = new methodClass(driver);
      String xiaomi = "Xiaomi Mi True Wireless Earbuds Basic 2 Bluetooth";
      String email = "x";
      String pass = "x";
      methodClass
              .openPage(url1)
              .hoverMenu("Sign in")
              .loginPage()
              .loginP1(email, pass)
              .search(xiaomi)
              .fiveStarList("Xiaomi Mi True")

      ;
  }
    @Test(description = " 4 üstü yıldız yaparak 4 yıldız üstü geldiğinin kontrolü")
    public void test11() throws InterruptedException {
        methodClass methodClass = new methodClass(driver);
        String xiaomi = "Xiaomi Mi True Wireless Earbuds Basic 2 Bluetooth";
        String email = "x";
        String pass = "x";
        methodClass
                .openPage(url1)
                .hoverMenu("Sign in")
                .loginPage()
                .loginP1(email, pass)
                .search(xiaomi)
                .fourStarUp()
        ;

    }
    @Test(description  ="Ürün aratık özellik kısıtlama")
    public void test12() throws InterruptedException {
        methodClass methodClass = new methodClass(driver);
        String laptop = "Laptop";
        String email = "x";
        String pass = "x";
        methodClass
                .openPage(url1)
                .hoverMenu("Sign in")
                .loginPage()
                .loginP1(email, pass)
                .search(laptop)
                .getİnch()
                .timeLineBarDrag("1",-255,0)

        ;

    }


}
