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
<form name="log" method="post" action="/Parser">
    <div id="header">
        <h1>Scribe Log validator</h1>
    </div>
    <h2><center>Log Importer</center></h2>
    <table cellpadding="5">

        <tr><td>Enter Username:</td><td><input type="text" name="uname" value=""></td></tr>
        <tr><td>Enter MachineIP:</td><td><input type="text" name="mip" value=""></td></tr>
        <tr><td>Enter Password:</td><td><input type="password" name="pwd" value=""></td></tr>
        <tr><td>Enter Path1:</td><td><input type="text" name="path1" value="" ></td></tr>
        <tr><td>Enter Path2:</td><td><input type="text" name="path2" value="" ></td></tr>
        <tr><td><input type="submit" name="import" value="Import"></td></tr>
    </table>
</form>
</body>
</html>
