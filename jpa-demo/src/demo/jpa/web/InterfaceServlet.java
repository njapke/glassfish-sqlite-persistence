package demo.jpa.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.jpa.ejb.UserDaoEJBLocal;
import demo.jpa.model.User;

/**
 * Servlet implementation class DbServlet
 */
@WebServlet("/InterfaceServlet")
public class InterfaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserDaoEJBLocal dbbean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = dbbean.getAllUsers();
		request.setAttribute("users", users);
		request.setAttribute("postTo", request.getContextPath());
		getServletContext().getRequestDispatcher("/WEB-INF/interface.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
