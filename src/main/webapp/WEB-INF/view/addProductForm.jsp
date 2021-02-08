
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/products/add" method="post" >
    <label>Price<input type="text" placeholder="" name="price" required="required"></label> <br>
    <label>Name<input type="text" placeholder="" name="name" required="required"></label> <br>
    <label>Description<input type="text" placeholder="" name="description" required="required"></label> <br>
    <label>Created Date<input type="date" placeholder="" name="created" required="required"></label> <br>
    <label>Expired Date<input type="date" placeholder="" name="expired" required="required"></label> <br>
    <input type="submit" >
</form>
</body>
</html>
