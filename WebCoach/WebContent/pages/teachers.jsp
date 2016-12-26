<%@page import="java.util.ArrayList"%>
<%@ page language="java"   contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="by.coach.beans.Teacher" %>


<div class="main">

<%@include file="../WEB-INF/jspf/left_menu.jsp" %>


<% request.setCharacterEncoding("UTF-8"); %>

 								<!-- Right menu  : List of teachers  -->
 								
	<jsp:useBean id="teacherList" class="by.coach.beans.TeacherList" scope="page"/>

<%
	ArrayList<Teacher> listTeach =null;
	if (request.getParameter("skill_id")!=null){
		long skillId = Long.valueOf(request.getParameter("skill_id"));
		listTeach = teacherList.getTeachersBySkill(skillId);	
		session.setAttribute("currentTeachList", listTeach);	
	} else if (request.getParameter("search_string")!=null) {
		request.setCharacterEncoding("UTF-8");
		String searchString = request.getParameter("search_string");
		listTeach = teacherList.getTeachersBySearch(searchString);
		session.setAttribute("currentTeachList", listTeach);
	} 
	
	if (request.getParameter("exper_from")!=null) {
		int experience = Integer.valueOf(request.getParameter("exper_from"));
		listTeach = teacherList.getTeachersByExperiencePerSkill((ArrayList)session.getAttribute("currentTeachList"), experience);
		session.setAttribute("currentTeachList", listTeach);
	}

%>

		<div class="content">
	
	
	<h2>Список преподавателей (найдено: <%=listTeach.size() %>):</h2>
	
	<% 
				for (Teacher teacher:listTeach){ 
	%>
	<div class="concret_teacher">
			<img alt="foto" height="250" width="190" src="<%=request.getContextPath()%>/ShowImage?index=<%=listTeach.indexOf(teacher) %>"></br>
			<li><strong> <%=teacher.getName() %></strong></li>
			<li> Специализация: <%=teacher.getTypeOfSkill() %></li>
			<li> Опыт: <%=teacher.getExperianceAge() %></li>
			<li> Стоимость: <%=teacher.getCost() %></li>
			<li><a href="ShowListCertificates?idTeach=<%=teacher.getId() %>&nameTeacher=<%=teacher.getName()%>" > Сертификаты и дипломы </a></li> </br>
				</div>
			
		 	<% } %>
		 		
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
	