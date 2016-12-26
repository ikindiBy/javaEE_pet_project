<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online library. Enter page</title>
<link href="css/style_index.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main">

	<div class="content">

	<p class="title"><span class = "text">
		<img alt="" src="images/coach1.jpg" width="600" height="253" hspace="10" vspace="10" align="middle" >
	</span></p>
	<p class="title"> Найди своего наставника! </p>
	</div>
	
	<div class="login_div">
		<p class="title"> Для входа введите Ваши данные или войдите как ученик. </p>
		
		 <form class="login_form" name="login_form" action="LoginController" method="POST">
						<input type="hidden" name="command" value="login" />
						
						<label for="username">Ваш логин:</label>	
						<input type="text" name="username" value=""  size="20"/> </br> <p> </p>
						
						<label for="password">Ваш пароль:</label>	
					   	<input type="password" name="password" value=""  size="20"/> </br> <p> </p>
					   	
						<h5 style="color: red"> ${errorLoginPassMessage} 	</h5> 
						<h5 style="color: red"> ${wrongAction}    			</h5>	     
						<h5 style="color: red"> ${nullPage} 				</h5><br/>
						
									<h4><input type="radio" name="guest" value="true"/> Войти как ученик.</h4> <br/>
							 			<input class="submButton" type="submit" value="Enter" name="submit"/>	
							 			<a href="RegistrationServlet" style="text-align: left;">Регистрация</a><br/><br/>
						
				  </form>
			</div>
		<div class="footer"> Разработано, как презентация, 2016.
		</div>
</div>


</body>
</html>