package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// loginForm.jsp customerId password
		//사용자가 form 에 아이디와 비밀번호를 입력한 것을 가져온다.
		//사용자가 입력할때마다 생기는 request, response 객체다.
		request.setCharacterEncoding("utf-8");
		
		
		String customerId = request.getParameter("customerId"); //실제로 아이디를 가져오는 것
		String password = request.getParameter("password");
		// Perform business logic. Return a bean as a result.

		CustomerService service = (CustomerService) CustomerService.getInstance();
		Customer customer = service.login(customerId, password);
		request.setAttribute("customer", customer); //"request객체에 customer 키값에 customer value값이 들어가서
		//success.jsp 에서 사용할수 있다.

		String page;

		if(customer == null) {
			page = "view/loginFail.jsp";
			request.setAttribute("customer", customerId);
		}else {
			page = "/view/loginSuccess.jsp";
			
			 //"request객체에 customer 키값에 customer value값이 들어가서
			//success.jsp 에서 사용할수 있다.
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}
