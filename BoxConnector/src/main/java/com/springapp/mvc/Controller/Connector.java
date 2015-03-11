package com.springapp.mvc.Controller;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by 441692 on 3/10/2015.
 */
public class Connector {
    String[] pipAttempt;
    String actualResult;
    JSONObject json;

    private static final Logger LOGGER = Logger.getLogger("logfile");

    protected void boxConector() {
        try {
            Runtime process = Runtime.getRuntime();
            LOGGER.info("Process Execution BEGIN");
            Process pr = process.exec("pscp -pw webadmin webadmin@10.90.130.170:/apps/tomcat7.0.25/logs/scribe.log D:\\Scribe\\");
            LOGGER.info("Process Execution END");
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String liner = null;

            while ((liner = input.readLine()) != null) {
                LOGGER.info(liner);
            }

            int exitVal = pr.waitFor();
            LOGGER.info("Exited with error code " + exitVal);
            //getting specify contents

            File file = new File("D:\\Scribe\\scribe.log");
            List<String> lines = FileUtils.readLines(file);
            Collections.sort(lines);
            for (String line : lines) {
                if (line.contains("\"eventType\":\"PIPOutcome\"")) {
                    LOGGER.info("PIPOutcome line:" + line);
                }
                if (line.contains("\"eventType\":\"PIPAttempt\"")) {
                    LOGGER.info("PIPAttempt line:" + line);


                    // pipAttempt= String.valueOf(line.startsWith("{"));
                    pipAttempt = line.split("scribe: ");
                    LOGGER.info(" loggg" + pipAttempt[1]);


                }

            }

        } catch (Exception e) {
            LOGGER.info(e.toString());
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws IOException, JSONException, InterruptedException {
        Connector key = new Connector();
        key.boxConector();
        key.pipAttemptEvent();
        key.scribeTester();
    }


    public Object pipAttemptEvent() throws IOException, JSONException {

        JSONObject jsonObj = new JSONObject(pipAttempt[1]);
        LOGGER.info(String.valueOf(jsonObj));
        return jsonObj;

    }

    private void scribeTester() throws IOException, InterruptedException, JSONException {
        json = (JSONObject) pipAttemptEvent();
        actualResult = json.get("serverName").toString();
        LOGGER.info("ServerName: " + actualResult);
        actualResult = json.getJSONObject("app").get("funnelID").toString();
        LOGGER.info("funnelID: " + actualResult);
    }

}
