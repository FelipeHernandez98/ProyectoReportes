<%@page import="co.edu.ufps.entities.*"%>
<%@page import="co.edu.ufps.dao.*"%>
<%@page import="co.edu.ufps.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Dashboard Administrativo</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	
	<div >
		<div >
        <div>
            <nav>
                <a href="#">Sisreport</a>
                <button type="button" data-toggle="collapse" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">

                </button>
                <div>
                  <div >
                    <a href="#">Inicio <span class="sr-only">(current)</span></a>
                    <%
                    if(user.getRol().getId()==1){
                    	
                    
                    %>
                    <a href="tokens.jsp">Tipos de BD</a>
                    <%} %>
                     <a href="tokens.jsp">Tokens de conexion</a>
                    
                   
                  </div>
                </div>
              </nav>
          <span><%=user.getRol().getDescription() %> <%=user.getEmail() %>
              <a href="#">Salir</a>
          </span>
	
		<div class="row">
			<div >
				<div >
					<div>
					Nuevo Token
					</div>
					<div>
					<form action="../token/registrar" method="post">
					<div>
                        <span>Hostname:</span>
                        <input type="text" name="host" >
                      </div>
                      <div>
                        <span>Userbd:</span>
                        <input type="text" name="userdb"
                        >
                      </div>
                      <div>
                        <span>Puerto</span>
                        <input type="number" name="port">
                      </div>
                      <div>
                        <span>Tipo de conexion</span>
                        <select name="typedb" >
                        <%
                        TypebdDao tpdao=new TypebdDao();
                        List<Typedb> tipos=tpdao.list();
                        	for(Typedb tp:tipos){
                        		%>
                        		<option value="<%=tp.getId() %>"><%=tp.getDescription() %></option>
                        		<%
                        	}
                        %>
</select>
                      </div>
                </div>
                <div">
                    <div>
                        <span>Password:</span>
                        <input type="password" name="pass" >
                      </div>
					</div>
				</div>
				<button type="submit">Enviar</button>
				</form>
			</div>
			<div>
				<div>
					<div>
					Lista de tokens
					</div>
					<div >
					
					<div>
            <table id="tableTokens" class="display">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Host</th>
                        <th>userDb</th>
                        <th>Pass</th>
                        <th>Db</th>
                        <th>Token</th>
                        <th>Port</th>
                        <th>Tipo</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                
                <%
                
                	for(Connectiontoken ctk:user.getConnectiontokens()){
                		%>
                		<tr>
                        <td style="width:10px;"><%=ctk.getId() %></td>
                        <td style="width:15%;"><%=ctk.getHost() %></td>
                        <td><%=ctk.getUserdb() %></td>
                        <td><%=ctk.getPass() %></td>
                        <td><%=ctk.getDb() %></td>
                        <td><%=ctk.getToken() %></td>
                        <td><%=ctk.getPort() %></td>
                        <td><%=ctk.getTypedb().getDescription() %></td>
                        <%
                        	String estado=ctk.getState()+"";
                        	if(estado.equals("0")){
                        		estado="Creado sin validar";
                        	}else if(estado.equals("1")){
                        		estado="Conexion Validada";
                        	}else if(estado.equals("2")){
                        		estado="Sin Conexion";
                        	}
                        %>
                        <td><%=estado %></td>
                        <td><a href="#"><i class="fa fa-edit"></i></a></td>
                    </tr>
                		<%
                		
                	}
                %>
                    
                    
                </tbody>
            </table>
          </div></div>
				</div>
			</div>
		</div>
          

            </div>
		</div>
	</div>

</body>
</html>
	