<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
<link href="css/style_reg_edit.css" rel="stylesheet" type="text/css">
<title>Edit teacher's data</title>
</head>
<body>
<%@page import="by.coach.beans.Teacher" %>

	 <div class="main">
	<p class="title"> Форма редактирования объявления! </p>

				<%
					Teacher tea = new Teacher();
					tea =  (Teacher)session.getAttribute("userData");
		 		%>
	 
	 

	<div class="registration">
	
		<form class="edit_form" name="edit_form" action="EditDataTeacherServlet" method="POST">
				<input type="hidden" name="command" value="edit" />
				
						<label for="login_form">Логин:</label>		
						<input type="text" name="login_form" value="<%=tea.getUsername() %>"  size="20"/> </br> <p> </p>
				
						<label for="password_form">Пароль:</label>
						<input type="text" name="password_form" value="<%=tea.getPassword() %>"  size="20"/> </br> <p> </p>
				
						<label for="name_form">Имя:</label>
						<input type="text" name="name_form" value="<%=tea.getName() %>"  size="20"/> </br> <p> </p>
				
						<label for="type_skill_form">Тип навыка:</label>
						<input type="text" name="type_skill_form" value="<%=tea.getTypeOfSkill() %>"  size="20"/> </br> <p> </p>
				 
				 		<label for="experience_form">Опыт:</label>
						<input type="number" name="experience_form" min="1" max="50"  value="<%=tea.getExperianceAge()%>"/> </br> <p>
					
						<label for="cost_form">Цена:</label> </p>
						<input type="number" name="cost_form" min="1" max="1000"  value="<%=tea.getCost()%>"/>  </br> <p> </p>
					
								
					<p > ${errorDoubleLogin}   ${errorEmptyData}</p></br>
				
					
				   	<input class="submButton" type="submit" value="Enter" name="submit"/>	 </br> <p> </p>
				</form>	 
					<h4><a href="EditDataTeacherServlet?addFotoCert=true" style="text-align: left;"> Add foto or certificate </a> </br></h4> <p> </p>
					 	
					</div>
					</div>
					
</body>
</html>