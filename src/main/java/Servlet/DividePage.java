package Servlet;

import Dao.Resolve.Customeriml;
import Entities.CustomerEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DividePage", value = "/DividePage")
public class DividePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        Customeriml cus = new Customeriml();
        String idpage = req.getParameter("idpage");
        int pageSize = 2;
        int id = Integer.parseInt(idpage);
        List<CustomerEntity> ListNew = new ArrayList<>();
        ListNew = cus.Paging((id) , pageSize);
        int CountPage = cus.GetListCus().size()/pageSize;
        if(cus.GetListCus().size()%pageSize!=0) CountPage++;
        System.out.println("Count: "+ CountPage);
        req.setAttribute("CountPage" , CountPage);
        req.setAttribute("List" , ListNew);
        if(ListNew.size()!=0){
            req.getRequestDispatcher("View/ShowPage.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
