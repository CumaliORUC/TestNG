package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Hard_SoftAssertion {

    /*
    "Hello java, hello world, the tests are easy with Selenium"

   1- Test the sentence has "Java"
   2- Test the sentence has not "Cucumbar"
   3- Test the sentence has 10 words,
   4- Test the sentence has 45 letters.
     */
    String sentence="Hello java, hello world, the tests are easy with Selenium";
    String words[]=sentence.split(" ");
    String letters[]=sentence.split("");
    @Test

    public void hardsserttest01() {

        Assert.assertTrue(sentence.contains("java"));
        System.out.println("1- true it has Java");

        Assert.assertFalse(sentence.contains("Cucumbar"));
        System.out.println("2- false it has not cucumbar");


        Assert.assertEquals(words.length,10);
        System.out.println("3- True it has 10 words");


        Assert.assertEquals(letters.length,45);
        System.out.println("4- False it has not 45 letters");

    }
     /*
    "Hello java, hello world, the tests are easy with Selenium"

   1- Verify the sentence has "JAVA"
   2- Verify the sentence has not "Cucumbar"
   3- Verify the sentence has 11 words,
   4- Verify the sentence has 57 letters.
     */

    @Test
    public void softAsserttest01() {
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(sentence.contains("JAVA"),"Test failed it has not JAVA");
        System.out.println("It is failed but it run");
        soft.assertFalse(sentence.contains("Cucumber"), "Test failed it has not");
        System.out.println("It is failed but it run");
        soft.assertEquals(words.length,10, "Test failed it is not 10");
        System.out.println("It is failed but it run");
        soft.assertEquals(letters.length,45,"Letters are not 45");
        System.out.println("It is failed but it run");

        soft.assertAll();


    }

}
