package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import java.nio.file.Files;
import java.nio.file.Path;

public class Main_PathforFileUpLoadandFileExit  {

    @Test
        public void mainPath () {
            System.out.println(System.getProperty("user.home"));
            System.out.println(System.getProperty("user.dir"));

            String mainPath=System.getProperty("user.home");

            String folderpath=mainPath+"\\Desktop"; //for folder at the Desktop

            System.out.println(folderpath);

    }
    @Test
        public void fileExist () {
        String mainpath=System.getProperty("user.home");
        String folderPathandName=mainpath+"\\Desktop"+"\\FLOWER.jpg";  //point the folder C:\Users\TR\Desktop\FLOWER.jpg

        //Now We can assert FLOWER.JPG folder at Desktop

        Assert.assertTrue(Files.exists(Path.of(mainpath)));

    }

}
