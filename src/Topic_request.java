

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Train;
import model.View;

/**
 * Servlet implementation class Topic_request
 */
@WebServlet("/Topic_request")
public class Topic_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Topic_request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sql = request.getParameter("sql");
		System.out.print(sql);
		PrintWriter out = response.getWriter();
		if(Train.Update(sql))
		{
			out.print("success");
		}
		else {
			out.print("fail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String get = "";
		get = Train.JsonAllResult();
		PrintWriter out = response.getWriter();
		out.print(get);
		out.close();
		System.out.print("test");
	}

}
