/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailviewer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author eyosias
 * ATR/0484/09 Software Engineering Section 2
 */
public class EmailViewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
         WebDriver driver;
         
         driver = new ChromeDriver();
         driver.get("https://www.gmail.com");
         WebElement email = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
         WebElement cont = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));
          email.sendKeys("eyosiassamson5@gmail.com");
          cont.click();
          Thread.sleep(1000);
          
          WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
          WebElement cont2 = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span"));
          
          password.sendKeys("P@@sw0rd");
          cont2.click();
          Thread.sleep(1000);
          
          List<WebElement> unreadMessages = driver.findElements(By.className("zE"));
          
          File file = new File("UnreadMessages.txt");
          FileWriter fileWriter = new FileWriter(file);
          
          for(WebElement unreadMessage:unreadMessages){
              String sentby = unreadMessage.findElement(By.className("yW")).getText();
              String subject = unreadMessage.findElement(By.className("y6")).getText();
              
              fileWriter.write("Sender: ");
              fileWriter.write(sentby);
              fileWriter.write("       Subject: ");
              fileWriter.write(subject);
              fileWriter.write("\n");
              
          }
          fileWriter.flush();
          fileWriter.close();
          Thread.sleep(100000);
          driver.quit();
          
          
          
          
          
          
         
    }
    
}
