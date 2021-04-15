<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>


<html>
 <head>
   <title>Message page</title>
   <meta charset="utf-8">
 </head>
 <body>
  <form action="message" method="POST">
    User name: <input type="text" name="recipient" />
    Enter your message: <input type="text" name="messageText" />
 <input type="submit" value="Send"/>
  </form>
  <form action="chatsMessages.jsp" method="GET">
        <input type="submit" value="Back"/></p>
 </body>
</html>