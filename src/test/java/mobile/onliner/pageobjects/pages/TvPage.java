package mobile.onliner.pageobjects.pages;

import mobile.framework.BasePage;
import mobile.framework.elements.Checkbox;
import mobile.framework.elements.Dropdown;
import mobile.framework.elements.Label;
import mobile.framework.elements.TextBox;
import org.openqa.selenium.By;
import java.util.Locale;

public class TvPage extends BasePage {

    private String filtersXpath = "//div[@id = 'schema-order']//div[contains(text(), '%s')]";
    private String samsungXpath = "//li//input[@value='%s']//ancestor::label[@class='schema-filter__checkbox-item']";
    private String maxPriceXpath = "//input[contains(@placeholder, '%s')]";
    private String resolutionInputXpath = "//select[contains(@data-bind, '%s')]";


    public TvPage openFilter(String filtersName){
        Label filters = new Label(By.xpath(String.format(filtersXpath, filtersName)));
        filters.click();
        return this;
    }

    public TvPage manufacturerChoice(String manufacturerName){
        Checkbox samsung = new Checkbox(By.xpath(String.format(samsungXpath, manufacturerName.toLowerCase(Locale.ROOT))));
        samsung.click();
        return this;
    }

    public TvPage maxPriceInput(String pricePlaceholder, String maximumPrice){
        TextBox maxPrice = new TextBox(By.xpath(String.format(maxPriceXpath, pricePlaceholder)));
        maxPrice.scrollIntoView();
        maxPrice.sendKeys(maximumPrice);
        return this;
    }

    public TvPage minResolutionChoice(String fromOrTo, String minResolutionInput){
        Dropdown minResolution = new Dropdown(By.xpath(String.format(resolutionInputXpath, fromOrTo)));
        minResolution.selectByValue(Integer.toString(Integer.parseInt(minResolutionInput) * 10));
        return this;
    }

    public TvPage maxResolutionChoice(String fromOrTo, String maxResolutionInput){
        Dropdown maxResolution = new Dropdown(By.xpath(String.format(resolutionInputXpath, fromOrTo)));
        maxResolution.selectByValue(Integer.toString(Integer.parseInt(maxResolutionInput) * 10));
        return this;
    }

    public TvPage closeFilter(){
        Label closeFilter = new Label(By.xpath("//div[@class='schema-grid__toggle js-schema-aside-close']"));
        closeFilter.click();
        return this;
    }

    public TvPage manufacturerValidation(){
        Label manufacturerLabel = new Label(By.xpath("//span[contains(@data-bind,'product.full_name')]"));
        for (int i = 0; i < manufacturerLabel.getElements().size(); i++) {
            softAssert.assertTrue(manufacturerLabel.getElements().get(i).getText().contains("Samsung"));
        }
        return this;
    }

    public TvPage priceValidation(){
        Label priceValLabel = new Label(By.xpath("//span[contains(@data-bind, 'BYN')]"));
        for (int i = 0; i < priceValLabel.getElements().size(); i++) {
            softAssert.assertTrue(Double.parseDouble(priceValLabel.getElements().get(i).getText().split(" ")[0].replaceAll(",", "."))
                    <= 2000);
        }
        return this;
    }

    public TvPage resolutionValidation(){
        Label resolutionLabel = new Label(By.xpath("//div[@title='\u0414\u0438\u0430\u0433\u043e\u043d\u0430\u043b\u044c']"));
        softAssert.assertTrue(resolutionLabel.getText().contains("40") & resolutionLabel.getText().contains("50"), "TV resolution didn't match with requested");
        return this;
    }

}
