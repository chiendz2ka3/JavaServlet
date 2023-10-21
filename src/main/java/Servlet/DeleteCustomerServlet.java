package Servlet;

import Dao.Resolve.Customeriml;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "DeleteCustomerServlet", value = "/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  super.doGet(req, resp);
        String idcustomer = req.getParameter("sid");
        int id = Integer.parseInt(idcustomer);
        Customeriml customeriml = new Customeriml();
        boolean check = customeriml.DeleteCustomer(id);
        int CountPage = customeriml.GetListCus().size()/2;
        if(customeriml.GetListCus().size()%2!=0) CountPage++;
        req.setAttribute("CountPage" , CountPage);
        if (check) resp.sendRedirect("ShowCustomer-servlet");
        else {
            System.out.println(" you have some error");
            req.getRequestDispatcher("View/ShowPage.jsp").forward(req , resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
