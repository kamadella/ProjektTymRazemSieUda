<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uzytkownicy</title>
        <style>.error { color: red; }</style>
    </head>
    <body>
        <h3>Edycja książki</h3>
        <%-- komentarz JSP - nie jest rendrowany --%>
        <form method="post">
            <table>
                <tr>
                    <td>Tytuł:</td>
                    <%-- fn:escapeXml(value) dodaje kody ucieczki jeśli tekst zwiera znaczniki - zabezpiecza przez atakiem XSS --%>
                    <td><input type="text" name="login" value="${fn:escapeXml(login)}" ></td>
                    <%-- errors zawiera ew. błędy konwersji/walidacji dla poszczególnych pól --%>
                    <td><span class="error">${errors.login}</span></td>
                </tr>
                <tr>
                    <td>Autor:</td>
                    <td><input type="text" name="password" value="${fn:escapeXml(password)}" ></td>
                    <td><span class="error">${errors.password}</span></td>
                </tr>
                <tr>
                    <td>Cena:</td>
                    <td><input type="text" name="email" value="${fn:escapeXml(email)}" > </td>
                    <td><span class="error">${errors.email}</span></td>
                </tr>
            </table>
            <input type="submit" value="Save">
        </form>
    </body>
</html>