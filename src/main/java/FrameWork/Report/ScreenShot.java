package FrameWork.Report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    private static String PATH_SCREENSHOT = Report.PATH_REPORT + File.separator + "ScreenShot";
    public static MediaEntityModelProvider capture(WebDriver driver){
        try{
            CreateFolder.createFolderReport(PATH_SCREENSHOT);
            File scrshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String screenShotPath= PATH_SCREENSHOT + File.separator + "Image_" + DateTime.getDateTimeFormat() + ".png";
            FileUtils.copyFile(scrshot, new File(screenShotPath));
            return MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build();
        }
        catch(IOException e){
            System.out.println("Erro ao copiar arquivo" + e.getMessage());

        }
        return null;

    }
    public static MediaEntityModelProvider base64(WebDriver driver){
        try{
            return MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build();

        }
        catch(IOException e){
            System.out.println("Erro ao criar String" + e.getMessage());
        }
        return null;
    }


}
