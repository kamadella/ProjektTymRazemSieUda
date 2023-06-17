<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 17.06.2023
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Błąd</title>
</head>
<body>
<p>Błąd aplikacji</p>
<ul>
    <li>
        jakarta.servlet.error.status_code: ${requestScope['jakarta.servlet.error.status_code']}
    </li>
    <li>
        jakarta.servlet.error.exception_type:  ${requestScope['jakarta.servlet.error.exception_type']}
    </li>
    <li>
        jakarta.servlet.error.exception: ${requestScope['jakarta.servlet.error.exception']}
    </li>
    <li>
        jakarta.servlet.error.message: ${requestScope['jakarta.servlet.error.message']}
    </li>
    <li>
        jakarta.servlet.error.request_uri: ${requestScope['jakarta.servlet.error.request_uri']}
    </li>
    <li>
        jakarta.servlet.error.servlet_name: ${requestScope['jakarta.servlet.error.servlet_name']}
    </li>
</ul>
</body>
</html>
