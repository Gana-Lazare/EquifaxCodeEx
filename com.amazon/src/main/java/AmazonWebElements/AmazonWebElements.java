package AmazonWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonWebElements {

    @FindBy(id = "twotabsearchtextbox")
    public static WebElement searchbox;
    @FindBy(xpath = "//*[@id=\"search\"]//*[@data-index=1]//a[@class='a-link-normal s-no-outline']")
    public static WebElement firstItemIntheListofResult;
    @FindBy(xpath = "//*[@id=\"newBuyBoxPrice\"]")
    public static WebElement priceElement;
    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    public static WebElement addToCartWebElement;
    @FindBy(xpath = "//*[@id='huc-v2-order-row-center']//*[@class='a-color-price hlb-price a-inline-block a-text-bold']")
    public static WebElement cartSubTotalWebElement;
    @FindBy(xpath = "//*[@id=\"hlb-ptc-btn-native\"]")
    public static WebElement proceedToCheckOutWebElement;
    @FindBy(xpath = "//*[@id='huc-v2-order-row-center']//*[@class='a-color-price hlb-price a-inline-block a-text-bold']")
    public static WebElement cartSubPoceedTotalWebElement;



}
