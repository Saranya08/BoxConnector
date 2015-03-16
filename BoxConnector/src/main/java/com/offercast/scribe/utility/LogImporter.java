package com.offercast.scribe.utility;

import org.springframework.stereotype.Component;
import sun.security.util.Password;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: 312277
 * Date: 3/16/15
 * Time: 6:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class LogImporter {

    private static final Logger LOGGER = Logger.getLogger("logfile");

    public void logTracker(String userName,String ip,Password password,String Path1,String Path2) {
        LOGGER.info(userName+ip+password+Path1+Path2) ;
        try {
            Runtime process = Runtime.getRuntime();
            LOGGER.info("Process Execution BEGIN");

            Process pr = process.exec("pscp -pw"+" "+userName+" "+password+"@"+ip+":"+Path1+" "+Path2);
            //  Process pr = process.exec("pscp -pw webadmin webadmin@10.90.130.170:/apps/tomcat7.0.25/logs/scribe.log     D:\\Scribe\\");

            LOGGER.info("Process Execution END");

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String liner = null;

            while ((liner = input.readLine()) != null) {
                LOGGER.info(liner);
            }

            int exitVal = pr.waitFor();

        }
        catch (Exception e)
        {
            LOGGER.info(e.toString());
            e.printStackTrace();
        }
    }
}
