package servelts;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.UserDAO;
import interfaces.UserDAOImpl;
import entitis.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	
	UserDAO userDAO = new UserDAOImpl();
	
	public UserController() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listUser(request, response);
				break;
				
			case "VIEW":
				getSingleUserView(request, response);
				break;
				
			case "EDIT":
				getSingleUser(request, response);
				break;
				
			case "DELETE":
				deleteUser(request, response);
				break;
				
			default:
				listUser(request, response);
				break;
				
		}
		
	}

	private void getSingleUserView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extraer el valor del parámetro id
		String idString =request.getParameter("id");
		
		// 	Comprobar que el id no sea null	
		if (idString == null || idString.isEmpty()) {
			request.setAttribute("NOTIFICATION", "Por favir introduce un id de usuario válido");			
			listUser(request, response);
			return;
		}
		 // buscar el usuario con el id en base de datos
		Long idUser = Long.valueOf(idString);
		User user1 = userDAO.get(idUser);
		if (idString == null || idString.isEmpty()) {
			request.setAttribute("NOTIFICATION", "El usuario solicitado no existe.");			
			listUser(request, response);
			return;
		}
		
		// cargar el empleado en la request
		request.setAttribute("user", user1);
		
		// pasar la request a JSP
		RequestDispatcher dispatcher= request.getRequestDispatcher("/views/user-view.jsp");
		dispatcher.forward(request, response);
		
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(userDAO.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "User Deleted Successfully!");
		}
		
		listUser(request, response);
	}

	private void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		User theEmployee = userDAO.get(Long.parseLong(id));
		
		request.setAttribute("employee", theEmployee);
		
		dispatcher = request.getRequestDispatcher("/views/user-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> theList = userDAO.get();
		
		request.setAttribute("list", theList);
		
		dispatcher = request.getRequestDispatcher("/views/user-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		User user = new User();
		user.setFirstName(request.getParameter("FirstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setAge(Integer.valueOf(request.getParameter("age")));
		user.setNif(request.getParameter("nif"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("Password"));
		
		

		
		if(id.isEmpty() || id == null) {
			
			if(userDAO.save(user)) {
				request.setAttribute("NOTIFICATION", "User Saved Successfully!");
			}
		
		}else {
			
			user.setId(Long.parseLong(id));
			if(userDAO.update(user)) {
				request.setAttribute("NOTIFICATION", "User Updated Successfully!");
			}
			
		}
		
		listUser(request, response);
	}

}