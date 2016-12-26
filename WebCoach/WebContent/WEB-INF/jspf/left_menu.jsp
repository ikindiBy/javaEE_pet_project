<%@ page language="java"   contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="by.coach.beans.Skill" %>

<div class="sidebar">
		<jsp:useBean id="skillList" class="by.coach.beans.SkillList" scope="application"/>
		
		<%
		long selectedSkillId = 0;
		
		if(request.getParameter("skill_id") != null){
			selectedSkillId=Long.valueOf(request.getParameter("skill_id"));	
		} else if (session.getAttribute("skillId") != null){
			selectedSkillId=Long.valueOf(session.getAttribute("skillId").toString());	
		}
		session.setAttribute("skillId", selectedSkillId);
		%>		
		
		<h2>Список навыков:</h2>
		
		<li><a href="TeacherServlet?skill_id=0">	Все навыки </a></li>
		
		<% 
			for (Skill skill:skillList.getSkillList()) { 
			if(selectedSkillId !=0 && selectedSkillId == skill.getId()){
		%>
		
		<li><a  style="color: red" href="TeacherServlet?skill_id=<%=skill.getId()%>"> <%=skill.getName() %> </a></li>
		
		<% }else { %>
				<li><a href="TeacherServlet?skill_id=<%=skill.getId()%>"> <%=skill.getName() %> </a></li>
				<% } 
			}%>
		

	
		</br>
	
	<form action="TeacherExperServlet" method="get" name="search_exper">
		<p> Стаж от:
		<input type="number" name="exper_from" min="1" max="50" />
		<input class="search_button" type="submit" value="Выбрать"/>
		 </p>
	</form>
	
		</div>