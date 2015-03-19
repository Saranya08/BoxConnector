<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #header {
        background: url("http://dfdevpipadmin1.df.jabodo.com/resources/images/offercast_logo_24.png") no-repeat;
        background-color:#082567;
        color:white;
        line-height:10px;
        text-align:center;
        padding:5px;
    }

    #eventURL {
        background-color:#eeeeee;
        line-height:30px;
        width:550px;
        float:left;
        padding:10px;
    }
    #PredefinedRequest {
        line-height:30px;
    width:550px;
    float:left;
    padding:10px;

        }

    table#02 tr:nth-child(even) {
        background-color: #fff;
    }
    table#02 tr:nth-child(odd) {
        background-color: #fff;
    }
    table#02 th {
        color: white;
        background-color: black;
    }
</style>

<head>
    <title></title>
</head>
<body>
<form name="event" method="post" action="/LogImporter">
    <div id="header">
        <h1>Scribe Log validator</h1>
    </div>
    <h2><center>Event Generator</center></h2>
    <div id="eventURL">
        <table id="01" cellpadding="5">
            <tr><td>Enter get URL:</td><td><input type="text" name="url" id="url" value=""></td></tr>
            <tr><td><input type="submit" name="gen" value="Generate" onclick="evegen()" ></td><td>
        </table>
    </div>

   <%-- <div id="PredefinedRequest">
        <table id="02" cellpadding="5">
            <tr>
                <th>#</th>
                <th>Scenerio</th>
                <th>Toolbar Outcome Call</th>
                <th>Secondary Outcome Call</th>
            </tr>
            <tr>
                <td>1</td>
                <td>Both TB and SO accepted </td>
                <td>http://10.90.130.169/offermetrics?anxe=OCInstall&anxv=7.19.0.91</td>
                <td>http://10.90.130.169/offermetrics?anxe=OCInstall&anxv=7.19.0.91</td>
            </tr>

        </table>
    </div>
--%>

</form>
</body>
</html>
