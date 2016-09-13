package com.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	

	public static void takescreenshot(WebDriver driver,String screenshotname){
 
	 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 if(src.exists())
     {
        System.out.println(src.getAbsolutePath());
     try
   	  {
			FileUtils.copyFile(src, new File("/takescreenscreenshot/"+screenshotname+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
     }

	}}



