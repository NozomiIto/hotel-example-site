package starhotel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class MyPage {

  private WebDriver driver;

  public MyPage(WebDriver driver) {
    this.driver = driver;
    if (!this.driver.getTitle().equals("マイページ | STAR HOTEL - テスト自動化デモサイト")) {
      throw new IllegalStateException("現在のページが間違っています: " + this.driver.getTitle());
    }
  }

  public PlansPage goToPlansPage() {
    var planLink = driver.findElement(By.linkText("宿泊予約"));
    planLink.click();
    return new PlansPage(driver);
  }

  public IconPage goToIconPage() {
    var iconLink = driver.findElement(By.id("icon-link"));
    iconLink.click();
    return new IconPage(driver);
  }

  public String getHeaderText() {
    var header = driver.findElement(By.tagName("h2"));
    return header.getText();
  }

  public String getEmail() {
    var email = driver.findElement(By.id("email"));
    return email.getText();
  }

  public String getUsername() {
    var username = driver.findElement(By.id("username"));
    return username.getText();
  }

  public String getRank() {
    var rank = driver.findElement(By.id("rank"));
    return rank.getText();
  }

  public String getAddress() {
    var address = driver.findElement(By.id("address"));
    return address.getText();
  }

  public String getTel() {
    var tel = driver.findElement(By.id("tel"));
    return tel.getText();
  }

  public String getGender() {
    var gender = driver.findElement(By.id("gender"));
    return gender.getText();
  }

  public String getBirthday() {
    var birthday = driver.findElement(By.id("birthday"));
    return birthday.getText();
  }

  public String getNotification() {
    var notification = driver.findElement(By.id("notification"));
    return notification.getText();
  }

  public boolean existsIconImage() {
    var images = driver.findElements(By.cssSelector("#icon-holder > img"));
    return !images.isEmpty();
  }

  public int getIconImageWidth() {
    var image = driver.findElement(By.cssSelector("#icon-holder > img"));
    return Integer.parseInt(image.getAttribute("width"));
  }

  public Color getIconImageBorder() {
    var image = driver.findElement(By.cssSelector("#icon-holder > img"));
    String backgroundColor = image.getCssValue("backgroundColor");
    if (backgroundColor.isEmpty()) {
      backgroundColor = image.getCssValue("background-color");
    }
    return Color.fromString(backgroundColor);
  }

  public void deleteUser() {
    var deleteButton = driver.findElement(By.cssSelector("#delete-form > button"));
    deleteButton.click();
  }
}
