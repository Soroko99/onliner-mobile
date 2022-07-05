package mobile.framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseElement{

    public Dropdown(By by, String name){
        super(by, name);
    }

    @Override
    protected String getElementType() {
        return getLoc("log.label");
    }

    public Dropdown(By by) {
        super(by);
    }

    public void selectByValue(String value){
        Select select = new Select(getElement());
        select.selectByValue(value);
    }


}
