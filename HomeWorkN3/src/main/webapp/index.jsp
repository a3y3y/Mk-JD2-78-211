<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
 <head>
   <title>Welcome to airport page</title>
   <meta charset="utf-8">
   <link rel="stylesheet" href="css/style.css">
       <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <style>
      div.field {
        padding-bottom: 5px;
      }
      div.field label {
        display: block;
        float: left;
        width: 135px;
        height: 15px;
      }
     </style>
     <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
         <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
         <script>
         $( function() {
           $( "#datepicker1" ).datepicker({dateFormat: "yy-mm-dd",
           minDate: new Date(2016,7,15), maxDate: new Date(2017,8,14)});
           $( "#datepicker2" ).datepicker({dateFormat: "yy-mm-dd",
           minDate: new Date(2016,7,15), maxDate: new Date(2017,8,14)});
         } );
     </script>
 </head>
 <body>


  <form action="flights" method="GET">
   <div class="field">
      <label>Departure start date:</label>
       <input type="text" id="datepicker1" name="dateDeparture1" required>
    </div>
    <div class="field">
          <label>Departure   end date:</label>
           <input type="text" id="datepicker2" name="dateDeparture2" required>
        </div>
    <div class="field">
      <label>Departure airport:</label>
                <select required name="departureAirport">
                    <option value="">Choose airport</option>
                        <c:forEach items="${airportList}" var="airport">
                                <option>${airport.name}</option>
                        </c:forEach>
                </select>
    </div>
    <div class="field">
          <label>Arrival airport:</label>
          <select required name="arrivalAirport">
            <option value="">Choose airport</option>
                <c:forEach items="${airportList}" var="airport">
                          <option>${airport.name}</option>
                </c:forEach>
          </select>
    </div>
    <div class="field">
      <label></label>
      <input type="submit" value="Search">
    </div>
  </form>
  <form action="airports" method="GET">
       <input type="submit" value="See all airports"/></p>
 </body>
</html>