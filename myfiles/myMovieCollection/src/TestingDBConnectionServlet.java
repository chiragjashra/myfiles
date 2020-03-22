

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestingDBConnectionServlet
 */
@WebServlet("/TestingDBConnectionServlet")
public class TestingDBConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = "hbmovie";
		String password = "hbmovie";

		String uri = "jdbc:mysql://127.0.0.1:3306/hb-movie-collection?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		System.out.println("driver : " + driver);

		try {
			System.out.println("driver : " + driver);
			
			PrintWriter printWriter = response.getWriter();
			printWriter.println("JDBC URI : " + uri);


			Class.forName(driver);

			Connection connection = DriverManager.getConnection(uri, userName, password);

			System.out.println("Blah Blah");
			connection.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}
}

