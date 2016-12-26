<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style_reg_edit.css" rel="stylesheet" type="text/css">
</head>
<body> 
<div class="main">
 <div class="registration">
  			<form  name="registration_form" action="FileDownloadServlet" method="post" enctype="multipart/form-data">
			 	
			 				<label for="foto">Фото:</label>
			 		 		<input type="file" name="foto" /> </br> <p> </p>
			 
							<input class="submButton" type="submit" value="Загрузить" name="submit"/>	
			</form>	</br> <p> </p>	 	
			
			<form  name="registration_form" action="FileDownloadServlet" method="post" enctype="multipart/form-data">
						 	
						 	<label for="file">Сертификат:</label>
							<input type="file" name="file" /> </br> <p> </p>
			 	
							<input class="submButton" type="submit" value="Загрузить" name="submit"/>	
			</form>

	 <a href="http://localhost:8080/WebCoach/" style="text-align: left;"> Back </a>
	 </div>
	 </div>
	 
	 
</body>
</html>