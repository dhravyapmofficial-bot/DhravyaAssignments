    package org.testleaf.week4day1assignment;

    import java.time.Duration;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.By;
    import org.openqa.selenium.chrome.ChromeDriver;
    
    public class ListInterface {
        public static void main(String[] args) {
            
            ChromeDriver obj=new ChromeDriver();
            obj.get( "https://www.amazon.in/");
            obj.manage().window().maximize();
            obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            obj.findElement(By.linkText("Mobiles")).click();
            //Capture Price Elements
            List<WebElement> elements = obj.findElements(By.xpath("//span[@class='a-price-whole']"));
            //Create List to Store Prices
            List<Integer> priceList=new ArrayList<Integer>();

            int size = elements.size();
            for(int i=0;i<size;i++){
                String text = elements.get(i).getText();
                // removing comma
                text = text.replace(",", "");
                if(!text.isEmpty()){
                // coverting text to integer for sorting
                priceList.add(Integer.parseInt(text));
                }
            }   

                // check list is not empty
                if (!priceList.isEmpty()) {
                Collections.sort(priceList);
                int lowestPrc = priceList.get(0);
                System.out.println("The lowest price is: " + lowestPrc);
            } else {
                System.out.println("No prices found!");
            }
            obj.quit();
            }
            

            
        
        }


