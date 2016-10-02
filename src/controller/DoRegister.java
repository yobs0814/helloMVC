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
 * Servlet implementation class DoRegister
 */
@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*register 버튼티을 누르면 DoRegister의 doPost()메서드가 service()메서드를 통해 호출된다. 먼저
	 * HTML에서 전달된 폼 요소 값을 프로그램 변수에 매핑학 위한 선언이 있다.*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String customerId = request.getParameter("customerId");/*HTML에서 각 항목은
		request.getParameter()메서드를 통해 얻을 수 있는데, 인자로  HTML 폼 태그에 사용된 각각의 name 속성 값을 가진다.
		이때 중요한 것은 getParameter()메서드는 모든 값을 문자열로 전달되며, 숫자가 필요한 경우에는 Integer.parseInt()
		메서드를 사용해서 int로 변환한다.*/
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		Customer customers = new Customer(customerId, password, name, gender, email);
		CustomerService service = (CustomerService) CustomerService.getInstance();
		service.addCustomer(customers);

		String page;

		page = "/view/registersuccess.jsp";

		request.setAttribute("customer", customers);

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}
