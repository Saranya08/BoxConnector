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
</style>
<head>
    <title></title>
</head>
<body>
<form name="valid" method="post" action="/comparator">
    <div id="header">
        <h1>Scribe Log validator</h1>
    </div>
<h2><center>Validator</center></h2>
<table cellpadding="5">

    <tr><td>Enter key:</td><td><input type="text" name="key" id="key" value=""></td></tr>
    <tr><td>Enter Expected Value:</td><td><input type="text" name="expectedValue" id="expectedValue" value=""></td></tr>
    <tr><td>Result:</td><td><input type="text" name="Result" id="result" value=${Result}></td></tr>
    <tr><td><button>Compare</button></td></tr>
</table>
</form>
</body>
</html>
