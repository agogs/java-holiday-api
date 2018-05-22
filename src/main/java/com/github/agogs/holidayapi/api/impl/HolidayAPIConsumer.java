package com.github.agogs.holidayapi.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.agogs.holidayapi.api.APIConsumer;
import com.github.agogs.holidayapi.model.HolidayAPIResponse;
import com.github.agogs.holidayapi.model.QueryParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * This class implements the methods defines in the interface {@link APIConsumer}.
 *
 * @author rakesh
 */
public class HolidayAPIConsumer implements APIConsumer {

    private static final Logger log = LogManager.getLogger(HolidayAPIConsumer.class);

    //store the base url in a variable for later use
    private String baseURl;
    //to make a https connection
    private URLConnection connection;

    /**
     * Parameterized constructor
     *
     * @param baseURl - the base url of the API
     */
    public HolidayAPIConsumer(String baseURl) {
        log.debug("instantiating with base url : {}", baseURl);
        this.baseURl = baseURl;
    }

    /**
     * Call the holidays api and send back the response encapsulatd in a {@link HolidayAPIResponse} object.
     * This is a wrapper method that depends on {@link HolidayAPIConsumer#getHolidaysAsString(QueryParams)}
     * to get the json string and then map it to a java object
     *
     * @param queryParams - the params encapsulated in an object
     * @return an object representation of the response
     * @throws IOException - when there are connection issues or the URL is malformed
     */
    @Override
    public HolidayAPIResponse getHolidays(QueryParams queryParams) throws IOException {

        log.info("get holidays API call with query params {}", queryParams.toString());

        //get the response string
        String json = getHolidaysAsString(queryParams);

        log.info("got json string response");
        log.debug("got json string response : {}", json);

        //ObjectMapper to map the json string to a java object
        ObjectMapper mapper = new ObjectMapper();

        HolidayAPIResponse response = mapper.readValue(json, HolidayAPIResponse.class);

        log.info("returning response");
        log.debug("returning response : {}", response);
        //map and return the response encapsulated in HolidayAPIResponse object
        return response;
    }

    /**
     * Call the holidays api and send back the response as a json string
     *
     * @param queryParams - the params encapsulated in an object
     * @return an object representation of the response
     * @throws IOException - when there are connection issues or the URL is malformed
     */
    @Override
    public String getHolidaysAsString(QueryParams queryParams) throws IOException {

        log.info("get holidays API call with query params {}", queryParams.toString());

        log.info("constructing url with query param string");
        //construct the complete url
        URL url = new URL(this.baseURl + "?" + queryParams.queryString());

        log.info("connecting to API endpoint");
        //attempt the https connection
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.connect();

        //uninitialized objects for later use
        StringBuilder builder = new StringBuilder();
        BufferedReader bufferedReader = null;
        String line = null;

        int responseCode = connection.getResponseCode();
        log.info("response code : {}", responseCode);

        //check for the response code
        if (responseCode == 200) {
            log.info("preparing to read content from inputstream");
            //read from inputstream if response code is 200
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            log.info("preparing to read content from errorstream");
            //read from errorstream when the response code is not 200
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        log.info("reading response content");
        //read the contents of the response
        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line);
        }
        bufferedReader.close();
        String response = builder.toString();

        log.info("returning response string {}", response);
        //return the response
        return response;
    }
}
