package com.sargissargsyan;

import com.sargissargsyan.api.BaseService;
import com.sargissargsyan.api.ProjectService;
import com.google.gson.JsonObject;
import com.sargissargsyan.models.Project;
import com.sargissargsyan.models.User;
import com.sargissargsyan.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sargissargsyan.utils.TestUtils;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */
public class ProjectTest extends SeleniumBase {
    private String name;
    private String username;
    private String email;
    private String password = "Armenia2024";
    private User newUser;
    private Project newProject;

    @BeforeMethod
    public void setup() {
        name = TestUtils.randomString(5);
        username = TestUtils.randomString(7);
        email = TestUtils.randomEmail(username);
        newUser = User.builder()
                .fullName(name)
                .username(username)
                .email(email)
                .password(password)
                .acceptedTerms(true)
                .type("public")
                .build();
        newUser = BaseService.register(newUser);
    }

    @AfterMethod
    public void cleanup() {
        if (newProject != null) {
            ProjectService.deleteProject(newProject);
        }
    }


    @Test
    public void projectPage() {
        LoginPage loginPage = new LoginPage().open();
        loginPage.login(email, password);

        ProjectsPage projectsPage = new ProjectsPage().open();
        NewProjectPage newProjectPage = projectsPage.clickNewProjectButton();
        NewScrumProjectPage newScrumProjectPage = newProjectPage.selectScrum();
        newScrumProjectPage.typeProjectName("project name x");
        newScrumProjectPage.typeProjectDescription("project name x");
        ProjectBacklogPage projectBacklogPage = newScrumProjectPage.clickCreateProject();

        //do checks
    }

    @Test
    public void projectPageWithData() {
        Project newProject = ProjectService.createProject();
        login(newUser.getEmail(), password);
        ProjectPage projectsPage = new ProjectPage(newProject).open();

        //do checks
    }
}
