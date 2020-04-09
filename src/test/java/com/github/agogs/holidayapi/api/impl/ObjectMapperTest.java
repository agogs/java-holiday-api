package com.github.agogs.holidayapi.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.github.agogs.holidayapi.model.HolidayAPIResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Tests the behavior of the object mapper for Holiday API responses.
 *
 * @author adrianpop
 */
public class ObjectMapperTest {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void mapValidResponse() throws Exception {
        String response = "{\"status\":200,\"holidays\":[{\"name\":\"May Day\",\"date\":\"2017-05-01\",\"observed\":\"2017-05-01\",\"public\":false}], \"warning\":\"Warning message\", " +
                "\"requests\":{\"used\":5,\"remaining\":9995, \"resets\":\"2020-05-01 00:00:0\"}}";

        HolidayAPIResponse mappedResponse = objectMapper.readValue(response, HolidayAPIResponse.class);

        assertNotNull(mappedResponse);
        assertEquals(Integer.valueOf(200), mappedResponse.getStatus());
        assertEquals(1, mappedResponse.getHolidays().size());
        assertEquals("May Day", mappedResponse.getHolidays().get(0).getName());
        assertEquals("2017-05-01", mappedResponse.getHolidays().get(0).getDate());
        assertEquals("2017-05-01", mappedResponse.getHolidays().get(0).getObserved());
        assertFalse(mappedResponse.getHolidays().get(0).getIsPublic());
        assertEquals("Warning message", mappedResponse.getWarning());
        assertEquals(5, mappedResponse.getRemainingRequests().getUsed());
        assertEquals(9995, mappedResponse.getRemainingRequests().getRemaining());
        assertEquals("2020-05-01 00:00:0", mappedResponse.getRemainingRequests().getResetDateTime());
    }

    @Test
    public void mapResponseCountryUuidWeekdayInHolidayIgnored() throws Exception {
        String response = "{\"status\":200,\"holidays\":[{\"name\":\"May Day\",\"date\":\"2017-05-01\",\"observed\":\"2017-05-01\",\"public\":false, " +
                "\"country\":\"RO\", \"uuid\":\"e84e6430-a789-4a49-9bbd-76edbf8cf34\", \"weekday\":{}}], \"warning\":\"Warning message\", \"requests\":{\"used\":5,\"remaining\":9995, " +
                "\"resets\":\"2020-05-01 00:00:0\"}}";

        HolidayAPIResponse mappedResponse = objectMapper.readValue(response, HolidayAPIResponse.class);

        assertNotNull(mappedResponse);
        assertEquals(1, mappedResponse.getHolidays().size());
    }

    @Test
    public void mapEmptyResponse() throws Exception {
        String response = "{}";

        HolidayAPIResponse mappedResponse = objectMapper.readValue(response, HolidayAPIResponse.class);

        assertNotNull(mappedResponse);
        assertNull(mappedResponse.getStatus());
        assertNull(mappedResponse.getWarning());
        assertNull(mappedResponse.getRemainingRequests());
        assertNull(mappedResponse.getStatus());
        assertNull(mappedResponse.getError());
    }

    @Test
    public void mapResponseNoHolidays() throws Exception {
        String response = "{\"status\":200, \"warning\":\"Warning message\", \"holidays\":[], \"requests\":{\"used\":5,\"remaining\":9995, " +
                "\"resets\":\"2020-05-01 00:00:0\"}}";

        HolidayAPIResponse mappedResponse = objectMapper.readValue(response, HolidayAPIResponse.class);

        assertNotNull(mappedResponse);
    }

    @Test
    public void mapResponseUnexpectedFieldIgnored() throws Exception {
        String response = "{\"status\":200,\"holidays\":[{\"name\":\"May Day\",\"date\":\"2017-05-01\",\"observed\":\"2017-05-01\",\"public\":false, " +
                "\"country\":\"RO\", \"uuid\":\"e84e6430-a789-4a49-9bbd-76edbf8cf34\"}], \"warning\":\"Warning message\", \"requests\":{\"used\":5,\"remaining\":9995, " +
                "\"resets\":\"2020-05-01 00:00:0\"}, \"unexpectedField\":\"value\"}";

        HolidayAPIResponse mappedResponse = objectMapper.readValue(response, HolidayAPIResponse.class);

        assertNotNull(mappedResponse);
    }

    @Test
    public void mapResponseUnexpectedFieldRemainingRequestsIgnored() throws Exception {
        String response = "{\"status\":200,\"holidays\":[{\"name\":\"May Day\",\"date\":\"2017-05-01\",\"observed\":\"2017-05-01\",\"public\":false, " +
                "\"country\":\"RO\", \"uuid\":\"e84e6430-a789-4a49-9bbd-76edbf8cf34\"}], \"warning\":\"Warning message\", \"requests\":{\"used\":5,\"remaining\":9995, " +
                "\"resets\":\"2020-05-01 00:00:0\", \"unexpectedField\":\"value\"}}";

        HolidayAPIResponse mappedResponse = objectMapper.readValue(response, HolidayAPIResponse.class);

        assertNotNull(mappedResponse);
    }

    @Test(expected = UnrecognizedPropertyException.class)
    public void mapResponseUnexpectedFieldHolidayThrowsException() throws Exception {
        String response = "{\"status\":200,\"holidays\":[{\"name\":\"May Day\",\"date\":\"2017-05-01\",\"observed\":\"2017-05-01\",\"public\":false, " +
                "\"country\":\"RO\", \"uuid\":\"e84e6430-a789-4a49-9bbd-76edbf8cf34\", \"unexpectedField\":\"value\"}], \"warning\":\"Warning message\", \"requests\":{\"used\":5,\"remaining\":9995, " +
                "\"resets\":\"2020-05-01 00:00:0\"}}";

        HolidayAPIResponse mappedResponse = objectMapper.readValue(response, HolidayAPIResponse.class);
    }
}
