<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ваши сообщения</title>
    </head>
    <body>
        <table border="1">
            <tbody>
            <c:forEach items="${requestScope.chat}"
            			var="message">
                <tr>
                    <td width="20%">${message.from}</td>
                    <td width="20%"><fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${message.sendDate}" /></td>
                    <td width="60%">${message.text}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/';" value="index" /></p>
    </body>
</html>