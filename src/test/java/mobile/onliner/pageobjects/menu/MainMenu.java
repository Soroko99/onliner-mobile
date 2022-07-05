package mobile.onliner.pageobjects.menu;

import mobile.framework.BasePage;
import mobile.framework.elements.Label;
import org.openqa.selenium.By;

public class MainMenu extends BasePage {
    private String subsectionXpath = "//span[contains(text(), '%s')]//ancestor::li[contains(@class, 'header-style__item  ')]";

    public MainMenu burgerMenuClick(){
        Label burgerMenu = new Label(By.xpath("//a[@class='header-style__underlay']"));
        burgerMenu.clickAndWait();
        return this;
    }

    public MainMenu catalogChoice(String subsectionName){
        Label catalogItem = new Label(By.xpath(String.format(subsectionXpath, subsectionName)));
        catalogItem.click();
        return this;
    }

}
