package com.offercast.scribe.utility;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: 312277
 * Date: 3/18/15
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Parser {

    @Autowired
     private Validator validator ;

    private static final Logger LOGGER = Logger.getLogger("logfile");
    String[] pipAttempt;
    String actualResult;
    JSONObject json;


    public void splitter(String eventType) throws IOException {
        LOGGER.info(eventType) ;

        File file = new File("D:\\Scribe\\scribe.log");
        //File file = new File("D:\\Scribe\\scribe.log");
        List<String> lines = FileUtils.readLines(file);
        Collections.sort(lines);
        for (String line : lines) {

            if (line.contains("\"eventType\":\"PIPOutcome\"")) {
                LOGGER.info("PIPAttempt line:" + line);


                // pipAttempt= String.valueOf(line.startsWith("{"));
                pipAttempt = line.split("scribe: ");
               LOGGER.info(" loggg" + pipAttempt[1]);


            }
    }
}
   /* public void pipAttemptEvent() throws IOException, JSONException {

        JSONObject jsonObj = new JSONObject(pipAttempt[1]);
        LOGGER.info(String.valueOf(jsonObj));

        validator.compare(jsonObj);
    }*/
    public Object pipAttempt() throws IOException, JSONException {

        JSONObject jsonObj = new JSONObject(pipAttempt[1]);
        LOGGER.info(String.valueOf(jsonObj));
        return jsonObj;

    }


}



