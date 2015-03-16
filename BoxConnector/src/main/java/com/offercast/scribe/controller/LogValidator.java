package com.offercast.scribe.controller;

import com.offercast.scribe.utility.EventGenerator;
import com.offercast.scribe.utility.LogImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.util.Password;

import java.util.logging.Logger;

@Controller
public class LogValidator {

    private static final Logger LOGGER = Logger.getLogger("logfile");

    @Autowired
     private EventGenerator eventGenerator;

    @Autowired
    private LogImporter logImporter;

    @RequestMapping(value = {"/home","/"}, method = RequestMethod.GET)
    public String eventGenerator(Model uiModel) {
        uiModel.addAttribute("message", "Hello Spring MVC Framework!");
        return "EventGenerator";
    }


    @RequestMapping(value = "/LogImporter", method = RequestMethod.POST)
    public String logImporter(@RequestParam(value ="url",required =true ) String URL,Model uiModel) {
        eventGenerator.eventImporter(URL);
        return "LogImporter";
    }


    @RequestMapping(value = "/Parser", method = RequestMethod.POST)
    public String parser(
            @RequestParam(value ="uname",required =true ) String userName,
            @RequestParam(value ="mip",required =true ) String ip,
            @RequestParam(value ="pwd",required =true ) Password password,
            @RequestParam(value ="path1",required =true ) String Path1,
            @RequestParam(value ="path2",required =true ) String Path2,
            Model uiModel
    ) {

         logImporter.logTracker(userName,ip,password,Path1,Path2);
        return "Parser";
    }

    @RequestMapping(value = "/validator", method = RequestMethod.POST)
    public String validator() {

        return "Validator";
    }




}