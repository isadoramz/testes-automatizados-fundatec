package FrameWork.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Report {
    public static WebDriver driver;
    public static String PATH_REPORT=
            System.getProperty("user.dir")
                    + File.separator + "Report" + File.separator + "Report_" + DateTime.getDateTimeFormat();
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static void setExtentReport(){
        CreateFolder.createFolderReport(PATH_REPORT);
        htmlReporter = new ExtentHtmlReporter(PATH_REPORT + File.separator + "Execução_" + DateTime.getDateTimeFormat() + ".html" );
        htmlReporter.config().
                setDocumentTitle("Relatório de Execução de Testes Automatizados");
        htmlReporter.config().
                setReportName("Relatório de Execução do Fluxo Swag");
        htmlReporter.config().
                setTheme(Theme.STANDARD);
        htmlReporter.config().
                setEncoding("UTF-8");
        htmlReporter.config().
                setTimeStampFormat(" EEEE , MMMM dd , yyyy , hh:mm a '('zzz')'");

        extentReports= new ExtentReports();
        extentReports.attachReporter(htmlReporter);


    }
        public static void startReport(String testName){
        extentTest = extentReports.createTest(testName);
        }
        public static void endReport(){
        extentReports.flush();
        if(driver!=null){
            driver.quit();
            driver = null;
        }

        }
}
