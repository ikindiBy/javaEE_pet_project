<%@ page language="java"   contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="by.coach.beans.Teacher" %>

<div class="main">

		<%@include file="../WEB-INF/jspf/left_menu.jsp" %>
		
		  	<div class="content">
				
			</div>
					
		<div class="account">
			<%
				Teacher tea = new Teacher();
				tea =  (Teacher)session.getAttribute("userData");
		 	%>
	 
			<H2> Информация о пользователе: <%=session.getAttribute("username") %></H2>
			</br>
			Имя: <%=tea.getName() %></br>
			Навык: <%=tea.getTypeOfSkill() %></br>
			
			<a href="EditDataTeacherServlet" > ${button_edit} </a>
			  
			</div>
			
		</div>