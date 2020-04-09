package com.github.agogs.holidayapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * Model class representing the remaining requests for all Holiday API subscription plans (10k requests per month for the free plan and 1M for the paid plans).
 *
 */
@JsonPropertyOrder({
        "used",
        "remaining",
        "resets"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemainingRequests {

    @JsonProperty("used")
    @Getter
    @Setter
    private int used;

    @JsonProperty("remaining")
    @Getter
    @Setter
    private int remaining;

    @JsonProperty("resets")
    @Getter
    @Setter
    private String resetDateTime;

    @Override
    public String toString() {
        return "RemainingRequests{" +
                "used=" + used +
                ", remaining=" + remaining +
                ", resetDateTime='" + (resetDateTime == null ? "" : resetDateTime) + '\'' +
                '}';
    }
}