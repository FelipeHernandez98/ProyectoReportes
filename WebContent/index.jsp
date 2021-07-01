<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet" type="text/css" href="styleIndex.css"><!--acomode el css redireccinelo-->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Index</title>
</head>
<body>
<h1><b></b></h1>
  <div class="form-group row">
    <div class="col-sm-10">
    <h1>Usuario</h1>
     <a href="${pageContext.request.contextPath}/Registro.jsp" class="link">Registrar Usuario</a>
     <a href="${pageContext.request.contextPath}/UsuarioLogin.jsp" class="link">Iniciar Sesión</a>
     <br>
     <h1>Token</h1>
     <a href="${pageContext.request.contextPath}/tokenRegistro.jsp" class="link-2">Registrar Token</a>
     <a href="${pageContext.request.contextPath}/tokenList.jsp" class="link-2">Listar Tokens</a>
     <br>
     <h1>Reporte</h1>
     <a href="${pageContext.request.contextPath}/reporteBuscar.jsp" class="link">Buscar Reporte</a>
     <a href="${pageContext.request.contextPath}/reporteRegistro.jsp" class="link">Registrar Reporte</a>
     <a href="${pageContext.request.contextPath}/reporteList.jsp" class="link">Listar Reportes</a>
    </div>>
</body>
</html>