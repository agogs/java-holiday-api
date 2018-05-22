package com.github.agogs.holidayapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * This class represents the complete JSON response of the API <code>/v1/holidays</code>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "error",
        "holidays"
})
public class HolidayAPIResponse {

    @JsonProperty("status")
    @Getter
    @Setter
    private Integer status;

    @JsonProperty("holidays")
    @Getter
    @Setter
    private List<Holiday> holidays;

    @JsonProperty("error")
    @Getter
    @Setter
    private String error;

    @Override
    public String toString() {
        return "HolidayResponse{" +
                "status=" + status +
                ", holidays=" + holidays +
                ", error='" + error + '\'' +
                '}';
    }
}

