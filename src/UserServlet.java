

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Manuser;

import processor.ProcessUser;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();

	        if (request.getParameter("click").equals("1")) {

	            String username = request.getParameter("username");
	            String password = request.getParameter("password");
	            System.out.println("user = " + username);
	            if (username == null || username.isEmpty()|| password == null || password.isEmpty())
	            {
	            	//System.out.println("userid for " + username + " not found");
	                String error = ("Please enter valid username and password");
	                request.setAttribute("error", error);
	                request.getRequestDispatcher("/error.jsp").forward(request, response);
	            }
	            long userid = ProcessUser.userLogin(username,password); //checking for user
	            
	            if (userid == 0) {

	                System.out.println("userid for " + username + " not found");
	                String error = ("userid for " + username + " not found");
	                request.setAttribute("error", error);
	                request.getRequestDispatcher("/error.jsp").forward(request, response);
	            }
	            else {

	               Manuser users = null;

	                users = ProcessUser.userLogin(username,password); //getting the user and assigning the user
	             
	                if (users != null)
	                {
	                	
	                session.setAttribute("username", username);
	                session.setAttribute("userid", userid);
	                session.setAttribute("username", users);
	                }
	                request.getRequestDispatcher("/AccountPage.jsp").forward(request, response);

	            }

	        }
	}

}
