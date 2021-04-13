<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Airports Page</title>
</head>
<body>

<table>
<table border="1" bgcolor="#e1e1e1">
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>City</th>
        <th>Coordinates</th>
        <th>Timezone</th>
    </tr>

    <c:forEach items="${airportList}" var="airport">
        <tr>
            <td>${airport.code}</td>
            <td>${airport.name}</td>
            <td>${airport.city}</td>
            <td>${airport.coordinates}</td>
            <td>${airport.timezone}</td>
        </tr>
    </c:forEach>

</table>


</body>