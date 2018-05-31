<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 style="color: red;">${filesuccess}</h4>
<form:form method="post" action="savefile" enctype="multipart/form-data">
<h1 style="color: green;">Uploading an Image</h1>
<p><label for="image">Choose Image</label></p>  
<input type="file" name="file" value="browse"><br>
<input type="submit" value="Upload">
</form:form>
</body>
</html>