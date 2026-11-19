
<%@ page import="java.sql.*" %>
<html><body>

<h2>Student Registration</h2>

<%
String msg=(String)session.getAttribute("msg");
if(msg!=null){out.print(msg);session.removeAttribute("msg");}
%>

<form action="SQLdb" method="post">
ID: <input type="number" name="id"><br><br>
Name: <input type="text" name="name"><br><br>
Email: <input type="email" name="email"><br><br>
Course: <input type="text" name="course"><br><br>
<button name="action" value="insert">Insert</button>
<button name="action" value="update">Update</button>
<button name="action" value="delete">Delete</button>
<button name="action" value="view">View All</button>
</form>

<hr><h2>Student Records</h2>

<table border="1" cellpadding="8">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th></tr>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("SELECT * FROM students");
while(rs.next()){
%>
<tr>
<td><%=rs.getInt("id")%></td>
<td><%=rs.getString("name")%></td>
<td><%=rs.getString("email")%></td>
<td><%=rs.getString("course")%></td>
</tr>
<%
}
rs.close();st.close();con.close();
}catch(Exception e){out.print(e);}
%>
</table>

</body></html>
