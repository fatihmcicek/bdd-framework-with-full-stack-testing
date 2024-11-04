package com.automation.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ContactPage extends BasePage {

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(css = "h2.title")
    private WebElement getInTouchText;

    @FindBy(css = "input[data-qa='name']")
    private WebElement nameInput;

    @FindBy(css = "input[data-qa='email']")
    private WebElement emailInput;

    @FindBy(css = "input[data-qa='subject']")
    private WebElement subjectInput;

    @FindBy(css = "textarea[data-qa='message']")
    private WebElement messageInput;

    @FindBy(css = "input[data-qa='submit-button']")
    private WebElement submitButton;

    @FindBy(css = ".status.alert.alert-success")
    private WebElement successMessage;

    @FindBy(css = "a[class='btn btn-success'] i[class='fa fa-home']")
    private WebElement homeButton;

    public void clickContactUsButton() {
        log.info("Clicking Contact Us button");
        click(contactUsButton);
    }

    public String getInTouchText() {
        return getText(getInTouchText);
    }

    public void enterName(String name) {
        log.info("Entering contact name: {}", name);
        sendKeys(nameInput, name);
    }

    public void enterEmail(String email) {
        log.info("Entering contact email: {}", email);
        sendKeys(emailInput, email);
    }

    public void enterSubject(String subject) {
        log.info("Entering contact subject: {}", subject);
        sendKeys(subjectInput, subject);
    }

    public void enterMessage(String message) {
        log.info("Entering contact message");
        sendKeys(messageInput, message);
    }

    public void clickSubmit() {
        log.info("Clicking Submit button");
        click(submitButton);
    }

    public void acceptAlert() {
        try {
            Alert alert = wait.until(d -> d.switchTo().alert());
            log.info("Accepting alert");
            alert.accept();
        } catch (Exception e) {
            log.error("Error accepting alert: {}", e.getMessage());
            throw e;
        }
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public void clickHomeButton() {
        log.info("Clicking Home button");
        click(homeButton);
    }
}