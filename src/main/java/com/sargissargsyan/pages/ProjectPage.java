package com.sargissargsyan.pages;

import com.sargissargsyan.base.BasePage;
import com.google.gson.JsonObject;
import com.sargissargsyan.models.Project;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */
public class ProjectPage extends BasePage<ProjectPage> {
    private Project project;
    public ProjectPage(Project project) {
        this.project = project;
    }

    @Override
    public ProjectPage open() {
        return openPage();
    }

    @Override
    public ProjectPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/project/" + project.getSlug();
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
