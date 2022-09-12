

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet(urlPatterns = {"/session", "/session/setsecret"})
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String mySecret = (String) request.getSession().getAttribute("mySecret");
//		response.getWriter().append("My secret is: ").append(mySecret);
		
		if(request.getRequestURI().contains("setsecret")){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/setsecret.jsp");
			dispatcher.forward(request,response);
		}
		else{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/revelsecret.jsp");
			dispatcher.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String secret = (String) request.getParameter("secret");
		
		request.getSession().setAttribute("mySecret", secret);
		
		response.getWriter().append("Secret saved!");
	}

}
