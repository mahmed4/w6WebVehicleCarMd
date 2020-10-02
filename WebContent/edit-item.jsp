<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>md-motor</title>
</head>
<body>
<h2>You can Add View Delete Vehicle on the list</h2>
	<form action = "editItemServlet" method = "post">
	Make: <input type = "text" name = "make" value = "${itemToEdit.make}">
	Model: <input type = "text" name = "model" value = "${itemToEdit.model}">
	Year: <input type = "text" name = "year" value = "${itemToEdit.year}">
	<input type = "hidden" name = "id" value ="${itemToEdit.id}">
	<input type = "submit" value= "Save Edited Vehicle">
 	</form>

</body>
</html>