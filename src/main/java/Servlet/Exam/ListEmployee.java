package Servlet.Exam;

import Dao.Resolve.Customeriml;
import Dao.Resolve.EmployeeIPM;
import Entities.CustomerEntity;
import Entities.EmployeeEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "ListEmployee", value = "/ListEmployee-servlet")
public class ListEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html");
        System.out.println("da log duco vao ham");
        List<EmployeeEntity> Array = new ArrayList<>();
        try {
            EmployeeIPM data = new EmployeeIPM();
            Array = data.GetListEmploy();
            req.setAttribute("ListEmployee" , Array);
            req.getRequestDispatcher("xaml/list.jsp").forward(req , resp);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
