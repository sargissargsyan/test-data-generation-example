package com.sargissargsyan.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sargissargsyan.models.Issue;
import com.sargissargsyan.models.Project;
import com.sargissargsyan.utils.Parser;
import com.sargissargsyan.utils.TestUtils;
import okhttp3.Response;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */
public class IssueService extends BaseService {

    public static Issue createIssue(Project project) {
        Issue issue = Issue.builder()
                .subject("Issue subject " + TestUtils.randomString(5))
                .project(project.getId())
                .build();
        Response response = post("/issues", issue);
        String jsonString = getJsonStringFromResponse(response);
        return Parser.parse(jsonString, Issue.class);
    }
}
