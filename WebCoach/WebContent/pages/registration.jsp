<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="by.coach.beans.Skill" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online library. Enter page</title>
<link href="css/style_reg_edit.css" rel="stylesheet" type="text/css">
</head>
<body>

		<jsp:useBean id="skillList" class="by.coach.beans.SkillList" scope="application"/>
					<%
						request.setCharacterEncoding("UTF-8");
					 %>
					 
	<div class="main">
	<p class="title"> Форма регистрации для подачи объявления! </p>
	<div class="registration">
					 
	 			<form class="registration_form" name="registration_form" action="RegistrationServlet" method="POST" >
				<input type="hidden" name="command" value="registration" />
				
					<label for="login_form">Логин:</label>			
					<input type="text" name="login_form" value=""  size="20" /> </br> <p> </p>
					
					<label for="password_form">Пароль:</label>		
					<input type="text" name="password_form" value=""  size="20" /> </br> <p> </p>
					
					<label for="name_form">Имя:</label>
					<input type="text" name="name_form" value=""  size="20"  /> </br> <p> </p>
					
					<label for="type_skill_form">Тип навыка:</label>
					<input type="text" name="type_skill_form" value=""  size="20" placeholder="Пример: Гитара"/> </br> <p> </p>
					
					<label for="experience_form">Опыт:</label>
					<input type="number" name="experience_form" min="1" max="50"/> </br> <p> </p>
					
					<label for="cost_form">Цена:</label>
					<input type="number" name="cost_form" min="1" max="1000" />  </br> <p> </p>
				
					
					Выбирите навык:</br></br>
					
					<%  for (Skill skill:skillList.getSkillList()) {  %>
						
						<li><input class="radio_form" type="radio" name="skill" value="<%=skill.getId()%>"/> <%=skill.getName() %></li></br> 
						
					<% } %>
						
					<p > ${errorDoubleLogin}   ${errorEmptyData}</p></br>
					
					<input class="submButton" type="submit" value="Enter" name="submit" />	</br> <p> </p>
					

			</form>
			
	 <a href="http://localhost:8080/WebCoach/" style="text-align: left;"> Назад </a>
	 
	 </div>
	 
	 </div>
	 
	 </body>
</html>