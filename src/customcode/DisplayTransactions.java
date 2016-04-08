package customcode;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class DisplayTransactions
 */
@WebServlet("/DisplayTransactions")
public class DisplayTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTransactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		HttpSession session = request.getSession();

		if (request.getParameter("option").equals("1")) {
			// int studentid =
			// Integer.parseInt(request.getParameter("studentid"));
			
			long accountid = (long) session.getAttribute("accountid");
	//		long accountid = Long.parseLong( session.getAttribute("accountid"));
			
			List<Mantransaction> trans = null;

			trans = ProcessTransaction.getAllTransactions(accountid);

			// session.setAttribute("studentid", studentid);
			session.setAttribute("products", products);
			request.getRequestDispatcher("/productlist.jsp").forward(request, response);

		}
		
		
		
	}

}
