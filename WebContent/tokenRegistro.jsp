<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    
<title>Conexion Token</title>
</head>
<body>
<jsp:useBean class="co.edu.ufps.dao.ConnectiontokenDAO" id="connectiontokenDAO"></jsp:useBean>
<jsp:useBean class="co.edu.ufps.dao.TypedbDAO" id="typedbDAO"></jsp:useBean>
<c:if test="${connectiontoken != null}">
                           
                           <form action="ConnectiontokenServlet?action=actualizar&id=${connectiontoken.id}"  method="POST">
                        </c:if>
                        <c:if test="${connectiontoken == null}">
                           
                            <form action="ConnectiontokenServlet?action=registrar"  method="POST">
                        </c:if>
    <div>
        <div>
            <div>
                Conexion Token
            </div>
            <div>
                <form>
                <div >
                    <div>
                        <div>
                            <span>Hostname:</span>
                            <input type="text" name="hostname" value="${connectiontoken.hostname}"  aria-label="Amount (to the nearest dollar)">
                          </div>
                          <div>
                            <span>Userbd:</span>
                            <input type="text" name="userdb" value="${connectiontoken.userdb}" class="form-control" aria-label="Amount (to the nearest dollar)">
                          </div>
                          <div>
                            <span>Puerto</span>
                            <input type="number" name="puerto" value="${connectiontoken.port}" class="form-control" aria-label="Amount (to the nearest dollar)">
                          </div>
                    </div>
                    <div>
                        <div>
                            <span >Password:</span>
                            <input type="password" name="password" value="${connectiontoken.pass}"  aria-label="Amount (to the nearest dollar)">
                          </div>
                          <div>
                            <span>Token:</span>
                            <input type="text" name="token" value="${connectiontoken.token}"  aria-label="Amount (to the nearest dollar)">
                          </div>
                          <div >
                            <select aria-label="Default select example" name="type">
								<option selected value="${connectiontoken.typedb.getId()} ">Tipo:</option>
								<c:forEach items="${typedbDAO.list()}" var="typedb">
									<option value="${typedb.id} ">
										<c:out value="${typedb.descripcion} " />
									</option>
								</c:forEach>
							</select>
                          </div>
                    </div>
                </div>
                <button  type="submit" >Registrar</button>
            </form>
            </div>
        </div>
        
    </div>

  </body>
</html>