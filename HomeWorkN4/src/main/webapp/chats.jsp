<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
 <head>
   <title>Chats</title>
   <meta charset="utf-8">
 </head>
 <body>
 <form action="chatsMessages.jsp" method="GET">
     <input type="submit" value="Back"/></p>
   </form>
   <c:forEach items="${mlist}" var="message">
              <p>Time: <c:out value="${message.sendTime}"/></p>
              <p>Sender: <c:out value="${message.sender}"/></p>
              <p>Message: <c:out value="${message.messageText}"/></p>
              <p>-----------------</p>
      </c:forEach>
  </table>
 </body>
</html>