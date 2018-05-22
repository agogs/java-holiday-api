package com.github.agogs.holidayapi.api.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.agogs.holidayapi.api.APIConsumer;
import com.github.agogs.holidayapi.model.HolidayAPIResponse;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.github.agogs.holidayapi.api.testutil.MockResponse.*;

/**
 * Test the behaviour of the methods implemented in {@link HolidayAPIConsumer}.
 * <p>Each test method tests for a response code of the API. The responses for the following response codes are tested.</p>
 * <ul>
 *     <li>200</li>
 *     <li>400</li>
 *     <li>401</li>
 *     <li>402</li>
 *     <li>403</li>
 *     <li>429</li>
 *     <li>500</li>
 * </ul>
 */
public class HolidayAPIConsumerTest {

    @Mock
    private APIConsumer apiConsumer;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetHolidays_200() throws IOException {

        Mockito.doReturn(response200()).when(apiConsumer).getHolidays(null);

        HolidayAPIResponse response = apiConsumer.getHolidays(null);
        Assert.assertTrue(response != null, "Response is null");
        Assert.assertTrue(response.getStatus() == 200, "Response code is NOT 200");
        Assert.assertTrue(response.getError() == null, "error message is NOT null");

    }

    @Test
    public void testGetHolidays_400() throws IOException {
        Mockito.doReturn(response400()).when(apiConsumer).getHolidays(null);

        HolidayAPIResponse response = apiConsumer.getHolidays(null);
        Assert.assertTrue(response != null, "Response is null");
        Assert.assertTrue(response.getStatus() == 400, "Response code is NOT 400");
        Assert.assertTrue(response.getError() != null, "error message IS null");
    }

    @Test
    public void testGetHolidays_401() throws IOException {
        Mockito.doReturn(response401()).when(apiConsumer).getHolidays(null);

        HolidayAPIResponse response = apiConsumer.getHolidays(null);
        Assert.assertTrue(response != null, "Response is null");
        Assert.assertTrue(response.getStatus() == 401, "Response code is NOT 401");
        Assert.assertTrue(response.getError() != null, "error message IS null");
    }

    @Test
    public void testGetHolidays_402() throws IOException {
        Mockito.doReturn(response402()).when(apiConsumer).getHolidays(null);

        HolidayAPIResponse response = apiConsumer.getHolidays(null);
        Assert.assertTrue(response != null, "Response is null");
        Assert.assertTrue(response.getStatus() == 402, "Response code is NOT 402");
        Assert.assertTrue(response.getError() != null, "error message IS null");
    }

    @Test
    public void testGetHolidays_403() throws IOException {
        Mockito.doReturn(response403()).when(apiConsumer).getHolidays(null);

        HolidayAPIResponse response = apiConsumer.getHolidays(null);
        Assert.assertTrue(response != null, "Response is null");
        Assert.assertTrue(response.getStatus() == 403, "Response code is NOT 403");
        Assert.assertTrue(response.getError() != null, "error message IS null");
    }

    @Test
    public void testGetHolidays_429() throws IOException {
        Mockito.doReturn(response429()).when(apiConsumer).getHolidays(null);

        HolidayAPIResponse response = apiConsumer.getHolidays(null);
        Assert.assertTrue(response != null, "Response is null");
        Assert.assertTrue(response.getStatus() == 429, "Response code is NOT 429");
        Assert.assertTrue(response.getError() != null, "error message IS null");
    }

    @Test
    public void testGetHolidays_500() throws IOException {
        Mockito.doReturn(response500()).when(apiConsumer).getHolidays(null);

        HolidayAPIResponse response = apiConsumer.getHolidays(null);
        Assert.assertTrue(response != null, "Response is null");
        Assert.assertTrue(response.getStatus() == 500, "Response code is NOT 500");
        Assert.assertTrue(response.getError() != null, "error message IS null");
    }

    @Test
    public void testGetHolidaysAsString_400() throws IOException {
        Mockito.when(apiConsumer.getHolidaysAsString(null)).thenReturn(RESPONSE_400);
        String response = apiConsumer.getHolidaysAsString(null);

        Assert.assertTrue(response != null, "Response IS null");

        JsonNode jsonNode = mapper.readValue(response, JsonNode.class);
        int status = jsonNode.findValue("status").asInt();
        Assert.assertTrue(status == 400, "Response status is NOT 400");
    }

    @Test
    public void testGetHolidaysAsString_401() throws IOException {
        Mockito.when(apiConsumer.getHolidaysAsString(null)).thenReturn(RESPONSE_401);
        String response = apiConsumer.getHolidaysAsString(null);

        Assert.assertTrue(response != null, "Response IS null");

        JsonNode jsonNode = mapper.readValue(response, JsonNode.class);
        int status = jsonNode.findValue("status").asInt();
        Assert.assertTrue(status == 401, "Response status is NOT 401");
    }

    @Test
    public void testGetHolidaysAsString_403() throws IOException {
        Mockito.when(apiConsumer.getHolidaysAsString(null)).thenReturn(RESPONSE_403);
        String response = apiConsumer.getHolidaysAsString(null);

        Assert.assertTrue(response != null, "Response IS null");

        JsonNode jsonNode = mapper.readValue(response, JsonNode.class);
        int status = jsonNode.findValue("status").asInt();
        Assert.assertTrue(status == 403, "Response status is NOT 403");
    }

    @Test
    public void testGetHolidaysAsString_429() throws IOException {
        Mockito.when(apiConsumer.getHolidaysAsString(null)).thenReturn(RESPONSE_429);
        String response = apiConsumer.getHolidaysAsString(null);

        Assert.assertTrue(response != null, "Response IS null");

        JsonNode jsonNode = mapper.readValue(response, JsonNode.class);
        int status = jsonNode.findValue("status").asInt();
        Assert.assertTrue(status == 429, "Response status is NOT 429");
    }

    @Test
    public void testGetHolidaysAsString_200() throws IOException {
        Mockito.when(apiConsumer.getHolidaysAsString(null)).thenReturn(RESPONSE_200);
        String response = apiConsumer.getHolidaysAsString(null);

        Assert.assertTrue(response != null, "Response IS null");

        JsonNode jsonNode = mapper.readValue(response, JsonNode.class);
        int status = jsonNode.findValue("status").asInt();
        Assert.assertTrue(status == 200, "Response status is NOT 200");
    }

    @Test
    public void testGetHolidaysAsString_500() throws IOException {
        Mockito.when(apiConsumer.getHolidaysAsString(null)).thenReturn(RESPONSE_500);
        String response = apiConsumer.getHolidaysAsString(null);

        Assert.assertTrue(response != null, "Response IS null");

        JsonNode jsonNode = mapper.readValue(response, JsonNode.class);
        int status = jsonNode.findValue("status").asInt();
        Assert.assertTrue(status == 500, "Response status is NOT 500");
    }
}