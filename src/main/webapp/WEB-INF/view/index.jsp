
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<a href="<c:url value="/bucket/1" />">Bucket</a>
<br>
<a href="<c:url value="/products/add" />"><b>Add Product</b></a>
<br>
<table>
    <tr>
        <th>id</th>
        <th>price</th>
        <th>name</th>
        <th>description</th>
        <th>created date</th>
        <th>expired date</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.price}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.createdDate}</td>
            <td>${product.expiredDate}</td>
            <td><a href="/bucket/1/add/${product.id}">Add to bucket</a></td>
            <td><a href="/products/delete/${product.id}" data-method="delete">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
