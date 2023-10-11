package UploadFile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Login", value = "/Login-servlet")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        System.out.println("=========///////");
        writer.write("<html><body>");
        writer.write("<form action='Login-servlet' method='POST' >");
        writer.write("<input type='text' name='username' />");
        writer.write("<input type='password' name='password' />");
        writer.write("<input type='submit' value='Submit' />");
        writer.write("</form>");
        writer.write("</body></html >");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("=========");
        try {
            String UserName = req.getParameter("username");
            String PassWord = req.getParameter("password");
            if(UserName!=null &&  PassWord!=null){
                System.out.println("???????????????????");
                HttpSession session = req.getSession();
                session.setAttribute("username" , UserName);
                resp.sendRedirect("UploadFile-servlet");
            }else {
                System.out.println("UserName is null");
                resp.sendRedirect("/Login-servlet");
            }
                //resp.sendRedirect("/Login-servlet");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
