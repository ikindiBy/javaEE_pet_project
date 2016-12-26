
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style_main.css" rel="stylesheet" type="text/css">
</head>
<body>
		<%
		request.setCharacterEncoding("UTF-8");
		 %>
									
<div class="main">

		<div class="descr">
				<h2> Лучшие репетиторы здесь!</h2>
		</div>

	<div class="search_form">
		<form action="SearchFormServlet" method="post" name="search_form">
			<input type="text" name="search_string" size="60" />
			<input class="search_button" type="submit" value="Поиск"/>
		</form>
	
	</div>
		<div class="exit">
		<a href="LogOutServlet" style="text-align:right;">Выход</a>
		</div>
	</div>
