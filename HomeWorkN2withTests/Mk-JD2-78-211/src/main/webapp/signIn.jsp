<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>


<html>
 <head>
   <title>Sign in page</title>
   <meta charset="utf-8">
 </head>
 <body>
  <form action="signIn" method="GET">
    <p>Login: <input type="text" name="login" />
    Password: <input type="text" name="password" />
    <input type="submit" value="Sign in"/></p>
  </form>
  <form action="index.jsp" method="GET">
       <input type="submit" value="Back"/></p>
 </body>
</html>