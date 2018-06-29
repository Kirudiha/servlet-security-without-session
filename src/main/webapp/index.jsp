<html>
<body>
<div style="color:red">
    <%
     Object msg = request.getAttribute("errorMsg");
        if(msg != null ){
           out.println(msg);
        }
     %>
</div>
<form action="/loginHandler" method="post">
    <table>
        <tr>
            <td> User:</td>
            <td><input type="text" name="theUser"/></td>
        </tr>
        <tr>
            <td> Password:</td>
            <td><input type="password" name="thePassword"/></td>
        </tr>
    </table>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>