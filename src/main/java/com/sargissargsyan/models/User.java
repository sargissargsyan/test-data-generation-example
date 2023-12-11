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
public class User {

    @SerializedName("id")
    private Integer id;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("full_name_display")
    private String fullNameDisplay;

    @SerializedName("is_active")
    private Boolean isActive;

    @SerializedName("email")
    private String email;

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("verified_email")
    private Boolean verifiedEmail;

    @SerializedName("auth_token")
    private String authToken;

    @SerializedName("accepted_terms")
    private Boolean acceptedTerms;

    @SerializedName("type")
    private String type;

}
