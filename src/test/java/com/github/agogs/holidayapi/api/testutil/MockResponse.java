package com.github.agogs.holidayapi.api.testutil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.agogs.holidayapi.model.HolidayAPIResponse;

import java.io.IOException;

/**
 * This util class consists of mock API responses for each status code.
 *
 */
public abstract class MockResponse {

    private static ObjectMapper mapper = new ObjectMapper();

    //Only the status code is important, the error message is irrelevant for testing
    public static String RESPONSE_200 = "{\"status\":200,\"holidays\":[{\"name\":\"May Day\",\"date\":\"2017-05-01\",\"observed\":\"2017-05-01\",\"public\":false}]}";
    public static String RESPONSE_400 = "{\"status\":400,\"error\":\"Something went wrong on your end\"}";
    public static String RESPONSE_401 = "{\"status\":401,\"error\":\"Unauthorized\"}";
    public static String RESPONSE_402 = "{\"status\":402,\"error\":\"Payment required\"}";
    public static String RESPONSE_403 = "{\"status\":403,\"error\":\"Forbidden\"}";
    public static String RESPONSE_429 = "{\"status\":429,\"error\":\"Exceeded free quota\"}";
    public static String RESPONSE_500 = "{\"status\":500,\"error\":\"Internal server error\"}";

    public static HolidayAPIResponse response200() throws IOException {
        return mapper.readValue(RESPONSE_200, HolidayAPIResponse.class);
    }

    public static HolidayAPIResponse response400() throws IOException {
        return mapper.readValue(RESPONSE_400, HolidayAPIResponse.class);
    }

    public static HolidayAPIResponse response401() throws IOException {
        return mapper.readValue(RESPONSE_401, HolidayAPIResponse.class);
    }

    public static HolidayAPIResponse response402() throws IOException {
        return mapper.readValue(RESPONSE_402, HolidayAPIResponse.class);
    }

    public static HolidayAPIResponse response403() throws IOException {
        return mapper.readValue(RESPONSE_403, HolidayAPIResponse.class);
    }

    public static HolidayAPIResponse response429() throws IOException {
        return mapper.readValue(RESPONSE_429, HolidayAPIResponse.class);
    }

    public static HolidayAPIResponse response500() throws IOException {
        return mapper.readValue(RESPONSE_500, HolidayAPIResponse.class);
    }

}
