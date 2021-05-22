<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

</head>
<body>
<div>
<table border="1" cellpadding="5" cellspacing="5">
      <thead>
        <tr>
            <th>No</th>
            <th>Scheduled Departure</th>
            <th>Scheduled Arrival</th>
            <th>Status</th>
            <th>Departure Airport</th>
            <th>Arrival Airport</th>
            <th>Aircraft Model</th>
        </tr>
      </thead>


         <c:forEach items="${flightList}" var="flight">
             <tr>
                 <td>${flight.flightNo}</td>
                 <td>${flight.scheduledDeparture}</td>
                 <td>${flight.scheduledArrival}</td>
                 <td>${flight.status}</td>
                 <td>${flight.departureAirport}</td>
                 <td>${flight.arrivalAirport}</td>
                 <td>${flight.aircraftModel}</td>
             </tr>
         </c:forEach>
      </tbody>
    </table>

     <%--For displaying Previous link except for the 1st page --%>
        <c:if test="${currentPage != 1}">
            <td><a href="flights?page=${currentPage - 1}">Previous</a></td>
        </c:if>

        <%--For displaying Page numbers.
        The when condition does not display a link for the current page--%>

                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <td>${i}</td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="flights?page=${i}">${i}</a></td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>


        <%--For displaying Next link --%>
        <c:if test="${currentPage lt noOfPages}">
            <td><a href="flights?page=${currentPage + 1}">Next</a></td>
        </c:if>
</div>
</body>