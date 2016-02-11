package servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ShoppingCart;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCartServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session
				.getAttribute(ShoppingCart.ATTRIBUTE_NAME);

		// just added new param
		String id = request.getParameter("productID");
		System.out.println(id);

		if (id != null) {
			cart.addProduct(id, 1);

		} else {
			Enumeration<String> params = request.getParameterNames();
			ShoppingCart newCart = new ShoppingCart();
			while (params.hasMoreElements()) {
				id = params.nextElement();
				newCart.addProduct(id, request.getParameter(id),
						cart.getQuantityOf(id));
			}
			cart = newCart;
		}

		session.setAttribute(ShoppingCart.ATTRIBUTE_NAME, cart);

		RequestDispatcher rd = request
				.getRequestDispatcher("shoppingCart.jsp");
		rd.forward(request, response);

	}

}
