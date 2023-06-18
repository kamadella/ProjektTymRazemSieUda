<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- fmt:setLocale konfiguruje ustawienia lokalne dla tej strony na polskie; używane przez fmt:formatNumber przy formatowaniu liczby--%>
<fmt:setLocale value = "pl_PL"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Książki</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Login</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>Operacje</th>
                </tr>
            </thead>
            <tbody>
                <%-- c:forEach renderuje zawartość dla każdego elementu na liscie, wewnatrz znacznika kolejne elementy będą dostępne pod nazwą wskazaną przez atrybut var --%>
                <c:forEach items='${userList}' var='user'>
                    <tr>
                        <%-- fn:escapeXml(value) dodaje kody ucieczki jeśli tekst zwiera znaczniki - zabezpiecza przez atakiem XSS --%>
                        <td>${fn:escapeXml(user.login)}</td>
                        <td>${fn:escapeXml(user.password)}</td>
                        <td>
                            <%-- kowertuje book.price (typu BigDecimal) na napis wg wybranych ustawien lokalnych i renderuje wynik --%>
                            ${fn:escapeXml(user.email)}
                        <td>
                            <%-- c:url dodaje do url nazwę aplikacji (context root) oraz identifykator sesji jsessionid jeśli sesja jest włączona i brak obsługi ciasteczek --%>

                            <a href="<c:url value='/user/remove/${user.id}'/>">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="<c:url value='/user/add'/>">Dodaj usera</a>
   </body>
</html>