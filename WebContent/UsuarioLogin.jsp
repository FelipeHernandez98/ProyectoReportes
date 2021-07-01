<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<!-- CSS only -->
	<link rel="stylesheet" type="text/css" href="estilos/style.css"> <!-- acomodar la redireccion--> 
	<link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
</head>

<body>
   <form class="formulario" action="UsuarioLoginController"
		method="POST">
		<h1>Iniciar sesión</h1>
		<div class="contenedor">
		 <div class="input-contenedor">
			<i class="fas fa-user"></i>
			<input type="text" placeholder="Usuario">
		 </div>

		 <div class="input-contenedor">
			<i class="fas fa-lock"></i>
			<input type="password" placeholder="Contraseña">
		 </div>

		<button type="submit" value="IniciarSesion"class="button">Iniciar sesión</button>
		</div>

	</form>
</body>

</html>