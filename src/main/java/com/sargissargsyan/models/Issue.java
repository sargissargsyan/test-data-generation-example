package com.sargissargsyan.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue{

    @SerializedName("id")
    private Integer id;

    @SerializedName("ref")
    private Integer ref;

    @SerializedName("project")
    private Integer project;

    @SerializedName("project_extra_info")
    private HashMap<String, String> projectExtraInfo;

    @SerializedName("subject")
    private String subject;

    @SerializedName("description")
    private String description;

    @SerializedName("status")
    private Integer status;

    @SerializedName("status_extra_info")
    private HashMap<String, String> statusExtraInfo;

    @SerializedName("assigned_to")
    private Integer assignedTo;

    @SerializedName("assigned_to_extra_info")
    private HashMap<String, String> assignedToExtraInfo;

    @SerializedName("severity")
    private Integer severity;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("type")
    private Integer type;
}
