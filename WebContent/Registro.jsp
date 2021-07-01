<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/bfd4c33ec6.js" crossorigin="anonymous"></script>
<title>Document</title>

</head>

<body>
	<form class="formulario" action="UsuarioRegistrarController" method="POST">
		<h1>Registrate</h1>
		<div>
		<div>
			
			<label for="user">Usuario</label>  <input type="text" required
				 placeholder="Usuario" name="usuario"> 
			</div>
			</div>
		<div>
		<div>
			<i></i>
			<label for="email">Email</label> <input type="email" required
				" placeholder="email" name="email">
		</div>
		</div>
		<div>
		<div>
			<i></i>
			<label for="password">Password</label> <input type="password" required
				 placeholder="*****" name="pass">
		</div>
		</div>
		<div>
			<select name="role">
				<c:forEach var="item" items="${roles}">
					<option value="<c:out value='${item.id}'/>"><c:out
							value="${item.description}" /></option>
				</c:forEach>
			</select>
		</div>

		<input type="hidden"  name="state" value="1">

		<div>
			<button type="submit" class="button">Registrar</button>
		</div>
	</form>
</body>

</html>