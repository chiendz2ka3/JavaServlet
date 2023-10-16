package Servlet;

import Dao.Resolve.Customeriml;
import Entities.CustomerEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.annotations.Check;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;

@WebServlet(name = "AddNewCusTomer", value = "/AddNewCusTomer-servlet")
public class AddNewCusTomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
//       try {
//
//           resp.setContentType("text/html");
//           Writer writer = resp.getWriter();
//           writer.write("<html><body>");
//           writer.write("<form action='AddNewCusTomer-servlet' method='POST' >");
//           writer.write("<label for=\"fname\">First name:</label><br>");
//           writer.write("<input type='text' name='FirstName' />");
//           writer.write("<br><label for=\"fname\">Last Name:</label><br>");
//           writer.write("<input type='text' name='LastName' />");
//           writer.write("<br><label for=\"fname\">Address:</label><br>");
//           writer.write("<input type='text' name='Address' />");
//           writer.write("<br><label for=\"fname\">Birthday:</label><br>");
//           writer.write("<input type='date' name='Birthday' />");
//           writer.write("<br><label for=\"fname\">Select Gender:</label><br>");
//           writer.write("<<select name='Gender' id=\"cars\">\n" +
//                   "    <option value=\"1\">Nam</option>\n" +
//                   "    <option value=\"0\">Nữ</option>\n" +
//                   "  </select> /><br>");
//           writer.write("<input type='submit' value='Submit' />");
//           writer.write("</form>");
//           writer.write("</body></html>");
//       }catch (Exception e){
//            System.out.println(e.getMessage());
//       }
        req.getRequestDispatcher("View/Home.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  super.doPost(req, resp);
        try {
            String FirstName = req.getParameter("FirstName");
            String LastName = req.getParameter("LastName");
            String Address = req.getParameter("Address");
           // SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            LocalDate date = LocalDate.parse(req.getParameter("Birthday"));
          //  Date Birthday = formatter.parse(req.getParameter("Birthday"));
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            int Gender = Integer.parseInt(req.getParameter("Gender"));

            CustomerEntity data = new CustomerEntity(FirstName , LastName ,Address , sqlDate, (Gender>0)?true:false);
            Customeriml Customer = new Customeriml();
           boolean checks = Customer.AddNewCustomer(data);
           if(checks){
                resp.sendRedirect("ShowCustomer-servlet");
           }else {
               System.out.println("Error");
           }
        }catch (Exception E){
            System.err.println(E.getMessage());
        }
    }
}
