package com.offercast.scribe.utility;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: 312277
 * Date: 3/18/15
 * Time: 7:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Validator {

    @Autowired
    private Parser parser;

    private static final Logger LOGGER = Logger.getLogger("logfile");

    public String compare(String key) throws JSONException, IOException {
        JSONObject actualData =  (JSONObject)parser.pipAttempt() ;

      // String actualResult = actualData.get("serverName").toString();
       String actualResult = actualData.get(key).toString();
        LOGGER.info("ServerName: " + actualResult);

       return actualResult;
    }
    
    


}
