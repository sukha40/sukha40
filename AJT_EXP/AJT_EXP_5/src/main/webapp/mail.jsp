<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="FirstMail" method="post">
	Enter Email <br><br>
	
	email address : 
	<input type="email" name = "email" ><br><br>
	
	subject : 
	<input type="text" name ="subject" ><br><br>
	
	Message : 
	<textarea name = "message" rows="10" cols="20">Enter content here </textarea>
	
	<input type="submit" value="submit">

</form>

</body>
</html>