package com.sargissargsyan.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("slug")
    private String slug;

    @SerializedName("description")
    private String description;

    @SerializedName("owner")
    private User owner;

    @SerializedName("members")
    private User[] members;

    @SerializedName("creation_template")
    private Integer creationTemplate;

    @SerializedName("is_private")
    private Boolean isPrivate;
}
