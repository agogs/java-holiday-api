package com.github.agogs.holidayapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * This class represents the complete JSON response of the API <code>/v1/holidays</code>
 */
@JsonPropertyOrder({
        "status",
        "error",
        "warning",
        "requests",
        "holidays"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
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

    @JsonProperty("warning")
    @Getter
    @Setter
    private String warning;

    @JsonProperty("requests")
    @Getter
    @Setter
    private RemainingRequests remainingRequests;

    @Override
    public String toString() {
        return "HolidayResponse{" +
                "status=" + status +
                ", holidays=" + holidays +
                ", error='" + (error == null ? "" : error) + '\'' +
                ", warning='" + (warning == null ? "" : warning) + '\'' +
                ", requests='" + remainingRequests +
                '}';
    }
}

