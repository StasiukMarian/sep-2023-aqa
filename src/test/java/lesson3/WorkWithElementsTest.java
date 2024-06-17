package lesson3;

import base.config.BaseTest;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class WorkWithElementsTest extends BaseTest {


//    @Test
    public void downloadFileTest() throws IOException {
    sleep(2000);

        File download = $(byXpath("(//h3/a)[1]")).scrollTo().download();

        String path = download.getPath();

        System.out.println(path);

        FileUtils.deleteDirectory(new File("build/downloads"));
    }

    public static String getFilePath(String fileName){
        return new File("src/main/resources/files/" + fileName).getAbsolutePath();
    }
//    @Test
    public void uploadFileTest(){
        $(byXpath("//input[@type='file']")).uploadFile(new File(getFilePath("annual-enterprise-survey-2021-financial-year-provisional-csv.csv")));
        sleep(1000);
    }

    @Test
    public void doubleClickTest(){
        $(byXpath("//p[@id='container-text']")).doubleClick();
        sleep(2000);
    }
//   @Test
   public void hoverTest(){
        sleep(1500);
        $(byXpath("//nav[@class='nav-menu']/div[1]")).hover();

        $(byXpath("//nav[@class='nav-menu']/div[1]//a[text()='HTML/CSS']")).click();
   }
    @Test
    public void test(){

//        $("input").append("asd");
//        $(byName("user-name")).append("standard_user");
        SelenideElement append = $(byAttribute("placeholder", "Username")).append("standard_user2");
        $(byId("password")).append("secret_sauce");
//        $(byClassName("submit-button")).click();
//        $(byValue("Login")).click();
//        $(byValue("Login")).submit();
//        $(byValue("Login")).pressEnter();

        System.out.println($(byXpath("//div[@class='login_logo']")).text());

        Selenide.actions().sendKeys(append, Keys.BACK_SPACE).perform();
        Selenide.actions().sendKeys(Keys.ENTER).perform();
//        $(byXpath("//input[@placeholder='Username']")).clear();
//        String text = $(byAttribute("placeholder", "Username")).getValue();

//        for (int i = 0; i < text.length(); i++) {
//            Selenide.actions().sendKeys(append, Keys.BACK_SPACE).perform();
//        }
//        $(byTagName("input")).append("test");

        $(byXpath("//select[@class='product_sort_container']")).click();
        sleep(1000);
        $(byXpath("//select[@class='product_sort_container']")).pressEscape();


        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).texts());
        List<String> texts = $$(byXpath("//div[@class='inventory_item_name ']")).texts();

        int i = texts.indexOf("Test.allTheThings() T-Shirt (Red)");

        ElementsCollection itemsCollection = $$(byXpath("//div[@class='inventory_item_name ']"));

//        itemsCollection.get(i).click();

        while ($$(byXpath("//button[text()='Add to cart']")).size() > 0){
            $(byXpath("//button[text()='Add to cart']")).click();
        }


//       $(byText("Sauce Labs Backpack")).click();

//        $(byTagAndText("div", "Sauce Labs Bike Light")).click();
        sleep(1000);

        $(byXpath("//a[text()='Twitter']")).click();
//        Selenide.refresh();
//        Selenide.closeWindow();
        Selenide.switchTo().window(1);

        sleep(3000);

        $(byXpath("//nav[@role='navigation']//a[@href='/settings']")).click();


    }
}
