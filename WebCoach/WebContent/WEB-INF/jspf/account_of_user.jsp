<%@page import="by.coach.beans.Teacher" %>

		<div class="account">
			<%
				Teacher tea = new Teacher();
				tea =  (Teacher)session.getAttribute("userData");
		 	%>
	 
			<H2> Информация о пользователе: <%=session.getAttribute("username") %></H2>
			</br>
			Имя: <%=tea.getName() %>
			</br>
			Навык: <%=tea.getTypeOfSkill() %>
			</br>
		
			<a href="EditDataTeacherServlet" >${button_edit}</a>
		
	</div>
	