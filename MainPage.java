package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(css = "[href='/contact_us']")
    WebElement contactUsButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ContactUsPage openContactUsPage() {
        clickOnElement(contactUsButton);
        return new ContactUsPage(driver);
    }
}
