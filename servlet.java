
import java.io.IOException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sqlapp.exampledb;
import sqlapp.users;

@WebServlet("/create")
public class serv extends HttpServlet {
    public serv() {
        super();
        // TODO Auto-generated constructor stub
    }
		// TODO Auto-generated method stub
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
     
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {   
            try {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String patronymic = request.getParameter("patronymic");
                String city = request.getParameter("city");
                String street = request.getParameter("street");
                String telnumb = request.getParameter("telnumb"); 
                String email = request.getParameter("email");
                String wifi = request.getParameter("wifi");
                String mobileinternet = request.getParameter("mobileint");
                String TV = request.getParameter("tv");
                String password = request.getParameter("password");
               users users = new users(name, surname, patronymic, city, street, telnumb, email, wifi, mobileinternet, TV,password);
               exampledb.insert(users);               
              // response.sendRedirect(request.getContextPath()+"/create");
            }
            catch(Exception ex) {
                 
                //getServletContext().getRequestDispatcher("/create.jsp").forward(request, response); 
            }
        }
    
}
