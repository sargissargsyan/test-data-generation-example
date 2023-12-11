package com.sargissargsyan.pages;

import com.sargissargsyan.base.BasePage;
import com.sargissargsyan.base.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */

public class ProjectBacklogPage extends BasePage<ProjectBacklogPage> {
    @FindBy(css = ".new-us [variant='primary']")
    private WebElement newStoryButton;

    @Override
    public ProjectBacklogPage open() {
        return openPage();
    }

    @Override
    public ProjectBacklogPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void clickNewStoryButton() {
        newStoryButton.click();
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public String getCurrentProjectId() {
        return DriverHelper.get().getDriver().getCurrentUrl().split("/")[4];
    }
}
