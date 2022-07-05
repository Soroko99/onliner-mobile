package mobile.onliner.pageobjects.pages;

import mobile.framework.BasePage;
import mobile.framework.elements.Label;
import org.openqa.selenium.By;

public class CatalogPage extends BasePage {

    private String allSectionsXpath = "//div[contains(text(), '%s')]";
    private String electronicaXpath ="//span[contains(text(), '%s')]/parent::span";
    private String tvAndVideoXpath = "//div[contains(text(), '%s')]";
    private String tvXpath = "//div[@data-id = '1']//span[contains(text(), '%s')]";


    public CatalogPage allSectionsClick(String allSectionsName){
        Label allSections = new Label(By.xpath(String.format(allSectionsXpath, allSectionsName)));
        allSections.click();
        return this;
    }

    public CatalogPage electronicaChoice(String electronicaName){
        Label electronica = new Label(By.xpath(String.format(electronicaXpath, electronicaName)));
        electronica.click();
        return this;
    }

    public CatalogPage tvAndVideoChoice(String tvAndVideoName){
        Label tvAndVideo = new Label(By.xpath(String.format(tvAndVideoXpath, tvAndVideoName)));
        tvAndVideo.click();
        return this;
    }

    public CatalogPage tvChoice(String tvName){
        Label tv = new Label(By.xpath(String.format(tvXpath, tvName)));
        tv.click();
        return this;
    }


}
