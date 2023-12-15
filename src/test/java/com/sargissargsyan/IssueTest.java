package com.sargissargsyan;

import com.sargissargsyan.api.BaseService;
import com.sargissargsyan.api.IssueService;
import com.sargissargsyan.api.ProjectService;
import com.sargissargsyan.models.Issue;
import com.sargissargsyan.models.Project;
import com.sargissargsyan.models.User;
import com.sargissargsyan.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sargissargsyan.utils.TestUtils;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */
public class IssueTest extends SeleniumBase {
    private final String password = "Armenia2022";
    private User newUser;

    @BeforeMethod
    public void setup() {
        String name = TestUtils.randomString(5);
        String username = TestUtils.randomString(7);
        String email = TestUtils.randomEmail(username);
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

    @Test
    public void issuePageNewStatus() {
        LoginPage loginPage = new LoginPage().open();
        loginPage.login(newUser.getUsername(), password);

        ProjectsPage projectsPage = new ProjectsPage().open();
        NewProjectPage newProjectPage = projectsPage.clickNewProjectButton();
        NewScrumProjectPage newScrumProjectPage = newProjectPage.selectScrum();
        newScrumProjectPage.typeProjectName("project name x");
        newScrumProjectPage.typeProjectDescription("project name x");
        ProjectBacklogPage projectBacklogPage = newScrumProjectPage.clickCreateProject();
        String createdProjectId = projectBacklogPage.getCurrentProjectId();

        IssuesPage issuesPage = new IssuesPage(createdProjectId).open();
        NewIssuePage newIssuePage = issuesPage.clickNewIssueButton();

        newIssuePage.typeSubject("Testing Issue Subject " + TestUtils.randomString(5));
        newIssuePage.clickCreate();

        //do checks
    }

    @Test
    public void issuePageNewStatusWithData() {
        Project newProject = ProjectService.createProject();
        Issue newIssue = IssueService.createIssue(newProject);
        login(newUser.getEmail(), password);
        IssuePage issuePage = new IssuePage(newIssue).open();

        //do checks
    }


}
