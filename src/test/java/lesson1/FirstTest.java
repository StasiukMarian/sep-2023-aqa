package lesson1;

import base.config.BaseTest;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$;

public class FirstTest extends BaseTest {
//    @BeforeSuite
//    public void beforeSuite(){
//        System.out.println("Site is working");
//    }
//    @BeforeClass
//    public void login(){
//        System.out.println("Log in successful");
//    }
//    @BeforeGroups("default tests")
//    public void beforeGroup(){
//        System.out.println("this method works before `default tests` group");
//    }
//    @BeforeMethod
//    public void checkTest(){
//        System.out.println("Test is starting");
//    }



    @Test(groups = "default tests", description = "TEST-1: Verify bin works properly")
    public void addToBinTest(){
       Selenide.open("https://www.google.com");
    }



//    @AfterMethod
//    public void testDone(){
//        System.out.println("Test done");
//    }
//    @AfterClass
//    public void logout(){
//        System.out.println("Log out successful");
//    }
//    @AfterSuite
//    public void afterSuite(){
//        System.out.println("Site is closed");
//    }
}
