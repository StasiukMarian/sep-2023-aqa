package test;

import org.testng.annotations.Test;

public class SecondTest {
    @Test(groups = "default tests")
    public void test(){
        System.out.println("this is test from SecondTest - Class");
    }
}
