<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="EducationalInfo.jsp" method="post">

<%
	String degree = request.getParameter("degree") ; 
	String name = request.getParameter("name");
	String percentage = request.getParameter("percentage");
	
	if(degree== null || name == null || percentage ==null){
		
%>
	Enter Educational Details : <br><br> 
	
	Degree : <input type="text"  name="degree" ><br>
	Collge Name :  <input type="text"  name="name" ><br>
	Percentage :  <input type="text"  name="percentage" ><br>
	<button type="submit" >Submit</button>
 
 <%
	}else{
		
 %>
 
  Education Details : <br><br>
  
  Degree = <%= degree %> <br><br>
  College Name = <%=name %> <br><br>
  Percentage = <%=percentage %> <br><br>
  
  <a href="EducationalInfo.jsp" >Go back </a>
  
 
 <%
	}
 %>
 </form>

</body>
</html>