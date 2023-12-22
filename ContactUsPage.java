package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class ContactUsPage extends BasePage {

    @FindBy(name = "name")
    WebElement nameField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "subject")
    WebElement subjectField;

    @FindBy(name = "message")
    WebElement messageField;

    @FindBy(name = "upload_file")
    WebElement uploadFileButton;

    @FindBy(name = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMessage;


    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ContactUsPage fillUpGetInTouchForm(String name, String email, String subject, String message) {
        setText(name, nameField);
        setText(email, emailField);
        setText(subject, subjectField);
        setText(message, messageField);
        return this;
    }

    public ContactUsPage uploadFile(String fileName) {
        URL url = getClass().getClassLoader().getResource(fileName);
        if (url == null) throw new IllegalArgumentException("File not found!");
        File file;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        uploadFileButton.sendKeys(file.getAbsolutePath());
        return this;
    }

    public ContactUsPage clickSubmitButton() {
        scrollPageToElement(submitButton);
        clickOnElement(submitButton);
        return this;
    }

    public boolean successMessageIsDisplayed() {
        return successMessage.isDisplayed();
    }
}
