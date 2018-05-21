package com.github.agogs.holidayapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "date",
        "observed",
        "public"
})
public class Holiday {

    @JsonProperty("name")
    @Getter
    @Setter
    public String name;

    @JsonProperty("date")
    @Getter
    @Setter
    public String date;

    @JsonProperty("observed")
    @Getter
    @Setter
    public String observed;

    @JsonProperty("public")
    @Getter
    @Setter
    public Boolean _public;

}
