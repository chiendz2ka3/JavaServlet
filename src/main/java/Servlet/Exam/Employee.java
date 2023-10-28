package Servlet.Exam;

import Dao.Resolve.EmployeeIPM;
import Entities.EmployeeEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.annotations.Check;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;

@WebServlet(name = "Employee", value = "/Employee-servlet")
public class Employee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //resp.sendRedirect("Examl/Employee.jsp");
        System.out.println("daaaaaa");
        req.getRequestDispatcher("xaml/Employee.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("da log vao duoc ham");
        try {
            String FullName = req.getParameter("FullName");
            String Addres = req.getParameter("Addres");
            LocalDate date = LocalDate.parse(req.getParameter("Birthday"));
            java.sql.Date Birthday = java.sql.Date.valueOf(date);
            String Position = req.getParameter("Positon");
           // CustomerEntity data = new CustomerEntity(FirstName , LastName ,Address , sqlDate, (Gender>0)?true:false);
            EmployeeEntity data = new EmployeeEntity(FullName , Birthday , Addres , Position);
            System.out.println(data.toString());
            EmployeeIPM Customer = new EmployeeIPM();
            if(FullName=="" || Addres==""|| Position ==""){
                resp.sendRedirect("Employee-servlet");
                return;
            }
            boolean checks = Customer.AddNewEmployee(data);
            if(checks){
                resp.sendRedirect("ListEmployee-servlet");
            }else {
                System.out.println("Error");
            }
        }catch (Exception E) {
            System.err.println(E.getMessage());
        }
    }
}
