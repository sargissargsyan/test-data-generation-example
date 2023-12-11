package com.sargissargsyan.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sargissargsyan.models.Project;
import com.sargissargsyan.utils.Parser;
import com.sargissargsyan.utils.TestUtils;
import okhttp3.Response;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */
public class ProjectService extends BaseService {
    public static Project createProject(Project project) {
        Response response = post("/projects", project);
        String jsonString = getJsonStringFromResponse(response);
        return Parser.parse(jsonString, Project.class);
    }

    public static Project createProject() {
        Project project = Project.builder()
                .name("Test Project " + TestUtils.randomString(5))
                .description("Test Project description" + TestUtils.randomString(5))
                .creationTemplate(1)
                .isPrivate(false)
                .build();
        return createProject(project);
    }

    public static Project editProject(Project updatedProject) {
        Response response =  patch("/projects/" + updatedProject.getId(), updatedProject);
        String jsonString = getJsonStringFromResponse(response);
        return Parser.parse(jsonString, Project.class);
    }

    public static void deleteProject(Project project) {
        delete("/projects/", project.getId());
    }
}
