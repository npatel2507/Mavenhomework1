package group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Register {
           protected static WebDriver driver;

           public String generateemail(String startValue){

               String email = startValue.concat(new Date().toString());
               return email;
           }
           public static String randomDate()
           {
               DateFormat format =new SimpleDateFormat("ddMMyyHHmmss");
               return format.format(new Date());
           }
           @BeforeMethod
            public void openbrowser(){
               System.setProperty("webdriver.chrome.driver","src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

            //open the browser
            driver = new ChromeDriver();

            //maximise the browser window screen
            driver.manage().window().fullscreen();

            //set inplicity wait for driver object
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);}

            @AfterMethod
            public void closeBrowser(){driver.quit();}

            @Test
                public void userShouldbeAbleToRegisterSuccessfully() {

                //open the website
                driver.get("https://demo.nopcommerce.com/");

               //click on register botton
                driver.findElement(By.xpath("//a[@class='ico-register']")).click();

                //enter first name
                driver.findElement(By.id("FirstName")).sendKeys("Nimisha");

                //enter last name
                driver.findElement(By.xpath("//input[@name= 'LastName']")).sendKeys("Patel");

                //enter email
                driver.findElement(By.name("Email")).sendKeys("test"+ randomDate() +"@gmail.com");

                //enter the password
                driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"Password\"]")).sendKeys("xyz123");

                //enter confirm password
                driver.findElement(By.name("ConfirmPassword")).sendKeys("xyz123");

                //click on register
                driver.findElement(By.xpath("//input[@class=\"button-1 register-next-step-button\"]")).click();

                String expectedMassage = "Your registration completed";
                String actualMessage = driver.findElement(By.className("result")).getText();

                Assert.assertEquals(actualMessage, expectedMassage);
           }
                       @Test
                        public void userShouldReferAProductToAFriend(){

                        //open the website
                        driver.get("https://demo.nopcommerce.com/");

                        //click on register botton
                        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

                        //enter first name
                        driver.findElement(By.id("FirstName")).sendKeys("Nimisha");

                        //enter last name
                        driver.findElement(By.xpath("//input[@name= 'LastName']")).sendKeys("Patel");

                        //enter email
                        driver.findElement(By.name("Email")).sendKeys("test"+ randomDate() +"@gmail.com");

                        //enter the password
                        driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"Password\"]")).sendKeys("xyz123");

                        //enter confirm password
                        driver.findElement(By.name("ConfirmPassword")).sendKeys("xyz123");

                        //click on register
                        driver.findElement(By.xpath("//input[@class=\"button-1 register-next-step-button\"]")).click();

                        //click on nopcommerce logo
                        driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]")).click();

                        //click on apple macbook
                        driver.findElement(By.xpath("//h2/a[@href=\"/apple-macbook-pro-13-inch\"]")).click();

                        //click on email friend
                        driver.findElement(By.xpath("//input[@value=\"Email a friend\"]")).click();

                    //select friend email address
                    driver.findElement(By.id("FriendEmail")).sendKeys("nimisha_2507@yahoo.co.in");

                    //enter comment
                    driver.findElement(By.name("PersonalMessage")).sendKeys("The product you were searching for");

                    //send email friend
                    driver.findElement(By.xpath("//input[contains(@name,'send-email')]")).click();

                        String expectedMassage = "Your message has been sent.";
                        String actualMessage = driver.findElement(By.className("result")).getText();

                        Assert.assertEquals(actualMessage, expectedMassage);
                     }

                     @Test
                     public void userShouldBeNevigateToCameraAndPhoto()
                     {
                         //open the website
                         driver.get("https://demo.nopcommerce.com/");

                         //click on electronics
                         driver.findElement(By.xpath("//h2/a[@title=\"Show products in category Electronics\"]")).click();

                         //click on camera and photos
                         driver.findElement(By.xpath("//h2/a[@title=\"Show products in category Camera & photo\"]")).click();

                         String expectedResult = "Camera & photo";
                         String actualResult = driver.findElement(By.linkText("Camera & photo")).getText();

                         Assert.assertEquals(actualResult, expectedResult);
                     }

                     @Test
                     public void userShouldBeAbleToFilterJewelryByPrice$700To$3000()
                     {
                         //open the website
                         driver.get("https://demo.nopcommerce.com/");

                         //click on jewelry
                         driver.findElement(By.linkText("Jewelry")).click();

                         String expectedTitle = "Jewelry";
                         String actualTitle = driver.findElement(By.linkText("Jewelry")).getText();

                         Assert.assertEquals(actualTitle, expectedTitle);

                         //click on $700.00 - $3,000.00
                         driver.findElement(By.xpath("//a[@href=\"//demo.nopcommerce.com/jewelry?price=700-3000\"]")).click();

                         String expectedprice = "$2,100.00";
                         String actualprice = driver.findElement(By.xpath("//span[@class=\"price actual-price\"]")).getText();

                        Assert.assertEquals(actualprice, expectedprice);
                     }
                     @Test
                      public void userShouldBeAbleToAddTwoBooksInBasket() {

                         //open the website
                         driver.get("https://demo.nopcommerce.com/");

                         //click on books
                         driver.findElement(By.linkText("Books")).click();

                         //click on Fahrenheit 451 by Ray Bradbury
                         driver.findElement(By.xpath("//img[@alt=\"Picture of Fahrenheit 451 by Ray Bradbury\"]")).click();

                         //click on add to cart
                         driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-37\"]")).click();

                         //click on First Prize Pies
                         driver.findElement(By.linkText("First Prize Pies")).click();

                         //click on add to cart
                         driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-38\"]")).click();

                         //click on basket
                         driver.findElement(By.linkText("Shopping cart")).click();

                         String expectedResult = "Shopping cart";
                         String actualResult = driver.findElement(By.linkText("Shopping cart")).getText();

                         Assert.assertEquals(actualResult, expectedResult);
           }
           }



