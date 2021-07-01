package co.edu.ufps.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.RolDAO;
import co.edu.ufps.dao.TypedbDAO;
import co.edu.ufps.dao.UsuarioDao;
import co.edu.ufps.entities.Rol;
import co.edu.ufps.entities.Typedb;
import co.edu.ufps.entities.Usuario;
import co.edu.ufps.util.*;



@WebServlet({ "/Usuario", "/Registro","/Registro/enviar","/validarRegistro","/validarRegistro/enviar","/login" ,"/login/enviar",
	"/registroTipo","/registroTipo/enviar","","/","/index.jsp"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UsuarioDao usuarioDao;
	private RolDAO rolDAO;
	private TypedbDAO typedbDAO;
    public Controller() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		usuarioDao=new UsuarioDao();
		rolDAO=new RolDAO();
		typedbDAO=new TypedbDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path= request.getServletPath();
		if(path.equals("") || path.equals("/") ||path.contains("index.jsp")) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		switch(path) {
		case "/Registro":
			mostrarRegistro(request, response);
			break;
		case "/Registro/enviar":
			registrar(request, response);
			break;
		case"/validarRegistro":
			request.getRequestDispatcher("validarRegistro.jsp").forward(request, response);
			break;
		case"/validarRegistro/enviar":
			validarRegistro(request, response);
			break;
			
		case"/login":
			UsuarioDao user=(UsuarioDao)request.getSession().getAttribute("usuario");
			if(user!=null) {
				String direccion= user.getRol().getId()==1?"/registroTipo":"/inicio";
				response.sendRedirect(request.getContextPath()+direccion);
				return;
			}
			request.setAttribute("roles",rolDAO.list());
			request.getRequestDispatcher("UsuarioLogin.jsp").forward(request, response);
			break;
		case"/login/enviar":
			login(request, response);
			break;
		case "/registroTipo":
			if(request.getSession().getAttribute("usuario")==null || ((UsuarioDao)request.getSession().getAttribute("usuario")).getRol().getId()!=1) {
				response.sendRedirect(request.getContextPath()+"/login");
				return;
			}
			request.getRequestDispatcher("registroTipo.jsp").forward(request, response);
			break;
			
		case "/registroTipo/enviar":
			registroTipo(request, response);
			
			break;
		}
		
		
	}

	
	protected void mostrarRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("registro.jsp").forward(request, response);
		
	}
	
	protected void registroTipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario")==null || ((UsuarioDao)request.getSession().getAttribute("usuario")).getRol().getId()!=1) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		try {
			String id=request.getParameter("id");
			String descripcion=request.getParameter("descripcion");
			String driver=request.getParameter("driver");
			String adicional=request.getParameter("adicional");
			
			Typedb tipo = new Typedb();
			tipo.setId(id);
			tipo.setDescription(descripcion);
			tipo.setDriver(driver);
			tipo.setAditional(adicional);
			
			typedbDAO.insert(tipo);
			response.sendRedirect(request.getContextPath()+"/registroTipo?registro=tipo registro con exito");
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/registroTipo?registro=error del registro tipo");
		}
		
		
	}
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario= request.getParameter("usuario");
		String contrasenia= request.getParameter("contrasenia");
		String email= request.getParameter("email");
		try {

			UsuarioDao u = new UsuarioDao();
			u.setPass(contrasenia);
			u.setUsuario(usuario);
			u.setEmail(email);
			Rol r = rolDAO.find(2);
			u.setRol(r);
			u.setState((short)0);
			usuarioDao.insert(u);
			EnviarEmail m =new EnviarEmail();
			m.enviarEmail(email, "Registro con exito sistema reportes", "Te has registrado exitosamente, completa tu registro en http://localhost:8080"+request.getContextPath()+"/validarRegistro");
			response.sendRedirect(request.getContextPath()+"/Registro?registro=Se ha completado el registro, erifique su correo electronico");
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/Registro?registro=error intenta de nuevo");
		}
		
		
		
	}
	
	protected void validarRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario= request.getParameter("usuario");
		String contrasenia= request.getParameter("contrasenia");
		try {

			UsuarioDao u = new UsuarioDao();
			u.setPass(contrasenia);
			u.setUsuario(usuario);
			UsuarioDao us=null;
			if((us=usuarioDao.buscar(u))!=null) {
				us.setState((short)1);
				usuarioDao.update(us);
				response.sendRedirect(request.getContextPath()+"/validarRegistro?validar=Se valido");
			}else {
				response.sendRedirect(request.getContextPath()+"/validarRegistro?validar=No se valido");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario= request.getParameter("usuario");
		String contrasenia= request.getParameter("contrasenia");
		Integer rol = Integer.parseInt(request.getParameter("rol"));
		try {

			UsuarioDao u = new UsuarioDao();
			u.setPass(contrasenia);
			u.setUsuario(usuario);
			Rol r = rolDAO.find(rol);
			r.setId(rol);
			u.setRol(r);
			UsuarioDao us=null;
			if((us=usuarioDao.log(u))!=null) {
				request.getSession().setAttribute("usuario", us);
				if(u.getRol().getId()==1) {
					response.sendRedirect(request.getContextPath()+"/registroTipo");
				}else {
					response.sendRedirect(request.getContextPath()+"/inicio");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/validarRegistro?validar=No se valido");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		doGet(request, response);
	}

}