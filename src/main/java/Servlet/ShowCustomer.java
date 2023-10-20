package Servlet;

import Dao.Resolve.Customeriml;
import Entities.CustomerEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

@WebServlet(name = "ShowCustomer", value = "/ShowCustomer-servlet")
public class ShowCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ArrayList<CustomerEntity> Array = new ArrayList<>();
        try {
            Customeriml data = new Customeriml();
            Array = data.GetListCus();
            //System.out.println("count: " + Array.size());
            for (CustomerEntity x : Array) {
                System.out.println(data.toString());
            }
            int CountPage = Array.size()/2;
            req.setAttribute("List" , Array);
            System.out.println("count: " + CountPage);
            req.setAttribute("CountPage" , CountPage);
            req.getRequestDispatcher("View/ShowPage.jsp").forward(req , resp);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
//        Writer writer = resp.getWriter();
//        writer.write("<html>" +
//                "<head>\n" +
//                "<style>\n" +
//                ".button {\n" +
//                "  border: none;\n" +
//                "  color: white;\n" +
//                "  padding: 15px 32px;\n" +
//                "  text-align: center;\n" +
//                "  text-decoration: none;\n" +
//                "  display: inline-block;\n" +
//                "  font-size: 16px;\n" +
//                "  margin: 4px 2px;\n" +
//                "  cursor: pointer;\n" +
//                "}" +
//                "table {\n" +
//                "  font-family: arial, sans-serif;\n" +
//                "  border-collapse: collapse;\n" +
//                "  width: 100%;\n" +
//                "}\n" +
//                "\n" +
//                "td, th {\n" +
//                "  border: 1px solid #dddddd;\n" +
//                "  text-align: left;\n" +
//                "  padding: 8px;\n" +
//                "}\n" +
//                "\n" +
//                "tr:nth-child(even) {\n" +
//                "  background-color: #dddddd;\n" +
//                "}\n" +
//                "</style>\n" +
//                "</head>" +
//                "<body>");
//        writer.write("<a href='/demo/AddNewCusTomer-servlet'>Visit W3Schools.com!</a>");
//        writer.write("<table>");
//        writer.write("<tr>");
//        writer.write("<th>CusID</th>");
//        writer.write("<th>FirstName</th>");
//        writer.write("<th>LastName</th>");
//        writer.write("<th>Address</th>");
//        writer.write("<th>Birthday</th>");
//        writer.write("<th>Gender</th>");
//        writer.write(" </tr>");
//        for ( CustomerEntity data : Array ) {
//            writer.write("<tr>");
//            writer.write("<td>"+data.getCusId()+"</td>");
//            writer.write("<td>"+data.getFirstName()+"</td>");
//            writer.write("<td>"+data.getLastName()+"</td>");
//            writer.write("<td>"+data.getAddress()+"</td>");
//            writer.write("<td>"+data.getBirthday()+"</td>");
//            writer.write("<td>"+data.getGender()+"</td>");
//            writer.write(" </tr>");
//        }
//        writer.write("</table>");
//        writer.write("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
