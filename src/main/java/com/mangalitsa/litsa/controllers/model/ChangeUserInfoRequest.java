package com.mangalitsa.litsa.controllers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChangeUserInfoRequest(
        @JsonProperty(value = "display_name")
        String displayName
) { }
