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
        Writer writer = resp.getWriter();
        System.out.println("=upload//////");
        writer.write("<h1>anh chien dz</h1>");
        try {
            Customeriml data = new Customeriml();
            ArrayList<CustomerEntity> Array = new ArrayList<>();
            Array = data.GetListCus();
            System.out.println("count: " +Array.size());
            for (CustomerEntity x : Array) {
                System.out.println(data.toString());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
