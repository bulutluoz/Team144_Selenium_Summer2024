package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    // verilen web elementlerden olusan listeyi
    // String'lerden olusan bir liste olarak kaydedip, döndürsün

    public static List<String> getStringList(List<WebElement> kaynakList){

        List<String> stringList = new ArrayList<>();

        for ( WebElement eachElement : kaynakList
             ) {

            stringList.add(eachElement.getText());

        }


        return stringList;
    }


}
