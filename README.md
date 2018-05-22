# java-holiday-api

![JDk8](https://camo.githubusercontent.com/96ab5485a7f1b4b9aa2b2fae1113ba9c9346bfbc/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a444b2d312e382d79656c6c6f772e737667) [![Build Status](https://travis-ci.org/agogs/java-holiday-api.svg?branch=master)](https://travis-ci.org/agogs/java-holiday-api)

A java client library for https://holidayapi.com/

The API provider doesn't have a java client library, so I developed one and it is very simple to use. Lookup https://holidayapi.com/ for required and optional parameters

**Usage:**

```
        //create a consumer
        APIConsumer consumer = new HolidayAPIConsumer("https://holidayapi.com/v1/holidays");

        //generate the wuery parameters
        QueryParams params = new QueryParams();
        params.key("your_api_key")
                .month(1)
                .country(QueryParams.Country.INDIA)
                .year(2018)
                //JSON is the default format
                .format(QueryParams.Format.XML)
                .pretty(true);

        try {
            //make the API call
            HolidayAPIResponse response = consumer.getHolidays(params);
            
            //check the status code of the API call
            int status = response.getStatus();
            if (status != 200) {

                //handle error scenario

            } else {

                //handle success scenario

                List<Holiday> holidays = response.getHolidays();
                for (Holiday h : holidays) {
                    //do your thing
                }
            }
        } catch (IOException e) {
            //handle exception
        }
```
