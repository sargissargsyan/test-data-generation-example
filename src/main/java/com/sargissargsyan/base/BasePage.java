package com.sargissargsyan.base;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */
public abstract class  BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    protected static final String BASE_URL = "http://localhost:9000";

    public BasePage() {
    }

    @Override
    protected void load() {
        DriverHelper.get().getDriver().get(BASE_URL + getUrl());
    }

    protected T openPage() {
        PageFactory.initElements(DriverHelper.get().getDriver(), this);
        load();
        return get();
    }

    public abstract T open();

    public abstract T init();

    protected T initPage() {
        PageFactory.initElements(DriverHelper.get().getDriver(), this);
        return get();
    }

    public <T extends BasePage> T initElements() {
        PageFactory.initElements(DriverHelper.get().getDriver(), this);
        return (T) this;
    }


    public abstract String getUrl();



}
