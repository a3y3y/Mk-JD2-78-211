<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>


<html>
 <head>
   <title>Sign up page</title>
   <meta charset="utf-8">
         <link rel="stylesheet" href="css/style.css">
         <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
         <link rel="stylesheet" href="/resources/demos/style.css">
         <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
         <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
         <script>
         $( function() {
           $( "#datepicker1" ).datepicker();
         } );
         </script>
 </head>
 <body>
  <form action="signUp" method="GET">
    <p>Login: <input type="text" name="login" />
    Password: <input type="text" name="password" /></p>
    <p>Last name: <input type="text" name="lastName" />
    First name: <input type="text" name="firstName" /></p>
    <form>
       <p>Birth date: <input type="text" id="datepicker1" name="birthDate">
       <input type="submit" value="Sign up"></p>
      </form>
    </form>
    <p><form action="index.jsp" method="GET">
         <input type="submit" value="Back"/></p>
  </form>
 </body>
</html>


