<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owners Lists</title>
</head>
<body>
	<form method="post" action="listNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentlist.id}"></td>
					<td><h2>${currentlist.listName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Creation Date: ${currentlist.creationDate}</td>
				</tr>
				<tr>
					<td colspan="3">Owner: ${currentlist.owner.ownerName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentlist.listOfCars}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.make}, ${listVal.model}, ${listVal.year}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList"> <input
			type="submit" value="delete" name="doThisToList"> <input
			type="submit" value="add" name="doThisToList">
	</form>
	 <br />
	<a href="addItemsForListServlet">Create a new List</a> <br />
	<a href="index.html">Insert a new item</a>
</body>
</html>