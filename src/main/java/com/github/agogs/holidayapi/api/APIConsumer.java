package com.github.agogs.holidayapi.api;

import com.github.agogs.holidayapi.model.HolidayAPIResponse;
import com.github.agogs.holidayapi.model.QueryParams;

import java.io.IOException;

/**
 * This interface defines methods to consume the Holidays API
 *
 * @author rakesh
 */
public interface APIConsumer {

    /**
     * Call the holidays api and send back the response encapsulatd in a {@link HolidayAPIResponse} object
     *
     * @param queryParams - the params encapsulated in an object
     * @return an object representation of the response
     * @throws IOException - when there are connection issues or the URL is malformed
     */
    HolidayAPIResponse getHolidays(QueryParams queryParams) throws IOException;

    /**
     * Call the holidays api and send back the response as a json string
     *
     * @param queryParams - the params encapsulated in an object
     * @return an object representation of the response
     * @throws IOException - when there are connection issues or the URL is malformed
     */
    String getHolidaysAsString(QueryParams queryParams) throws IOException;
}
