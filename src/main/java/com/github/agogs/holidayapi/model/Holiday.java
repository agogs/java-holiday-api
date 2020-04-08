package com.github.agogs.holidayapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "name",
        "date",
        "observed",
        "public"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"country", "uuid", "weekday"})
public class Holiday {

    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    @JsonProperty("date")
    @Getter
    @Setter
    private String date;

    @JsonProperty("observed")
    @Getter
    @Setter
    private String observed;

    @JsonProperty("public")
    @Getter
    @Setter
    private Boolean isPublic;

}
