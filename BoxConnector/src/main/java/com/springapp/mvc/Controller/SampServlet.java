package com.springapp.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Logger;
/**
 * Created by 441692 on 3/9/2015.
 */
@WebServlet(name = "SampServlet")
public class SampServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger("logfile");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        String mcip=request.getParameter("mip");
        String pass=request.getParameter("pwd");
        String path1=request.getParameter("path1");
        String path2=request.getParameter("path2");
        PrintWriter out=response.getWriter();

        try {
            Runtime process = Runtime.getRuntime();
            LOGGER.info("Process Execution BEGIN");
            out.print("starts");
            Process pr = process.exec("pscp -pw"+" "+uname+" "+pass+"@"+mcip+":"+path1+" "+path2);
          //  Process pr = process.exec("pscp -pw webadmin webadmin@10.90.130.170:/apps/tomcat7.0.25/logs/scribe.log     D:\\Scribe\\");
            out.print("opened");
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
