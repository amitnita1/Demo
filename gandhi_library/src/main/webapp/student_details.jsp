<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
   h2{
      text-align:center;
   }
   table{
     border:1px solid black;
     margin-left:auto;
     margin-right:auto;
     border-collapse: collapse;
   }
   tr,td,th{
     border:0.5px solid blue;
   }
   
   
</style>
<title>Details</title>
</head>
<body>
<h2>Book details</h2>
<table>
	<tr>
		<th>Name</th>
		<th>Books</th>
	</tr>
	<tr>
		<td>${foundList[0].id}</td>
		<td>${foundList[0].bookName}</td>
	</tr>
	
</table>

</body>
</html>