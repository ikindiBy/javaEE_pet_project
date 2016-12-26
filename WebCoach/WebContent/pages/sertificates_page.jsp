<%@page import="java.util.ArrayList"%>
<%@ page language="java"   contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="by.coach.beans.Teacher" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of certificates</title>
<link href="css/style_main.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:useBean id="teacherList" class="by.coach.beans.TeacherList" scope="page"/>
<div class="main">
		<%
		 	request.setCharacterEncoding("UTF-8"); 
			ArrayList<byte[]> 	listCertificates = (ArrayList<byte[]>)request.getSession().getAttribute("listOfCertificates");
			
		%>

		<h2> Список сертификатов пользователя ${nameTeacher}  (найдено: ${countOfCertificates}):</h2>
	
  	  	<% 
   				int count=0; 
				for (byte[] cert:listCertificates){ 
		%>

	 <li><a href="WorkPDFServlet?numberOfCert=<%=count %>" > Сертификат № <%=++count %> </a></li> </br>

		<% request.setAttribute("listOfCertificates", listCertificates); }  %>
		
		<h4><a href="TeacherServlet?skill_id=0" style="text-align: left;"> На главную страницу. </a></h4>
				</div>	
</body>
</html>